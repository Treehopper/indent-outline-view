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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
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
public class SampleView {

	private Pattern pattern = Pattern.compile("^ *");
	private EMFContainmentTreeTable treeViewer;
	private ContainmentRoot root;
	private AbstractTextEditor currentTextEditor;
	private IDocument currentDocument;
	private IElementStateListener currentEditorStateListener;
	private MPart currentEditorPart;
	
	@Inject 
	private EPartService partService;
	
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
		EditingDomain editingDomain = new AdapterFactoryEditingDomain(
				new ComposedAdapterFactory(
						ComposedAdapterFactory.Descriptor.Registry.INSTANCE),
				new BasicCommandStack());
		treeViewer = new EMFContainmentTreeTable(parent, SWT.NONE,
				editingDomain);

		treeViewer.createTableViewerColumn("Text",
				ParsermodelPackage.eINSTANCE.getLevel_Content(), 100);

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

	public void editorActivated(IEditorPart activePart) {
		if (!(activePart instanceof AbstractTextEditor)) {
			return;
		}

		currentTextEditor = (AbstractTextEditor) activePart;

		IEditorInput editorInput = activePart.getEditorInput();

		currentDocument =  currentTextEditor.getDocumentProvider().getDocument(editorInput);
		currentEditorStateListener = new IElementStateListener() {
			@Override
			public void elementMoved(Object originalElement, Object movedElement) {
			}

			@Override
			public void elementDirtyStateChanged(Object element, boolean isDirty) {
				if (isDirty) {
					return;
				}
				IDocumentProvider documentProvider = currentTextEditor.getDocumentProvider();
				final IDocument document = documentProvider.getDocument(element);
				setInput(parse(document));
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

		// TODO: remove commented code or use it to update view on document
		// change.
		// document.addDocumentListener(new IDocumentListener() {
		//
		// @Override
		// public void documentChanged(DocumentEvent event) {
		// // System.out.println(event);
		// }
		//
		// @Override
		// public void documentAboutToBeChanged(DocumentEvent event) {
		// }
		// });

		Level topLevel = parse(currentDocument);

		setInput(topLevel);

		// TODO: remove commented code or sync editor selection with view.
		// editorListener = new ISelectionChangedListener() {
		// @Override
		// public void selectionChanged(SelectionChangedEvent event) {
		// TextSelection selection = (TextSelection) event.getSelection();
		// TreeIterator<EObject> eAllContents =
		// root.getTopLevel().eAllContents();
		// while (eAllContents.hasNext()) {
		// EObject eObject = eAllContents.next();
		// if (eObject instanceof Level) {
		// Level level = (Level) eObject;
		// if (level.getLineNumber() == selection.getStartLine()) {
		// treeViewer.setRedraw(false);
		// treeViewer.getViewer().getControl().setEnabled(false);
		// treeViewer.getViewer().setSelection(new TreeSelection(new
		// TreePath(new Object[] {level} )), true);
		// treeViewer.getViewer().getControl().setEnabled(true);
		// treeViewer.setRedraw(true);
		// }
		// }
		// }
		// }
		// };
		// TODO: remove listener when part is switched
		// textEditor.getSelectionProvider().addSelectionChangedListener(editorListener);
	}
	
	public void editorDeActivated(IEditorPart editor) {
		if (currentTextEditor == null || currentTextEditor.getDocumentProvider() == null || treeViewer == null || treeViewer.isDisposed()) {
			return;
		}
		currentTextEditor.getDocumentProvider().removeElementStateListener(currentEditorStateListener);
		treeViewer.getViewer().setInput(null);
	}

	private Level parse(IDocument document) {
		root = ParsermodelFactory.eINSTANCE.createContainmentRoot();
		root.setTopLevel(ParsermodelFactory.eINSTANCE.createLevel());

		Level currentLevel = root.getTopLevel();

		int oldLevelCount = -1;
		int numberOfLines = document.getNumberOfLines();
		Level previouslyAddedLevel = root.getTopLevel();
		Level newSubLevel;
		int levelCount = -1;

		for (int i = 0; i < numberOfLines; i++) {
			IRegion lineInformation;
			newSubLevel = ParsermodelFactory.eINSTANCE.createLevel();
			try {
				lineInformation = document.getLineInformation(i);
				String string = document.get(lineInformation.getOffset(),
						lineInformation.getLength());

				Matcher matcher = pattern.matcher(string);
				matcher.find();
				String group = matcher.group();
				levelCount = group.length();
				string = matcher.replaceFirst("");

				newSubLevel.setContent(string);
				newSubLevel.setLineNumber(i);
				if (oldLevelCount < levelCount) {
					previouslyAddedLevel.getSubLevel().add(newSubLevel);
				} else if (oldLevelCount == levelCount) {
					previouslyAddedLevel.getParent().getSubLevel()
							.add(newSubLevel);
				} else {
					currentLevel = previouslyAddedLevel;
					int diff = oldLevelCount - levelCount;
					for (int j = 0; j < diff + 1; j++) {
						if (currentLevel.getParent() == null) {
							break;
						}
						currentLevel = currentLevel.getParent();
					}
					currentLevel.getSubLevel().add(newSubLevel);
				}

			} catch (BadLocationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			oldLevelCount = levelCount;
			previouslyAddedLevel = newSubLevel;
		}

		return root.getTopLevel();
	}

	private void setInput(Level topLevel) {
		treeViewer.setRedraw(false);
		treeViewer.setInput(ParsermodelPackage.eINSTANCE.getLevel_SubLevel(),
				topLevel);
		treeViewer.getViewer().expandAll();
		treeViewer.setRedraw(true);
	}
}