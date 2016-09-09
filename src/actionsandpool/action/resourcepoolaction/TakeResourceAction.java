package actionsandpool.action.resourcepoolaction;

import java.util.NoSuchElementException;

import actionsandpool.resource.Resource;
import actionsandpool.resourcefuluser.ResourcefulUser;
import actionsandpool.resourcepool.ResourcePool;

/**
 * @author Honoré Nintunze, Shijin Xu and Xavier Van De Woestyne
 *
 * @param <R>
 *            a Resource
 */
public class TakeResourceAction<R extends Resource> extends
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
	public TakeResourceAction(String msg, ResourcePool<R> resourcepool,
			ResourcefulUser<R> user) {
		super(msg, resourcepool, user);
	}

	// Method
	/*
	 * try to get a resource from the resource administrator and give it to the
	 * user
	 * 
	 * @see
	 * actionsandpool.action.resourcepoolaction.ResourcePoolAction#applyAction()
	 */
	@Override
	protected void applyAction() throws NoSuchElementException {
		this.user.setRessource(administrator.provideResource());
		this.setState(ActionState.FINISHED);
		System.out.printf("Success\n");
	}

}
