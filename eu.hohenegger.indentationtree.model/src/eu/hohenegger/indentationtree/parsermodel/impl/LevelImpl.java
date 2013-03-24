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

import eu.hohenegger.indentationtree.parsermodel.Level;
import eu.hohenegger.indentationtree.parsermodel.ParsermodelPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Level</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.hohenegger.indentationtree.parsermodel.impl.LevelImpl#getContent <em>Content</em>}</li>
 *   <li>{@link eu.hohenegger.indentationtree.parsermodel.impl.LevelImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link eu.hohenegger.indentationtree.parsermodel.impl.LevelImpl#getSubLevel <em>Sub Level</em>}</li>
 *   <li>{@link eu.hohenegger.indentationtree.parsermodel.impl.LevelImpl#getLineNumber <em>Line Number</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LevelImpl extends EObjectImpl implements Level {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2012 Max Hohenegger.\r\nAll rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse\r\nPublic License v1.0 which accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n    Max Hohenegger - initial implementation";

	/**
	 * The default value of the '{@link #getContent() <em>Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContent()
	 * @generated
	 * @ordered
	 */
	protected static final String CONTENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getContent() <em>Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContent()
	 * @generated
	 * @ordered
	 */
	protected String content = CONTENT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSubLevel() <em>Sub Level</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubLevel()
	 * @generated
	 * @ordered
	 */
	protected EList<Level> subLevel;

	/**
	 * The default value of the '{@link #getLineNumber() <em>Line Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLineNumber()
	 * @generated
	 * @ordered
	 */
	protected static final int LINE_NUMBER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getLineNumber() <em>Line Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLineNumber()
	 * @generated
	 * @ordered
	 */
	protected int lineNumber = LINE_NUMBER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LevelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ParsermodelPackage.Literals.LEVEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getContent() {
		return content;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContent(String newContent) {
		String oldContent = content;
		content = newContent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParsermodelPackage.LEVEL__CONTENT, oldContent, content));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Level getParent() {
		if (eContainerFeatureID() != ParsermodelPackage.LEVEL__PARENT) return null;
		return (Level)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParent(Level newParent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParent, ParsermodelPackage.LEVEL__PARENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(Level newParent) {
		if (newParent != eInternalContainer() || (eContainerFeatureID() != ParsermodelPackage.LEVEL__PARENT && newParent != null)) {
			if (EcoreUtil.isAncestor(this, newParent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParent != null)
				msgs = ((InternalEObject)newParent).eInverseAdd(this, ParsermodelPackage.LEVEL__SUB_LEVEL, Level.class, msgs);
			msgs = basicSetParent(newParent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParsermodelPackage.LEVEL__PARENT, newParent, newParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Level> getSubLevel() {
		if (subLevel == null) {
			subLevel = new EObjectContainmentWithInverseEList<Level>(Level.class, this, ParsermodelPackage.LEVEL__SUB_LEVEL, ParsermodelPackage.LEVEL__PARENT);
		}
		return subLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLineNumber() {
		return lineNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLineNumber(int newLineNumber) {
		int oldLineNumber = lineNumber;
		lineNumber = newLineNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParsermodelPackage.LEVEL__LINE_NUMBER, oldLineNumber, lineNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ParsermodelPackage.LEVEL__PARENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParent((Level)otherEnd, msgs);
			case ParsermodelPackage.LEVEL__SUB_LEVEL:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSubLevel()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ParsermodelPackage.LEVEL__PARENT:
				return basicSetParent(null, msgs);
			case ParsermodelPackage.LEVEL__SUB_LEVEL:
				return ((InternalEList<?>)getSubLevel()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case ParsermodelPackage.LEVEL__PARENT:
				return eInternalContainer().eInverseRemove(this, ParsermodelPackage.LEVEL__SUB_LEVEL, Level.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ParsermodelPackage.LEVEL__CONTENT:
				return getContent();
			case ParsermodelPackage.LEVEL__PARENT:
				return getParent();
			case ParsermodelPackage.LEVEL__SUB_LEVEL:
				return getSubLevel();
			case ParsermodelPackage.LEVEL__LINE_NUMBER:
				return getLineNumber();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ParsermodelPackage.LEVEL__CONTENT:
				setContent((String)newValue);
				return;
			case ParsermodelPackage.LEVEL__PARENT:
				setParent((Level)newValue);
				return;
			case ParsermodelPackage.LEVEL__SUB_LEVEL:
				getSubLevel().clear();
				getSubLevel().addAll((Collection<? extends Level>)newValue);
				return;
			case ParsermodelPackage.LEVEL__LINE_NUMBER:
				setLineNumber((Integer)newValue);
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
			case ParsermodelPackage.LEVEL__CONTENT:
				setContent(CONTENT_EDEFAULT);
				return;
			case ParsermodelPackage.LEVEL__PARENT:
				setParent((Level)null);
				return;
			case ParsermodelPackage.LEVEL__SUB_LEVEL:
				getSubLevel().clear();
				return;
			case ParsermodelPackage.LEVEL__LINE_NUMBER:
				setLineNumber(LINE_NUMBER_EDEFAULT);
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
			case ParsermodelPackage.LEVEL__CONTENT:
				return CONTENT_EDEFAULT == null ? content != null : !CONTENT_EDEFAULT.equals(content);
			case ParsermodelPackage.LEVEL__PARENT:
				return getParent() != null;
			case ParsermodelPackage.LEVEL__SUB_LEVEL:
				return subLevel != null && !subLevel.isEmpty();
			case ParsermodelPackage.LEVEL__LINE_NUMBER:
				return lineNumber != LINE_NUMBER_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (content: ");
		result.append(content);
		result.append(", lineNumber: ");
		result.append(lineNumber);
		result.append(')');
		return result.toString();
	}

} //LevelImpl
