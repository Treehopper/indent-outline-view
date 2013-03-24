/**
 * Copyright (c) 2012 Max Hohenegger.
 * All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Max Hohenegger - initial implementation
 */
package eu.hohenegger.indentationtree.parsermodel.impl;

import eu.hohenegger.indentationtree.parsermodel.ContainmentRoot;
import eu.hohenegger.indentationtree.parsermodel.Level;
import eu.hohenegger.indentationtree.parsermodel.ParsermodelPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Containment Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.hohenegger.indentationtree.parsermodel.impl.ContainmentRootImpl#getTopLevel <em>Top Level</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ContainmentRootImpl extends EObjectImpl implements ContainmentRoot {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2012 Max Hohenegger.\r\nAll rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse\r\nPublic License v1.0 which accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n    Max Hohenegger - initial implementation";

	/**
	 * The cached value of the '{@link #getTopLevel() <em>Top Level</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTopLevel()
	 * @generated
	 * @ordered
	 */
	protected Level topLevel;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContainmentRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ParsermodelPackage.Literals.CONTAINMENT_ROOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Level getTopLevel() {
		return topLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTopLevel(Level newTopLevel, NotificationChain msgs) {
		Level oldTopLevel = topLevel;
		topLevel = newTopLevel;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParsermodelPackage.CONTAINMENT_ROOT__TOP_LEVEL, oldTopLevel, newTopLevel);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTopLevel(Level newTopLevel) {
		if (newTopLevel != topLevel) {
			NotificationChain msgs = null;
			if (topLevel != null)
				msgs = ((InternalEObject)topLevel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParsermodelPackage.CONTAINMENT_ROOT__TOP_LEVEL, null, msgs);
			if (newTopLevel != null)
				msgs = ((InternalEObject)newTopLevel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ParsermodelPackage.CONTAINMENT_ROOT__TOP_LEVEL, null, msgs);
			msgs = basicSetTopLevel(newTopLevel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParsermodelPackage.CONTAINMENT_ROOT__TOP_LEVEL, newTopLevel, newTopLevel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ParsermodelPackage.CONTAINMENT_ROOT__TOP_LEVEL:
				return basicSetTopLevel(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ParsermodelPackage.CONTAINMENT_ROOT__TOP_LEVEL:
				return getTopLevel();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ParsermodelPackage.CONTAINMENT_ROOT__TOP_LEVEL:
				setTopLevel((Level)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ParsermodelPackage.CONTAINMENT_ROOT__TOP_LEVEL:
				setTopLevel((Level)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ParsermodelPackage.CONTAINMENT_ROOT__TOP_LEVEL:
				return topLevel != null;
		}
		return super.eIsSet(featureID);
	}

} //ContainmentRootImpl
