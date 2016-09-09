/**
 * 
 */
package actionsandpool.action.resourcepoolaction;

import actionsandpool.resource.Cubicle;
import actionsandpool.resourcefuluser.ResourcefulUser;
import actionsandpool.resourcepool.CubiclePool;
import actionsandpool.resourcepool.ResourcePool;

/**
 * Tests for free resource action with cubicle resources
 * 
 * @author Honoré Nintunze, Shijin Xu and Xavier Van De Woestyne
 * 
 */
public class FreeResourceActionWithCubicleTest extends
		FreeResourceActionTest<Cubicle> {

	@Override
	protected Cubicle createResource() {
		return new Cubicle();
	}

	@Override
	protected ResourcePool<Cubicle> createResourcePool() {
		return new CubiclePool(nbAvailableResource);
	}

	@Override
	protected ResourcefulUser<Cubicle> createUser() {
		return new ResourcefulUser<Cubicle>();
	}

}