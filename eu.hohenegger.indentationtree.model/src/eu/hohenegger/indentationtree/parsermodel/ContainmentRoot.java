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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Containment Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.hohenegger.indentationtree.parsermodel.ContainmentRoot#getTopLevel <em>Top Level</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.hohenegger.indentationtree.parsermodel.ParsermodelPackage#getContainmentRoot()
 * @model
 * @generated
 */
public interface ContainmentRoot extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2012 Max Hohenegger.\r\nAll rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse\r\nPublic License v1.0 which accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n    Max Hohenegger - initial implementation";

	/**
	 * Returns the value of the '<em><b>Top Level</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Top Level</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Top Level</em>' containment reference.
	 * @see #setTopLevel(Level)
	 * @see eu.hohenegger.indentationtree.parsermodel.ParsermodelPackage#getContainmentRoot_TopLevel()
	 * @model containment="true"
	 * @generated
	 */
	Level getTopLevel();

	/**
	 * Sets the value of the '{@link eu.hohenegger.indentationtree.parsermodel.ContainmentRoot#getTopLevel <em>Top Level</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Top Level</em>' containment reference.
	 * @see #getTopLevel()
	 * @generated
	 */
	void setTopLevel(Level value);

} // ContainmentRoot
