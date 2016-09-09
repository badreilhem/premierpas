/**
 * 
 */
package actionsandpool.action.resourcepoolaction;

import actionsandpool.action.Action;
import actionsandpool.action.ActionTest;
import actionsandpool.resource.Resource;
import actionsandpool.resourcefuluser.ResourcefulUser;
import actionsandpool.resourcepool.ResourcePool;

/**
 * Tests for resource pool action
 * 
 * @author Honoré Nintunze, Shijin Xu and Xavier Van De Woestyne
 *
 * @param <R>
 *            a Resource
 */
public abstract class ResourcePoolActionTest<R extends Resource> extends
		ActionTest {

	/**
	 * number of available resource in the resource pool created by
	 * createResourcePool
	 */
	int nbAvailableResource = 1;

	// Abstract methods
	/**
	 * @return
	 */
	protected abstract ResourcePool<R> createResourcePool();

	/*
	 * (non-Javadoc)
	 * 
	 * @see actionsandpool.action.ActionTest#createAction()
	 */
	protected abstract Action createAction();

	/**
	 * @return
	 */
	protected abstract ResourcefulUser<R> createUser();
}
