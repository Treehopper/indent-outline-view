/*******************************************************************************
 * Copyright (c) 2012 Max Hohenegger.
 * All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Max Hohenegger - initial implementation
 ******************************************************************************/
package eu.hohenegger.indentationtree.views;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.internal.e4.compatibility.CompatibilityEditor;
import org.eclipse.ui.texteditor.AbstractTextEditor;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.IElementStateListener;

import eu.hohenegger.emfviewer.EMFContainmentTreeTable;
import eu.hohenegger.indentationtree.parsermodel.ContainmentRoot;
import eu.hohenegger.indentationtree.parsermodel.Level;
import eu.hohenegger.indentationtree.parsermodel.ParsermodelFactory;
import eu.hohenegger.indentationtree.parsermodel.ParsermodelPackage;

@SuppressWarnings("restriction")
public class IndentOutlineView implements IPartView {

	private Pattern tabsOrSpaces = Pattern.compile("^(\\s|\\t)*");
	private Pattern emptyLine = Pattern.compile("^$");

	private EMFContainmentTreeTable treeViewer;
	private ContainmentRoot root;
	private AbstractTextEditor currentTextEditor;
	private IDocument currentDocument;
	private IElementStateListener currentEditorStateListener;
	private MPart currentEditorPart;

	@Inject
	private IEclipseContext context;
	private IPartController controller;

	@Inject
	public IndentOutlineView() {
		controller = ContextInjectionFactory.make(PartController.class, context);
		controller.setView(this);
	}

	@Inject
	public void setActivePart(@Named(IServiceConstants.ACTIVE_PART) MPart activePart) {
		if (treeViewer == null || treeViewer.isDisposed()) {
			return;
		}

		if (activePart == null) {
			editorDeActivated(null);
		} else if (activePart.getObject() instanceof CompatibilityEditor) {
			if (currentEditorPart == activePart) {
				return;
			}
			this.currentEditorPart = activePart;
			CompatibilityEditor compatibilityEditor = (CompatibilityEditor) activePart.getObject();
			editorActivated(compatibilityEditor.getEditor());
		}
	}

	@PostConstruct
	public void createPartControl(Composite parent) {
		parent.setLayout(new FillLayout());
		EditingDomain editingDomain = new AdapterFactoryEditingDomain(new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE), new BasicCommandStack());
		treeViewer = new EMFContainmentTreeTable(parent, SWT.NONE, editingDomain);

		treeViewer.createTableViewerColumn("Text", ParsermodelPackage.eINSTANCE.getLevel_Content(), 100);

		ISelectionChangedListener treeViewerListener = new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				TreeSelection selection = (TreeSelection) event.getSelection();
				Level firstElement = (Level) selection.getFirstElement();
				if (firstElement == null) {
					return;
				}
				int lineNumber = firstElement.getLineNumber();
				try {
					IRegion lineInfo = currentDocument.getLineInformation(lineNumber);
					if (lineInfo != null) {
						currentTextEditor.selectAndReveal(lineInfo.getOffset(), lineInfo.getLength());
					}
				} catch (BadLocationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		treeViewer.getViewer().addSelectionChangedListener(treeViewerListener);
	}

	@Focus
	public void setFocus() {
		treeViewer.getViewer().getTree().setFocus();
	}

	@Override
	public void refreshInput() {
		if (currentTextEditor == null) {
			return;
		}
		IDocumentProvider documentProvider = currentTextEditor.getDocumentProvider();
		IEditorInput editorInput = currentTextEditor.getEditorInput();
		final IDocument document = documentProvider.getDocument(editorInput);
		setInput(parse(document));
	}

	public void editorActivated(IEditorPart activePart) {
		if (!(activePart instanceof AbstractTextEditor)) {
			return;
		}

		currentTextEditor = (AbstractTextEditor) activePart;

		IEditorInput editorInput = activePart.getEditorInput();

		currentDocument = currentTextEditor.getDocumentProvider().getDocument(editorInput);
		currentEditorStateListener = new IElementStateListener() {
			@Override
			public void elementMoved(Object originalElement, Object movedElement) {
			}

			@Override
			public void elementDirtyStateChanged(Object element, boolean isDirty) {
				if (isDirty) {
					return;
				}
				refreshInput();
			}

			@Override
			public void elementDeleted(Object element) {
			}

			@Override
			public void elementContentReplaced(Object element) {
			}

			@Override
			public void elementContentAboutToBeReplaced(Object element) {
			}
		};
		currentTextEditor.getDocumentProvider().addElementStateListener(currentEditorStateListener);

		if (currentDocument == null) {
			return;
		}

		Level topLevel = parse(currentDocument);

		setInput(topLevel);
	}

	public void editorDeActivated(IEditorPart editor) {
		if (currentTextEditor == null || currentTextEditor.getDocumentProvider() == null || treeViewer == null
				|| treeViewer.isDisposed()) {
			return;
		}
		currentTextEditor.getDocumentProvider().removeElementStateListener(currentEditorStateListener);
		treeViewer.getViewer().setInput(null);
	}

	private String translateTabsToSpaces(int tabWidth) {
		String spaceTab = "";
		for (int i = 0; i < tabWidth; i++) {
			spaceTab = spaceTab + " ";
		}
		return spaceTab;
	}

	private static Map<String, IndentTuple> lineToIndentLength = new HashMap<>();

	private class IndentTuple {
		private int indentLevel;
		private String content;

		public IndentTuple(String string, String spaceTab) {
			IndentTuple cachedIndentTuple = lineToIndentLength.get(string);
			if (cachedIndentTuple != null) {
				indentLevel = cachedIndentTuple.indentLevel;
				content = cachedIndentTuple.content;

				return;
			}

			Matcher matcher = tabsOrSpaces.matcher(string);
			matcher.find();
			String group = matcher.group();

			indentLevel = group.replaceAll("\\t", spaceTab).length();
			content = matcher.replaceFirst("");

			lineToIndentLength.put(string, this);
		}
	}

	private Level parse(IDocument document) {
		String spaceTab = translateTabsToSpaces(getController().getTabWidth());

		root = ParsermodelFactory.eINSTANCE.createContainmentRoot();
		root.setTopLevel(ParsermodelFactory.eINSTANCE.createLevel());

		Level currentLevel = root.getTopLevel();
		currentLevel.setIndentLength(-1);

		int numberOfLines = document.getNumberOfLines();
		Level previouslyAddedLevel = root.getTopLevel();
		Level newSubLevel;

		for (int i = 0; i < numberOfLines; i++) {
			Level tmpLevel = previouslyAddedLevel;

			IRegion lineInformation;
			newSubLevel = ParsermodelFactory.eINSTANCE.createLevel();
			try {
				lineInformation = document.getLineInformation(i);
				String string = document.get(lineInformation.getOffset(), lineInformation.getLength());

				if (getController().isEmptyLineSkipped() && emptyLine.matcher(string).matches()) {
					continue;
				}

				IndentTuple indentTuple = new IndentTuple(string, spaceTab);
				newSubLevel.setIndentLength(indentTuple.indentLevel);
				string = indentTuple.content;

				newSubLevel.setContent(string);
				newSubLevel.setLineNumber(i);
				if (previouslyAddedLevel.getIndentLength() == newSubLevel.getIndentLength()) {
					tmpLevel = previouslyAddedLevel.getParent();
				} else if (previouslyAddedLevel.getIndentLength() > newSubLevel.getIndentLength()) {
					currentLevel = previouslyAddedLevel;
					int diff = previouslyAddedLevel.getIndentLength() - newSubLevel.getIndentLength();

					int j = 0;
					while (j <= diff) {
						Level parentLevel = currentLevel.getParent();
						if (parentLevel == null) {
							break;
						}
						j = j + (currentLevel.getIndentLength() - parentLevel.getIndentLength());

						currentLevel = parentLevel;
					}

					tmpLevel = currentLevel;
				}

			} catch (BadLocationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tmpLevel.getSubLevel().add(newSubLevel);

			previouslyAddedLevel = newSubLevel;
		}

		return root.getTopLevel();
	}

	private void setInput(Level topLevel) {
		treeViewer.setRedraw(false);
		treeViewer.setInput(ParsermodelPackage.eINSTANCE.getLevel_SubLevel(), topLevel);
		treeViewer.getViewer().expandAll();
		treeViewer.setRedraw(true);
	}

	@Override
	public IPartController getController() {
		return controller;
	}
}