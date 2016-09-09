package actionsandpool.resourcepool;

import actionsandpool.resource.Basket;

/**
 * BasketPool is an administrator for basket resources
 * 
 * @author Honoré Nintunze, Shijin Xu and Xavier Van De Woestyne
 * 
 */
public class BasketPool extends ResourcePool<Basket> {

	// Constructor
	/**
	 * @param nbAvailableResource
	 */
	public BasketPool(int nbAvailableResource) {
		super(nbAvailableResource);
	}

	// Method

	/*
	 * (non-Javadoc)
	 * 
	 * @see actionsandpool.resourcepool.ResourcePool#createResource()
	 */
	@Override
	protected Basket createResource() {
		return new Basket();
	}
}
