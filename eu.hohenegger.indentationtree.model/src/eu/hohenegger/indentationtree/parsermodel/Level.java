/**
 * Copyright (c) 2012 Max Hohenegger.
 * All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Max Hohenegger - initial implementation
 */
package eu.hohenegger.indentationtree.parsermodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Level</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.hohenegger.indentationtree.parsermodel.Level#getContent <em>Content</em>}</li>
 *   <li>{@link eu.hohenegger.indentationtree.parsermodel.Level#getParent <em>Parent</em>}</li>
 *   <li>{@link eu.hohenegger.indentationtree.parsermodel.Level#getSubLevel <em>Sub Level</em>}</li>
 *   <li>{@link eu.hohenegger.indentationtree.parsermodel.Level#getLineNumber <em>Line Number</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.hohenegger.indentationtree.parsermodel.ParsermodelPackage#getLevel()
 * @model
 * @generated
 */
public interface Level extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2012 Max Hohenegger.\r\nAll rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse\r\nPublic License v1.0 which accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n    Max Hohenegger - initial implementation";

	/**
	 * Returns the value of the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Content</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Content</em>' attribute.
	 * @see #setContent(String)
	 * @see eu.hohenegger.indentationtree.parsermodel.ParsermodelPackage#getLevel_Content()
	 * @model
	 * @generated
	 */
	String getContent();

	/**
	 * Sets the value of the '{@link eu.hohenegger.indentationtree.parsermodel.Level#getContent <em>Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Content</em>' attribute.
	 * @see #getContent()
	 * @generated
	 */
	void setContent(String value);

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link eu.hohenegger.indentationtree.parsermodel.Level#getSubLevel <em>Sub Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(Level)
	 * @see eu.hohenegger.indentationtree.parsermodel.ParsermodelPackage#getLevel_Parent()
	 * @see eu.hohenegger.indentationtree.parsermodel.Level#getSubLevel
	 * @model opposite="subLevel" transient="false"
	 * @generated
	 */
	Level getParent();

	/**
	 * Sets the value of the '{@link eu.hohenegger.indentationtree.parsermodel.Level#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(Level value);

	/**
	 * Returns the value of the '<em><b>Sub Level</b></em>' containment reference list.
	 * The list contents are of type {@link eu.hohenegger.indentationtree.parsermodel.Level}.
	 * It is bidirectional and its opposite is '{@link eu.hohenegger.indentationtree.parsermodel.Level#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Level</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Level</em>' containment reference list.
	 * @see eu.hohenegger.indentationtree.parsermodel.ParsermodelPackage#getLevel_SubLevel()
	 * @see eu.hohenegger.indentationtree.parsermodel.Level#getParent
	 * @model opposite="parent" containment="true"
	 * @generated
	 */
	EList<Level> getSubLevel();

	/**
	 * Returns the value of the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Line Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Line Number</em>' attribute.
	 * @see #setLineNumber(int)
	 * @see eu.hohenegger.indentationtree.parsermodel.ParsermodelPackage#getLevel_LineNumber()
	 * @model
	 * @generated
	 */
	int getLineNumber();

	/**
	 * Sets the value of the '{@link eu.hohenegger.indentationtree.parsermodel.Level#getLineNumber <em>Line Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Line Number</em>' attribute.
	 * @see #getLineNumber()
	 * @generated
	 */
	void setLineNumber(int value);

} // Level
