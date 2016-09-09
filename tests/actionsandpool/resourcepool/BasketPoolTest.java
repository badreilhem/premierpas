/**
 * 
 */
package actionsandpool.resourcepool;

import actionsandpool.resource.Basket;

/**
 * Tests for ResourcePool with basket resources
 * 
 * @author Honoré Nintunze, Shijin Xu and Xavier Van De Woestyne
 * 
 */
public class BasketPoolTest extends ResourcePoolTest<Basket> {

	@Override
	protected ResourcePool<Basket> createResourcePool() {
		return new BasketPool(nbAvailableResource);
	}

	@Override
	protected Basket createResource() {
		return new Basket();
	}

}
