package actionsandpool.action.resourcepoolaction;

import actionsandpool.resource.Resource;
import actionsandpool.resourcefuluser.ResourcefulUser;
import actionsandpool.resourcepool.ResourcePool;

/**
 * FreeReosourceAction is an action that will try to free a resource and return
 * it to its resource administrator.
 * 
 * @author Honoré Nintunze, Shijin Xu and Xavier Van De Woestyne
 *
 * @param <R>
 *            a Resource
 */
public class FreeResourceAction<R extends Resource> extends
		ResourcePoolAction<R> {

	// Constructor
	/**
	 * Create an action
	 * 
	 * @param msg
	 *            the description of the action
	 * @param resourcepool
	 *            the administrator of the resources
	 * @param user
	 *            of the resource
	 */
	public FreeResourceAction(String msg, ResourcePool<R> resourcepool,
			ResourcefulUser<R> user) {
		super(msg, resourcepool, user);
	}

	// Method

	/*
	 * free the resource of the user
	 * 
	 * @see
	 * actionsandpool.action.resourcepoolaction.ResourcePoolAction#applyAction()
	 */
	@Override
	protected void applyAction() throws IllegalArgumentException {
		this.administrator.freeResource(user.getRessource());
		this.user.resetRessource();
		this.setState(ActionState.FINISHED);
		System.out.printf("Success\n");
	}

}
