/**
 * 
 */
package actionsandpool.resourcepool;

import actionsandpool.resource.Cubicle;

/**
 * Tests for ResourcePool with cubicle resources
 * 
 * @author Honoré Nintunze, Shijin Xu and Xavier Van De Woestyne
 * 
 */
public class CubiclePoolTest extends ResourcePoolTest<Cubicle> {

	@Override
	protected ResourcePool<Cubicle> createResourcePool() {
		return new CubiclePool(nbAvailableResource);
	}

	@Override
	protected Cubicle createResource() {
		return new Cubicle();
	}
}
