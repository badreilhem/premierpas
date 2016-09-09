package actionsandpool.action.resourcepoolaction;

import actionsandpool.action.Action;
import actionsandpool.resource.Resource;
import actionsandpool.resourcefuluser.ResourcefulUser;
import actionsandpool.resourcepool.ResourcePool;

/**
 * @author Honoré Nintunze, Shijin Xu and Xavier Van De Woestyne
 *
 * @param <R>
 *            a Resource
 */
public abstract class ResourcePoolAction<R extends Resource> extends Action {

	// Fields
	protected ResourcePool<R> administrator; // the pool of resource this action
												// interact with
	protected ResourcefulUser<R> user; // the applicant of the resource

	// Constructor
	/**
	 * Create a resource pool action
	 * 
	 * @param msg
	 *            the description of the action
	 * @param administrator
	 *            of the resources
	 * @param user
	 *            of the resources
	 */
	public ResourcePoolAction(String msg, ResourcePool<R> administrator,
			ResourcefulUser<R> user) {
		super(msg);
		this.administrator = administrator;
		this.user = user;
	}

	// Methods

	// abstract method
	/**
	 * Perform an action on a resourcePool
	 * 
	 * @throws Exception
	 *             if this couldn't perform the action
	 */
	protected abstract void applyAction() throws Exception;

	// concrete method

	/*
	 * perform a step of the action, i.e do an action on its resource
	 * administrator
	 * 
	 * @see actionsandpool.action.Action#reallyDoStep()
	 */
	@Override
	protected void reallyDoStep() {
		try {
			this.applyAction();
		} catch (Exception e) {
			this.setState(ActionState.INPROGRESS);
			System.out.printf("Failed\n");
		}
	}

}
