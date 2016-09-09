/**
 * 
 */
package actionsandpool.action.resourcepoolaction;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import actionsandpool.action.Action;
import actionsandpool.resource.Resource;
import actionsandpool.resourcefuluser.ResourcefulUser;
import actionsandpool.resourcepool.ResourcePool;

/**
 * Tests for free resource action
 * 
 * @author Honoré Nintunze, Shijin Xu and Xavier Van De Woestyne
 * 
 */
public abstract class FreeResourceActionTest<R extends Resource> extends
		ResourcePoolActionTest<R> {

	// abstract methods
	protected abstract R createResource();

	protected abstract ResourcePool<R> createResourcePool();

	protected abstract ResourcefulUser<R> createUser();

	// test methods
	@Test
	public void doStepWithRightResourceInArgumentFinishesInOneStep()
			throws Exception {
		Action action = createAction();
		assertFalse(action.isFinished());
		action.doStep(); // the action finishes in one step
		assertTrue(action.isFinished());
	}

	@Test
	public void doStepWithWrongResourceInArgumentDoesntFinishInOneStep()
			throws Exception {
		ResourcefulUser<R> user = createUser();
		ResourcePool<R> administrator = createResourcePool();
		Action action = new FreeResourceAction<R>("I'm a F.R.A.",
				administrator, user);
		user.setRessource(createResource());// we give to the user a resource
											// that
											// doesn't come from administrator
		assertFalse(action.isFinished());

		action.doStep(); // the action can't finish
		assertFalse(action.isFinished());
		assertTrue(action.isInProgress());

		R resource = administrator.provideResource();
		user.setRessource(resource); // we give to user the right resource to
										// free

		action.doStep(); // then the action can finish
		assertTrue(action.isFinished());
	}

	/*
	 * Create a FreeResourceAction with a user that has a resource that comes
	 * from it's resource administrator
	 * 
	 * @see
	 * actionsandpool.action.resourcepoolaction.ResourcePoolActionTest#createAction
	 * ()
	 */
	@Override
	protected Action createAction() {
		ResourcefulUser<R> user = createUser();
		ResourcePool<R> administrator = createResourcePool();
		user.setRessource(administrator.provideResource()); // provide the
															// resource to the
															// user
		return new FreeResourceAction<R>("I'm a F.R.A.", administrator, user);
	}

}
