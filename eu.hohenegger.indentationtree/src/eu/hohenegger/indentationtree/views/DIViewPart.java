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

import java.lang.reflect.Method;
import java.util.Iterator;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;
import org.osgi.service.packageadmin.PackageAdmin;

import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;

import eu.hohenegger.indentationtree.Activator;

@SuppressWarnings("restriction")
public abstract class DIViewPart<T extends IPartView> extends ViewPart {
	private IEclipseContext context;
	private Class<T> clazz;
	protected T part;
	private IPropertyChangeListener propertyChangeListener;
	private IEclipseContext ctx;

	public DIViewPart(Class<T> clazz) {
		this.clazz = clazz;
	}

	@Override
	public void init(IViewSite site) throws PartInitException {
		super.init(site);
		
		IEclipseContext parentContext = (IEclipseContext) getSite().getService(IEclipseContext.class);
		if( parentContext.get("org.eclipse.e4.ui.workbench.IPresentationEngine") != null ) {
			try {
				Class<?> clazz = getBundleWithNoInstallState("org.eclipse.e4.ui.model.workbench").loadClass("org.eclipse.e4.ui.model.application.ui.basic.MPart");
				Object instance = getSite().getService(clazz);
				Method m = clazz.getMethod("getContext", new Class[0]);
				ctx = (IEclipseContext) m.invoke(instance);
				context = ctx.createChild();
			} catch (Exception e) {
				throw new PartInitException("Could not create context", e);
			}
		}

		context.declareModifiable(IViewPart.class);

		context.set(IViewPart.class, this);
		
		IPropertyChangeListener propertyChangeListener = new IPropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent event) {
//				IEclipseContext childContext = context.createChild();
//				childContext.remove(PostConstruct.class);
//				childContext.remove(Composite.class);
//				ContextInjectionFactory.invoke(part, Inject.class, context);
//				ContextInjectionFactory.inject(part, childContext);
//				IEclipsePreferences preferences = context.get(IEclipsePreferences.class);
				ContextInjectionFactory.inject(part.getController(), context);
			}
		};
		Activator.getDefault().getPreferenceStore().addPropertyChangeListener(propertyChangeListener); 
	}

	
	
	
	@Override
	public void dispose() {
//		Activator.getDefault().getPreferenceStore().removePropertyChangeListener(propertyChangeListener); //TODO reactivate
		super.dispose();
	}

	private Bundle getBundleWithNoInstallState(String bundleName) {
		Bundle result = null;
		Bundle bundle = FrameworkUtil.getBundle(DIViewPart.class);
		BundleContext bundleContext = bundle.getBundleContext();
		ServiceReference serviceReference = bundle.getBundleContext()
				.getServiceReference(PackageAdmin.class);
		PackageAdmin packageAdmin = (PackageAdmin) bundleContext
				.getService(serviceReference);

		Iterator<Bundle> iterator = emptyIfNull(packageAdmin.getBundles(
				bundleName, null));
		while (iterator.hasNext()) {
			Bundle tmpBundle = (Bundle) iterator.next();

			int bundleState = tmpBundle.getState();
			if (!(bundleState == Bundle.INSTALLED || bundleState == Bundle.UNINSTALLED)) {
				result = tmpBundle;
				break;
			}
		}

		return result;
	}

	public static <F> UnmodifiableIterator<F> emptyIfNull(F[] array) {
		if (array != null) {
			return Iterators.forArray(array);
		}
		return new UnmodifiableIterator<F>() {
			@Override
			public boolean hasNext() {
				return false;
			}

			@Override
			public F next() {
				return null;
			}
		};
	}

	@Override
	public void createPartControl(Composite parent) {
		Composite comp = new Composite(parent, SWT.NONE);
		comp.setBackgroundMode(SWT.INHERIT_DEFAULT);

		comp.setLayout(new FillLayout());

		context.set(Composite.class, comp);
		part = ContextInjectionFactory.make(clazz, context);

	}

	protected IEclipseContext getContext() {
		return context;
	}

	public T getComponent() {
		return part;
	}

	@Override
	public void setFocus() {
		ContextInjectionFactory.invoke(part, Focus.class, context);
	}
}