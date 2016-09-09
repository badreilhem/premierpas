/**
 * 
 */
package actionsandpool.action.resourcepoolaction;

import actionsandpool.resource.Basket;
import actionsandpool.resourcefuluser.ResourcefulUser;
import actionsandpool.resourcepool.BasketPool;
import actionsandpool.resourcepool.ResourcePool;

/**
 * Tests for free resource action with basket resources
 * 
 * @author Honoré Nintunze, Shijin Xu and Xavier Van De Woestyne
 * 
 */
public class FreeResourceActionWithBasketTest extends
		FreeResourceActionTest<Basket> {

	@Override
	protected Basket createResource() {
		return new Basket();
	}

	@Override
	protected ResourcePool<Basket> createResourcePool() {
		return new BasketPool(nbAvailableResource);
	}

	@Override
	protected ResourcefulUser<Basket> createUser() {
		return new ResourcefulUser<Basket>();
	}

}
