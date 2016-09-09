package actionsandpool.action.resourcepoolaction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import actionsandpool.action.Action;
import actionsandpool.resource.Resource;
import actionsandpool.resourcefuluser.ResourcefulUser;
import actionsandpool.resourcepool.ResourcePool;

/**
 * Tests for take resource action
 * 
 * @author Honoré Nintunze, Shijin Xu and Xavier Van De Woestyne
 *
 * @param <R>
 *            a Resource
 */
public abstract class TakeResourceActionTest<R extends Resource> extends
		ResourcePoolActionTest<R> {

	// test methods
	@Test
	public void doStepWithOneAvailableResourceFinishesInOneStep()
			throws Exception {
		Action resourceAction = createAction();
		assertFalse(resourceAction.isFinished());
		resourceAction.doStep();
		assertTrue(resourceAction.isFinished());
	}

	@Test
	public void doStepWithNoAvailableResourceIsNotFinishedAtFirstStep()
			throws Exception {
		ResourcePool<R> resourcePool = createResourcePool();
		ResourcefulUser<R> user = createUser();
		Action action = new TakeResourceAction<R>("I'm a T.R.A.", resourcePool,
				user);
		R resource = null;
		while (resourcePool.canProvide())
			resource = resourcePool.provideResource();

		assertNotNull(resource);
		assertTrue(resourcePool.isInNotAvailableResources(resource));
		assertFalse(resourcePool.isInAvailableResources(resource));

		// at start the action is unfinished
		assertFalse(action.isFinished());
		assertNull(user.getRessource());

		action.doStep(); // no resource available
		assertFalse(action.isFinished());
		assertNull(user.getRessource());
		assertTrue(action.isInProgress());

		user.setRessource(resource);
		resourcePool.freeResource(resource); // make resource available

		action.doStep(); // now the resource is available and action finishes
		assertTrue(action.isFinished());
		assertEquals(user.getRessource(), resource);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * actionsandpool.action.resourcepoolaction.ResourcePoolActionTest#createAction
	 * ()
	 */
	@Override
	protected Action createAction() {
		ResourcefulUser<R> user = createUser();
		ResourcePool<R> administrator = createResourcePool();
		return new TakeResourceAction<R>("I'm a T.R.A.", administrator, user);
	}

}
