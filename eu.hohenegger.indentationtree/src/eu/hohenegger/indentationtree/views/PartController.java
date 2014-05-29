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

import javax.inject.Inject;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.e4.core.di.extensions.Preference;
import org.eclipse.ui.texteditor.AbstractDecoratedTextEditorPreferenceConstants;

import eu.hohenegger.indentationtree.Activator;
import eu.hohenegger.indentationtree.prefs.PreferencePage;

public final class PartController implements IPartController {
	private int tabWidth;
	private boolean filterEmptyLines;
	private IndentOutlineView sampleView;

	@Inject
	public void setFilterEmptyLines(@Preference(nodePath = Activator.PLUGIN_ID) IEclipsePreferences prefs) {
		filterEmptyLines = prefs.getBoolean(PreferencePage.EDITOR_FILTER_EMPTY_LINES, true);
		if (sampleView == null) {
			return;
		}
		sampleView.refreshInput();
	}

	@Inject
	public void setTabWidth(@Preference(nodePath = "org.eclipse.ui.editors.general") IEclipsePreferences prefs) {
		tabWidth = prefs.getInt(AbstractDecoratedTextEditorPreferenceConstants.EDITOR_TAB_WIDTH, 4);
		if (sampleView == null) {
			return;
		}
		sampleView.refreshInput();
	}

	@Override
	public void setView(IndentOutlineView sampleView) {
		this.sampleView = sampleView;

	}

	@Override
	public int getTabWidth() {
		return tabWidth;
	}

	@Override
	public boolean isEmptyLineSkipped() {
		return filterEmptyLines;
	}

}
