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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see eu.hohenegger.indentationtree.parsermodel.ParsermodelFactory
 * @model kind="package"
 * @generated
 */
public interface ParsermodelPackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2012 Max Hohenegger.\r\nAll rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse\r\nPublic License v1.0 which accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n\r\nContributors:\r\n    Max Hohenegger - initial implementation";

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "parsermodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://hohenegger.eu/indentationtree";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "eu.hohenegger.indentationtree";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ParsermodelPackage eINSTANCE = eu.hohenegger.indentationtree.parsermodel.impl.ParsermodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link eu.hohenegger.indentationtree.parsermodel.impl.ContainmentRootImpl <em>Containment Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.hohenegger.indentationtree.parsermodel.impl.ContainmentRootImpl
	 * @see eu.hohenegger.indentationtree.parsermodel.impl.ParsermodelPackageImpl#getContainmentRoot()
	 * @generated
	 */
	int CONTAINMENT_ROOT = 0;

	/**
	 * The feature id for the '<em><b>Top Level</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINMENT_ROOT__TOP_LEVEL = 0;

	/**
	 * The number of structural features of the '<em>Containment Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINMENT_ROOT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link eu.hohenegger.indentationtree.parsermodel.impl.LevelImpl <em>Level</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.hohenegger.indentationtree.parsermodel.impl.LevelImpl
	 * @see eu.hohenegger.indentationtree.parsermodel.impl.ParsermodelPackageImpl#getLevel()
	 * @generated
	 */
	int LEVEL = 1;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEVEL__CONTENT = 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEVEL__PARENT = 1;

	/**
	 * The feature id for the '<em><b>Sub Level</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEVEL__SUB_LEVEL = 2;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEVEL__LINE_NUMBER = 3;

	/**
	 * The number of structural features of the '<em>Level</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEVEL_FEATURE_COUNT = 4;


	/**
	 * Returns the meta object for class '{@link eu.hohenegger.indentationtree.parsermodel.ContainmentRoot <em>Containment Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Containment Root</em>'.
	 * @see eu.hohenegger.indentationtree.parsermodel.ContainmentRoot
	 * @generated
	 */
	EClass getContainmentRoot();

	/**
	 * Returns the meta object for the containment reference '{@link eu.hohenegger.indentationtree.parsermodel.ContainmentRoot#getTopLevel <em>Top Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Top Level</em>'.
	 * @see eu.hohenegger.indentationtree.parsermodel.ContainmentRoot#getTopLevel()
	 * @see #getContainmentRoot()
	 * @generated
	 */
	EReference getContainmentRoot_TopLevel();

	/**
	 * Returns the meta object for class '{@link eu.hohenegger.indentationtree.parsermodel.Level <em>Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Level</em>'.
	 * @see eu.hohenegger.indentationtree.parsermodel.Level
	 * @generated
	 */
	EClass getLevel();

	/**
	 * Returns the meta object for the attribute '{@link eu.hohenegger.indentationtree.parsermodel.Level#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Content</em>'.
	 * @see eu.hohenegger.indentationtree.parsermodel.Level#getContent()
	 * @see #getLevel()
	 * @generated
	 */
	EAttribute getLevel_Content();

	/**
	 * Returns the meta object for the container reference '{@link eu.hohenegger.indentationtree.parsermodel.Level#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see eu.hohenegger.indentationtree.parsermodel.Level#getParent()
	 * @see #getLevel()
	 * @generated
	 */
	EReference getLevel_Parent();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.hohenegger.indentationtree.parsermodel.Level#getSubLevel <em>Sub Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Level</em>'.
	 * @see eu.hohenegger.indentationtree.parsermodel.Level#getSubLevel()
	 * @see #getLevel()
	 * @generated
	 */
	EReference getLevel_SubLevel();

	/**
	 * Returns the meta object for the attribute '{@link eu.hohenegger.indentationtree.parsermodel.Level#getLineNumber <em>Line Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line Number</em>'.
	 * @see eu.hohenegger.indentationtree.parsermodel.Level#getLineNumber()
	 * @see #getLevel()
	 * @generated
	 */
	EAttribute getLevel_LineNumber();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ParsermodelFactory getParsermodelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link eu.hohenegger.indentationtree.parsermodel.impl.ContainmentRootImpl <em>Containment Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.hohenegger.indentationtree.parsermodel.impl.ContainmentRootImpl
		 * @see eu.hohenegger.indentationtree.parsermodel.impl.ParsermodelPackageImpl#getContainmentRoot()
		 * @generated
		 */
		EClass CONTAINMENT_ROOT = eINSTANCE.getContainmentRoot();

		/**
		 * The meta object literal for the '<em><b>Top Level</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTAINMENT_ROOT__TOP_LEVEL = eINSTANCE.getContainmentRoot_TopLevel();

		/**
		 * The meta object literal for the '{@link eu.hohenegger.indentationtree.parsermodel.impl.LevelImpl <em>Level</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.hohenegger.indentationtree.parsermodel.impl.LevelImpl
		 * @see eu.hohenegger.indentationtree.parsermodel.impl.ParsermodelPackageImpl#getLevel()
		 * @generated
		 */
		EClass LEVEL = eINSTANCE.getLevel();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LEVEL__CONTENT = eINSTANCE.getLevel_Content();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LEVEL__PARENT = eINSTANCE.getLevel_Parent();

		/**
		 * The meta object literal for the '<em><b>Sub Level</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LEVEL__SUB_LEVEL = eINSTANCE.getLevel_SubLevel();

		/**
		 * The meta object literal for the '<em><b>Line Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LEVEL__LINE_NUMBER = eINSTANCE.getLevel_LineNumber();

	}

} //ParsermodelPackage
