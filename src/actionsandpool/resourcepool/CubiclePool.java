package actionsandpool.resourcepool;

import actionsandpool.resource.Cubicle;

/**
 * CubiclePool is an administrator for cubicle resources
 * 
 * @author Honoré Nintunze, Shijin Xu and Xavier Van De Woestyne
 * 
 */
public class CubiclePool extends ResourcePool<Cubicle> {

	// Constructor
	/**
	 * @param nbAvailableResource
	 */
	public CubiclePool(int nbAvailableResource) {
		super(nbAvailableResource);
	}

	// Method
	
	/* (non-Javadoc)
	 * @see actionsandpool.resourcepool.ResourcePool#createResource()
	 */
	@Override
	protected Cubicle createResource() {
		return new Cubicle();
	}
}
