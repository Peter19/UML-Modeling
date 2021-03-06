/*******************************************************************************
 * Copyright (c) 2009, 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.uml2.uml.tests.junit;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.eef.runtime.tests.SWTBotEEFTestCase;
import org.eclipse.emf.eef.runtime.tests.exceptions.InputModelInvalidException;
import org.eclipse.emf.eef.runtime.tests.utils.EEFTestsModelsUtils;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEditor;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.uml2.uml.CreateLinkAction;
import org.eclipse.uml2.uml.UMLPackage;
import org.obeonetwork.dsl.uml2.properties.uml.parts.UmlViewsRepository;
import org.obeonetwork.dsl.uml2.properties.uml.providers.UmlMessages;
/**
 * TestCase for CreateLinkAction
 * @author <a href="mailto:stephane.bouchet@obeo.fr">Stephane Bouchet</a>
 */
public class CreateLinkActionTestCase extends SWTBotEEFTestCase {

	/**
	 * The EClass of the type to edit
	 */
	private EClass createLinkActionMetaClass = UMLPackage.eINSTANCE.getCreateLinkAction();

	/**
	 * The type to edit
	 */
	private EObject createLinkAction;

	/**
	 * The enum value for the enum class visibility
	 */
	private Object enumValueForVisibility;
	/**
	 * The reference value for the reference class outgoing
	 */
	private Object referenceValueForOutgoing;

	/**
	 * The reference value for the reference class inInterruptibleRegion
	 */
	private Object referenceValueForInInterruptibleRegion;

	/**
	 * The reference value for the reference class inPartition
	 */
	private Object referenceValueForInPartition;

	/**
	 * The reference value for the reference class incoming
	 */
	private Object referenceValueForIncoming;

	/**
	 * The reference value for the reference class activity
	 */
	private Object referenceValueForActivity;

	/**
	 * The reference value for the reference class clientDependency
	 */
	private Object referenceValueForClientDependency;

	/**
	 * The reference value for the reference class redefinedNode
	 */
	private Object referenceValueForRedefinedNode;

	/**
	 * The reference value for the reference class inStructuredNode
	 */
	private Object referenceValueForInStructuredNode;
	/**
	 * The EClass of the reference to edit
	 */
	private EClass interruptibleActivityRegionMetaClass = UMLPackage.eINSTANCE.getInterruptibleActivityRegion();

	/**
	 * The EClass of the reference to edit
	 */
	private EClass structuredActivityNodeMetaClass = UMLPackage.eINSTANCE.getStructuredActivityNode();

	/**
	 * The EClass of the reference to edit
	 */
	private EClass activityMetaClass = UMLPackage.eINSTANCE.getActivity();

	/**
	 * The EClass of the reference to edit
	 */
	private EClass activityNodeMetaClass = UMLPackage.eINSTANCE.getActivityNode();

	/**
	 * The EClass of the reference to edit
	 */
	private EClass activityPartitionMetaClass = UMLPackage.eINSTANCE.getActivityPartition();

	/**
	 * The EClass of the reference to edit
	 */
	private EClass activityEdgeMetaClass = UMLPackage.eINSTANCE.getActivityEdge();

	/**
	 * The EClass of the reference to edit
	 */
	private EClass dependencyMetaClass = UMLPackage.eINSTANCE.getDependency();
	/**
	 * The eObjects list contained in widgets
	 */
	private List allInstancesOf;
	/**
	 * Updated value of the feature
	 */
	private static final String UPDATED_VALUE = "value2";

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.tests.SWTBotEEFTestCase#getExpectedModelName()
	 */
	protected String getExpectedModelName() {
		return "expected.uML";
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.tests.SWTBotEEFTestCase#getInputModelFolder()
	 */
	protected String getInputModelFolder() {
		return "input";
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.tests.SWTBotEEFTestCase#getInputModelName()
	 */
	protected String getInputModelName() {
		return "input.uML";
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.tests.SWTBotEEFTestCase#getTestsProjectName()
	 */
	protected String getTestsProjectName() {
		return "org.obeonetwork.dsl.uml2.properties.tests";
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.tests.SWTBotEEFTestCase#getExpectedModelFolder()
	 */
	protected String getExpectedModelFolder() {
		// The project that contains models for tests
		return "expected";
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.tests.SWTBotEEFTestCase#getImportModelsFolder()
	 */
	protected String getImportModelsFolder() {
		return  "models";
	}
	/**
	 * Create the expected model from the input model
	 * @throws InputModelInvalidException error during expected model initialization
	 * @throws IOException error during expected model serialization
	 */
	protected void initializeExpectedModelForCreateLinkActionName() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		EObject createLinkAction = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, createLinkActionMetaClass);
		if (createLinkAction == null)
			throw new InputModelInvalidException(createLinkActionMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
				cc.append(SetCommand.create(editingDomain, createLinkAction, UMLPackage.eINSTANCE.getNamedElement_Name(), UPDATED_VALUE));
		editingDomain.getCommandStack().execute(cc);
		expectedModel.save(Collections.EMPTY_MAP);
	}
	/**
	 * Test the editor properties :
	 * - init the input model
	 * - calculate the expected model
	 * - initialize the model editor
	 * - change the properties in the editor properties
	 * - compare the expected and the real model : if they are equals the test pass
	 * - delete the models
	 */
	public void testEditCreateLinkActionName() throws Exception {

		// Import the input model
		initializeInputModel();

		createLinkAction = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), createLinkActionMetaClass);
		if (createLinkAction == null)
			throw new InputModelInvalidException(createLinkActionMetaClass.getName());

		// Create the expected model
		initializeExpectedModelForCreateLinkActionName();

		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();

		// Open the EEF wizard (by double click) to edit the CreateLinkAction element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), createLinkActionMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(createLinkActionMetaClass.getName());

		SWTBotShell wizardShell = bot.prepareBatchEditing(modelEditor, createLinkActionMetaClass, firstInstanceOf, null);

		// Change value of the name feature of the CreateLinkAction element 
				bot.editTextFeature(wizardShell, UmlViewsRepository.CreateLinkAction.Properties.name, UPDATED_VALUE);

		// Save the modification
		bot.finalizeEdition(modelEditor);

		// Compare real model with expected model
		assertExpectedModelReached(expectedModel);

		// Delete the input model
		deleteModels();

	}
	/**
	 * Create the expected model from the input model
	 * @throws InputModelInvalidException error during expected model initialization
	 * @throws IOException error during expected model serialization
	 */
	protected void initializeExpectedModelForCreateLinkActionVisibility() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		EObject createLinkAction = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, createLinkActionMetaClass);
		if (createLinkAction == null)
			throw new InputModelInvalidException(createLinkActionMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
				cc.append(SetCommand.create(editingDomain, createLinkAction, UMLPackage.eINSTANCE.getNamedElement_Visibility(), UPDATED_VALUE));
		editingDomain.getCommandStack().execute(cc);
		expectedModel.save(Collections.EMPTY_MAP);
	}
	/**
	 * Test the editor properties :
	 * - init the input model
	 * - calculate the expected model
	 * - initialize the model editor
	 * - change the properties in the editor properties
	 * - compare the expected and the real model : if they are equals the test pass
	 * - delete the models
	 */
	public void testEditCreateLinkActionVisibility() throws Exception {

		// Import the input model
		initializeInputModel();

		createLinkAction = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), createLinkActionMetaClass);
		if (createLinkAction == null)
			throw new InputModelInvalidException(createLinkActionMetaClass.getName());

		enumValueForVisibility = bot.changeEnumLiteralValue(UMLPackage.eINSTANCE.getVisibilityKind(), ((CreateLinkAction)createLinkAction).getVisibility().getLiteral());
		// Create the expected model
		initializeExpectedModelForCreateLinkActionVisibility();

		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();

		// Open the EEF wizard (by double click) to edit the CreateLinkAction element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), createLinkActionMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(createLinkActionMetaClass.getName());

		SWTBotShell wizardShell = bot.prepareBatchEditing(modelEditor, createLinkActionMetaClass, firstInstanceOf, null);

		// Change value of the visibility feature of the CreateLinkAction element 
				bot.editTextFeature(wizardShell, UmlViewsRepository.CreateLinkAction.Properties.visibility, UPDATED_VALUE);

		// Save the modification
		bot.finalizeEdition(modelEditor);

		// Compare real model with expected model
		assertExpectedModelReached(expectedModel);

		// Delete the input model
		deleteModels();

	}
	/**
	 * Create the expected model from the input model
	 * @throws InputModelInvalidException error during expected model initialization
	 * @throws IOException error during expected model serialization
	 */
	protected void initializeExpectedModelForCreateLinkActionClientDependency() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		EObject createLinkAction = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, createLinkActionMetaClass);
		if (createLinkAction == null)
			throw new InputModelInvalidException(createLinkActionMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
		allInstancesOf = EEFTestsModelsUtils.getAllInstancesOf(expectedModel, dependencyMetaClass);
		referenceValueForClientDependency = bot.changeReferenceValue(allInstancesOf, ((CreateLinkAction)createLinkAction).getClientDependency());
		cc.append(AddCommand.create(editingDomain, createLinkAction, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), referenceValueForClientDependency));
		editingDomain.getCommandStack().execute(cc);
		expectedModel.save(Collections.EMPTY_MAP);
	}
	/**
	 * Test the editor properties :
	 * - init the input model
	 * - calculate the expected model
	 * - initialize the model editor
	 * - change the properties in the editor properties
	 * - compare the expected and the real model : if they are equals the test pass
	 * - delete the models
	 */
	public void testEditCreateLinkActionClientDependency() throws Exception {

		// Import the input model
		initializeInputModel();

		createLinkAction = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), createLinkActionMetaClass);
		if (createLinkAction == null)
			throw new InputModelInvalidException(createLinkActionMetaClass.getName());

		// Create the expected model
		initializeExpectedModelForCreateLinkActionClientDependency();

		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();

		// Open the EEF wizard (by double click) to edit the CreateLinkAction element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), createLinkActionMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(createLinkActionMetaClass.getName());

		SWTBotShell wizardShell = bot.prepareBatchEditing(modelEditor, createLinkActionMetaClass, firstInstanceOf, null);

		// Change value of the clientDependency feature of the CreateLinkAction element 
		bot.editAdvancedReferencesTableFeature(wizardShell, UmlViewsRepository.CreateLinkAction.Properties.clientDependency, referenceValueForClientDependency);

		// Save the modification
		bot.finalizeEdition(modelEditor);

		// Compare real model with expected model
		assertExpectedModelReached(expectedModel);

		// Delete the input model
		deleteModels();

	}
	/**
	 * Create the expected model from the input model
	 * @throws InputModelInvalidException error during expected model initialization
	 * @throws IOException error during expected model serialization
	 */
	protected void initializeRemoveExpectedModelForCreateLinkActionClientDependency() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		EObject createLinkAction = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, createLinkActionMetaClass);
		if (createLinkAction == null)
			throw new InputModelInvalidException(createLinkActionMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
		List<EObject> allReferencedInstances = (List<EObject>)createLinkAction.eGet(UMLPackage.eINSTANCE.getNamedElement_ClientDependency());
		if (allReferencedInstances.size() > 0) {
			cc.append(RemoveCommand.create(editingDomain, createLinkAction, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), allReferencedInstances.get(0)));
		}
		else {
			throw new InputModelInvalidException();
		}
		editingDomain.getCommandStack().execute(cc);
		expectedModel.save(Collections.EMPTY_MAP);
	}
	/**
	 * Test the editor properties :
	 * - init the input model
	 * - calculate the expected model
	 * - initialize the model editor
	 * - change the properties in the editor properties
	 * - compare the expected and the real model : if they are equals the test pass
	 * - delete the models
	 */
	public void testRemoveCreateLinkActionClientDependency() throws Exception {

		// Import the input model
		initializeInputModel();

		createLinkAction = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), createLinkActionMetaClass);
		if (createLinkAction == null)
			throw new InputModelInvalidException(createLinkActionMetaClass.getName());

		// Create the expected model
		initializeRemoveExpectedModelForCreateLinkActionClientDependency();

		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();

		// Open the EEF wizard (by double click) to edit the CreateLinkAction element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), createLinkActionMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(createLinkActionMetaClass.getName());

		SWTBotShell wizardShell = bot.prepareBatchEditing(modelEditor, createLinkActionMetaClass, firstInstanceOf, null);

		// Change value of the clientDependency feature of the CreateLinkAction element 
		bot.removeAdvancedReferencesTableFeature(wizardShell, UmlViewsRepository.CreateLinkAction.Properties.clientDependency, UmlMessages.PropertiesEditionPart_RemoveListViewerLabel);

		// Save the modification
		bot.finalizeEdition(modelEditor);

		// Compare real model with expected model
		assertExpectedModelReached(expectedModel);

		// Delete the input model
		deleteModels();

	}
	/**
	 * Create the expected model from the input model
	 * @throws InputModelInvalidException error during expected model initialization
	 * @throws IOException error during expected model serialization
	 */
	protected void initializeExpectedModelForCreateLinkActionIsLeaf() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		EObject createLinkAction = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, createLinkActionMetaClass);
		if (createLinkAction == null)
			throw new InputModelInvalidException(createLinkActionMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
				cc.append(SetCommand.create(editingDomain, createLinkAction, UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf(), UPDATED_VALUE));
		editingDomain.getCommandStack().execute(cc);
		expectedModel.save(Collections.EMPTY_MAP);
	}
	/**
	 * Test the editor properties :
	 * - init the input model
	 * - calculate the expected model
	 * - initialize the model editor
	 * - change the properties in the editor properties
	 * - compare the expected and the real model : if they are equals the test pass
	 * - delete the models
	 */
	public void testEditCreateLinkActionIsLeaf() throws Exception {

		// Import the input model
		initializeInputModel();

		createLinkAction = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), createLinkActionMetaClass);
		if (createLinkAction == null)
			throw new InputModelInvalidException(createLinkActionMetaClass.getName());

		// Create the expected model
		initializeExpectedModelForCreateLinkActionIsLeaf();

		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();

		// Open the EEF wizard (by double click) to edit the CreateLinkAction element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), createLinkActionMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(createLinkActionMetaClass.getName());

		SWTBotShell wizardShell = bot.prepareBatchEditing(modelEditor, createLinkActionMetaClass, firstInstanceOf, null);

		// Change value of the isLeaf feature of the CreateLinkAction element 
				bot.editTextFeature(wizardShell, UmlViewsRepository.CreateLinkAction.Properties.isLeaf, UPDATED_VALUE);

		// Save the modification
		bot.finalizeEdition(modelEditor);

		// Compare real model with expected model
		assertExpectedModelReached(expectedModel);

		// Delete the input model
		deleteModels();

	}
	/**
	 * Create the expected model from the input model
	 * @throws InputModelInvalidException error during expected model initialization
	 * @throws IOException error during expected model serialization
	 */
	protected void initializeExpectedModelForCreateLinkActionInStructuredNode() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		EObject createLinkAction = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, createLinkActionMetaClass);
		if (createLinkAction == null)
			throw new InputModelInvalidException(createLinkActionMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
		allInstancesOf = EEFTestsModelsUtils.getAllInstancesOf(expectedModel, structuredActivityNodeMetaClass);
		referenceValueForInStructuredNode = bot.changeReferenceValue(allInstancesOf, ((CreateLinkAction)createLinkAction).getInStructuredNode());
		cc.append(SetCommand.create(editingDomain, createLinkAction, UMLPackage.eINSTANCE.getActivityNode_InStructuredNode(), referenceValueForInStructuredNode));
		editingDomain.getCommandStack().execute(cc);
		expectedModel.save(Collections.EMPTY_MAP);
	}
	/**
	 * Test the editor properties :
	 * - init the input model
	 * - calculate the expected model
	 * - initialize the model editor
	 * - change the properties in the editor properties
	 * - compare the expected and the real model : if they are equals the test pass
	 * - delete the models
	 */
	public void testEditCreateLinkActionInStructuredNode() throws Exception {

		// Import the input model
		initializeInputModel();

		createLinkAction = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), createLinkActionMetaClass);
		if (createLinkAction == null)
			throw new InputModelInvalidException(createLinkActionMetaClass.getName());

		// Create the expected model
		initializeExpectedModelForCreateLinkActionInStructuredNode();

		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();

		// Open the EEF wizard (by double click) to edit the CreateLinkAction element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), createLinkActionMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(createLinkActionMetaClass.getName());

		SWTBotShell wizardShell = bot.prepareBatchEditing(modelEditor, createLinkActionMetaClass, firstInstanceOf, null);

		// Change value of the inStructuredNode feature of the CreateLinkAction element 
		bot.editEObjectFlatComboViewerFeature(wizardShell, UmlViewsRepository.CreateLinkAction.Properties.inStructuredNode, allInstancesOf.indexOf(referenceValueForInStructuredNode)+1);

		// Save the modification
		bot.finalizeEdition(modelEditor);

		// Compare real model with expected model
		assertExpectedModelReached(expectedModel);

		// Delete the input model
		deleteModels();

	}
	/**
	 * Create the expected model from the input model
	 * @throws InputModelInvalidException error during expected model initialization
	 * @throws IOException error during expected model serialization
	 */
	protected void initializeRemoveExpectedModelForCreateLinkActionInStructuredNode() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		EObject createLinkAction = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, createLinkActionMetaClass);
		if (createLinkAction == null)
			throw new InputModelInvalidException(createLinkActionMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
		allInstancesOf = EEFTestsModelsUtils.getAllInstancesOf(expectedModel, structuredActivityNodeMetaClass);
		cc.append(SetCommand.create(editingDomain, createLinkAction, UMLPackage.eINSTANCE.getActivityNode_InStructuredNode(), null));
		editingDomain.getCommandStack().execute(cc);
		expectedModel.save(Collections.EMPTY_MAP);
	}
	/**
	 * Test the editor properties :
	 * - init the input model
	 * - calculate the expected model
	 * - initialize the model editor
	 * - change the properties in the editor properties
	 * - compare the expected and the real model : if they are equals the test pass
	 * - delete the models
	 */
	public void testRemoveCreateLinkActionInStructuredNode() throws Exception {

		// Import the input model
		initializeInputModel();

		createLinkAction = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), createLinkActionMetaClass);
		if (createLinkAction == null)
			throw new InputModelInvalidException(createLinkActionMetaClass.getName());

		// Create the expected model
		initializeRemoveExpectedModelForCreateLinkActionInStructuredNode();

		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();

		// Open the EEF wizard (by double click) to edit the CreateLinkAction element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), createLinkActionMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(createLinkActionMetaClass.getName());

		SWTBotShell wizardShell = bot.prepareBatchEditing(modelEditor, createLinkActionMetaClass, firstInstanceOf, null);

		// Change value of the inStructuredNode feature of the CreateLinkAction element
		bot.removeEObjectFlatComboViewerFeature(wizardShell, UmlViewsRepository.CreateLinkAction.Properties.inStructuredNode);
		

		// Save the modification
		bot.finalizeEdition(modelEditor);

		// Compare real model with expected model
		assertExpectedModelReached(expectedModel);

		// Delete the input model
		deleteModels();

	}
	/**
	 * Create the expected model from the input model
	 * @throws InputModelInvalidException error during expected model initialization
	 * @throws IOException error during expected model serialization
	 */
	protected void initializeExpectedModelForCreateLinkActionActivity() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		EObject createLinkAction = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, createLinkActionMetaClass);
		if (createLinkAction == null)
			throw new InputModelInvalidException(createLinkActionMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
		allInstancesOf = EEFTestsModelsUtils.getAllInstancesOf(expectedModel, activityMetaClass);
		referenceValueForActivity = bot.changeReferenceValue(allInstancesOf, ((CreateLinkAction)createLinkAction).getActivity());
		cc.append(SetCommand.create(editingDomain, createLinkAction, UMLPackage.eINSTANCE.getActivityNode_Activity(), referenceValueForActivity));
		editingDomain.getCommandStack().execute(cc);
		expectedModel.save(Collections.EMPTY_MAP);
	}
	/**
	 * Test the editor properties :
	 * - init the input model
	 * - calculate the expected model
	 * - initialize the model editor
	 * - change the properties in the editor properties
	 * - compare the expected and the real model : if they are equals the test pass
	 * - delete the models
	 */
	public void testEditCreateLinkActionActivity() throws Exception {

		// Import the input model
		initializeInputModel();

		createLinkAction = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), createLinkActionMetaClass);
		if (createLinkAction == null)
			throw new InputModelInvalidException(createLinkActionMetaClass.getName());

		// Create the expected model
		initializeExpectedModelForCreateLinkActionActivity();

		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();

		// Open the EEF wizard (by double click) to edit the CreateLinkAction element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), createLinkActionMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(createLinkActionMetaClass.getName());

		SWTBotShell wizardShell = bot.prepareBatchEditing(modelEditor, createLinkActionMetaClass, firstInstanceOf, null);

		// Change value of the activity feature of the CreateLinkAction element 
		bot.editEObjectFlatComboViewerFeature(wizardShell, UmlViewsRepository.CreateLinkAction.Properties.activity, allInstancesOf.indexOf(referenceValueForActivity)+1);

		// Save the modification
		bot.finalizeEdition(modelEditor);

		// Compare real model with expected model
		assertExpectedModelReached(expectedModel);

		// Delete the input model
		deleteModels();

	}
	/**
	 * Create the expected model from the input model
	 * @throws InputModelInvalidException error during expected model initialization
	 * @throws IOException error during expected model serialization
	 */
	protected void initializeRemoveExpectedModelForCreateLinkActionActivity() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		EObject createLinkAction = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, createLinkActionMetaClass);
		if (createLinkAction == null)
			throw new InputModelInvalidException(createLinkActionMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
		allInstancesOf = EEFTestsModelsUtils.getAllInstancesOf(expectedModel, activityMetaClass);
		cc.append(SetCommand.create(editingDomain, createLinkAction, UMLPackage.eINSTANCE.getActivityNode_Activity(), null));
		editingDomain.getCommandStack().execute(cc);
		expectedModel.save(Collections.EMPTY_MAP);
	}
	/**
	 * Test the editor properties :
	 * - init the input model
	 * - calculate the expected model
	 * - initialize the model editor
	 * - change the properties in the editor properties
	 * - compare the expected and the real model : if they are equals the test pass
	 * - delete the models
	 */
	public void testRemoveCreateLinkActionActivity() throws Exception {

		// Import the input model
		initializeInputModel();

		createLinkAction = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), createLinkActionMetaClass);
		if (createLinkAction == null)
			throw new InputModelInvalidException(createLinkActionMetaClass.getName());

		// Create the expected model
		initializeRemoveExpectedModelForCreateLinkActionActivity();

		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();

		// Open the EEF wizard (by double click) to edit the CreateLinkAction element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), createLinkActionMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(createLinkActionMetaClass.getName());

		SWTBotShell wizardShell = bot.prepareBatchEditing(modelEditor, createLinkActionMetaClass, firstInstanceOf, null);

		// Change value of the activity feature of the CreateLinkAction element
		bot.removeEObjectFlatComboViewerFeature(wizardShell, UmlViewsRepository.CreateLinkAction.Properties.activity);
		

		// Save the modification
		bot.finalizeEdition(modelEditor);

		// Compare real model with expected model
		assertExpectedModelReached(expectedModel);

		// Delete the input model
		deleteModels();

	}
	/**
	 * Create the expected model from the input model
	 * @throws InputModelInvalidException error during expected model initialization
	 * @throws IOException error during expected model serialization
	 */
	protected void initializeExpectedModelForCreateLinkActionInPartition() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		EObject createLinkAction = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, createLinkActionMetaClass);
		if (createLinkAction == null)
			throw new InputModelInvalidException(createLinkActionMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
		allInstancesOf = EEFTestsModelsUtils.getAllInstancesOf(expectedModel, activityPartitionMetaClass);
		referenceValueForInPartition = bot.changeReferenceValue(allInstancesOf, ((CreateLinkAction)createLinkAction).getInPartition());
		cc.append(AddCommand.create(editingDomain, createLinkAction, UMLPackage.eINSTANCE.getActivityNode_InPartition(), referenceValueForInPartition));
		editingDomain.getCommandStack().execute(cc);
		expectedModel.save(Collections.EMPTY_MAP);
	}
	/**
	 * Test the editor properties :
	 * - init the input model
	 * - calculate the expected model
	 * - initialize the model editor
	 * - change the properties in the editor properties
	 * - compare the expected and the real model : if they are equals the test pass
	 * - delete the models
	 */
	public void testEditCreateLinkActionInPartition() throws Exception {

		// Import the input model
		initializeInputModel();

		createLinkAction = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), createLinkActionMetaClass);
		if (createLinkAction == null)
			throw new InputModelInvalidException(createLinkActionMetaClass.getName());

		// Create the expected model
		initializeExpectedModelForCreateLinkActionInPartition();

		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();

		// Open the EEF wizard (by double click) to edit the CreateLinkAction element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), createLinkActionMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(createLinkActionMetaClass.getName());

		SWTBotShell wizardShell = bot.prepareBatchEditing(modelEditor, createLinkActionMetaClass, firstInstanceOf, null);

		// Change value of the inPartition feature of the CreateLinkAction element 
		bot.editAdvancedReferencesTableFeature(wizardShell, UmlViewsRepository.CreateLinkAction.Properties.inPartition, referenceValueForInPartition);

		// Save the modification
		bot.finalizeEdition(modelEditor);

		// Compare real model with expected model
		assertExpectedModelReached(expectedModel);

		// Delete the input model
		deleteModels();

	}
	/**
	 * Create the expected model from the input model
	 * @throws InputModelInvalidException error during expected model initialization
	 * @throws IOException error during expected model serialization
	 */
	protected void initializeRemoveExpectedModelForCreateLinkActionInPartition() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		EObject createLinkAction = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, createLinkActionMetaClass);
		if (createLinkAction == null)
			throw new InputModelInvalidException(createLinkActionMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
		List<EObject> allReferencedInstances = (List<EObject>)createLinkAction.eGet(UMLPackage.eINSTANCE.getActivityNode_InPartition());
		if (allReferencedInstances.size() > 0) {
			cc.append(RemoveCommand.create(editingDomain, createLinkAction, UMLPackage.eINSTANCE.getActivityNode_InPartition(), allReferencedInstances.get(0)));
		}
		else {
			throw new InputModelInvalidException();
		}
		editingDomain.getCommandStack().execute(cc);
		expectedModel.save(Collections.EMPTY_MAP);
	}
	/**
	 * Test the editor properties :
	 * - init the input model
	 * - calculate the expected model
	 * - initialize the model editor
	 * - change the properties in the editor properties
	 * - compare the expected and the real model : if they are equals the test pass
	 * - delete the models
	 */
	public void testRemoveCreateLinkActionInPartition() throws Exception {

		// Import the input model
		initializeInputModel();

		createLinkAction = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), createLinkActionMetaClass);
		if (createLinkAction == null)
			throw new InputModelInvalidException(createLinkActionMetaClass.getName());

		// Create the expected model
		initializeRemoveExpectedModelForCreateLinkActionInPartition();

		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();

		// Open the EEF wizard (by double click) to edit the CreateLinkAction element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), createLinkActionMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(createLinkActionMetaClass.getName());

		SWTBotShell wizardShell = bot.prepareBatchEditing(modelEditor, createLinkActionMetaClass, firstInstanceOf, null);

		// Change value of the inPartition feature of the CreateLinkAction element 
		bot.removeAdvancedReferencesTableFeature(wizardShell, UmlViewsRepository.CreateLinkAction.Properties.inPartition, UmlMessages.PropertiesEditionPart_RemoveListViewerLabel);

		// Save the modification
		bot.finalizeEdition(modelEditor);

		// Compare real model with expected model
		assertExpectedModelReached(expectedModel);

		// Delete the input model
		deleteModels();

	}
	/**
	 * Create the expected model from the input model
	 * @throws InputModelInvalidException error during expected model initialization
	 * @throws IOException error during expected model serialization
	 */
	protected void initializeExpectedModelForCreateLinkActionInInterruptibleRegion() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		EObject createLinkAction = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, createLinkActionMetaClass);
		if (createLinkAction == null)
			throw new InputModelInvalidException(createLinkActionMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
		allInstancesOf = EEFTestsModelsUtils.getAllInstancesOf(expectedModel, interruptibleActivityRegionMetaClass);
		referenceValueForInInterruptibleRegion = bot.changeReferenceValue(allInstancesOf, ((CreateLinkAction)createLinkAction).getInInterruptibleRegion());
		cc.append(AddCommand.create(editingDomain, createLinkAction, UMLPackage.eINSTANCE.getActivityNode_InInterruptibleRegion(), referenceValueForInInterruptibleRegion));
		editingDomain.getCommandStack().execute(cc);
		expectedModel.save(Collections.EMPTY_MAP);
	}
	/**
	 * Test the editor properties :
	 * - init the input model
	 * - calculate the expected model
	 * - initialize the model editor
	 * - change the properties in the editor properties
	 * - compare the expected and the real model : if they are equals the test pass
	 * - delete the models
	 */
	public void testEditCreateLinkActionInInterruptibleRegion() throws Exception {

		// Import the input model
		initializeInputModel();

		createLinkAction = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), createLinkActionMetaClass);
		if (createLinkAction == null)
			throw new InputModelInvalidException(createLinkActionMetaClass.getName());

		// Create the expected model
		initializeExpectedModelForCreateLinkActionInInterruptibleRegion();

		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();

		// Open the EEF wizard (by double click) to edit the CreateLinkAction element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), createLinkActionMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(createLinkActionMetaClass.getName());

		SWTBotShell wizardShell = bot.prepareBatchEditing(modelEditor, createLinkActionMetaClass, firstInstanceOf, null);

		// Change value of the inInterruptibleRegion feature of the CreateLinkAction element 
		bot.editAdvancedReferencesTableFeature(wizardShell, UmlViewsRepository.CreateLinkAction.Properties.inInterruptibleRegion, referenceValueForInInterruptibleRegion);

		// Save the modification
		bot.finalizeEdition(modelEditor);

		// Compare real model with expected model
		assertExpectedModelReached(expectedModel);

		// Delete the input model
		deleteModels();

	}
	/**
	 * Create the expected model from the input model
	 * @throws InputModelInvalidException error during expected model initialization
	 * @throws IOException error during expected model serialization
	 */
	protected void initializeRemoveExpectedModelForCreateLinkActionInInterruptibleRegion() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		EObject createLinkAction = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, createLinkActionMetaClass);
		if (createLinkAction == null)
			throw new InputModelInvalidException(createLinkActionMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
		List<EObject> allReferencedInstances = (List<EObject>)createLinkAction.eGet(UMLPackage.eINSTANCE.getActivityNode_InInterruptibleRegion());
		if (allReferencedInstances.size() > 0) {
			cc.append(RemoveCommand.create(editingDomain, createLinkAction, UMLPackage.eINSTANCE.getActivityNode_InInterruptibleRegion(), allReferencedInstances.get(0)));
		}
		else {
			throw new InputModelInvalidException();
		}
		editingDomain.getCommandStack().execute(cc);
		expectedModel.save(Collections.EMPTY_MAP);
	}
	/**
	 * Test the editor properties :
	 * - init the input model
	 * - calculate the expected model
	 * - initialize the model editor
	 * - change the properties in the editor properties
	 * - compare the expected and the real model : if they are equals the test pass
	 * - delete the models
	 */
	public void testRemoveCreateLinkActionInInterruptibleRegion() throws Exception {

		// Import the input model
		initializeInputModel();

		createLinkAction = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), createLinkActionMetaClass);
		if (createLinkAction == null)
			throw new InputModelInvalidException(createLinkActionMetaClass.getName());

		// Create the expected model
		initializeRemoveExpectedModelForCreateLinkActionInInterruptibleRegion();

		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();

		// Open the EEF wizard (by double click) to edit the CreateLinkAction element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), createLinkActionMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(createLinkActionMetaClass.getName());

		SWTBotShell wizardShell = bot.prepareBatchEditing(modelEditor, createLinkActionMetaClass, firstInstanceOf, null);

		// Change value of the inInterruptibleRegion feature of the CreateLinkAction element 
		bot.removeAdvancedReferencesTableFeature(wizardShell, UmlViewsRepository.CreateLinkAction.Properties.inInterruptibleRegion, UmlMessages.PropertiesEditionPart_RemoveListViewerLabel);

		// Save the modification
		bot.finalizeEdition(modelEditor);

		// Compare real model with expected model
		assertExpectedModelReached(expectedModel);

		// Delete the input model
		deleteModels();

	}


















}
