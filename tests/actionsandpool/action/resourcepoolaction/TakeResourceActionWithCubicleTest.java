/**
 * 
 */
package actionsandpool.action.resourcepoolaction;

import actionsandpool.resource.Cubicle;
import actionsandpool.resourcefuluser.ResourcefulUser;
import actionsandpool.resourcepool.CubiclePool;
import actionsandpool.resourcepool.ResourcePool;

/**
 * Tests for take resource action with cubicle resources
 * 
 * @author Honoré Nintunze, Shijin Xu and Xavier Van De Woestyne
 * 
 */
public class TakeResourceActionWithCubicleTest extends
		TakeResourceActionTest<Cubicle> {

	@Override
	protected ResourcePool<Cubicle> createResourcePool() {
		return new CubiclePool(nbAvailableResource);
	}

	@Override
	protected ResourcefulUser<Cubicle> createUser() {
		return new ResourcefulUser<Cubicle>();
	}

}
