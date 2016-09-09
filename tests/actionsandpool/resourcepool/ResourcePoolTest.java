/**
 * 
 */
package actionsandpool.resourcepool;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

import actionsandpool.resource.Resource;

/**
 * Tests for ResourcePool
 * 
 * @author Honoré Nintunze, Shijin Xu and Xavier Van De Woestyne
 * 
 */
public abstract class ResourcePoolTest<R extends Resource> {

	/**
	 * number of available resource in the resource pool created by
	 * createResourcePool
	 */
	int nbAvailableResource = 1;

	// abstract methods
	/**
	 * @return
	 */
	protected abstract ResourcePool<R> createResourcePool();

	/**
	 * @return
	 */
	protected abstract R createResource();

	// Test Methods

	/**
	 * Test that freeing a resource in a resource pool that isn't its original
	 * resource pool throw an exception
	 * {@link actionsandpool.resourcepool.ResourcePool#freeResource(actionsandpool.resource.Resource)}
	 * .
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testFreeResourceThrowExceptionIfWrongArgumentIsGiven() {
		ResourcePool<R> resourcePool = createResourcePool();

		R basket = createResource();

		resourcePool.freeResource(basket); // should throw IAE
	}

	/**
	 * Test that freeResource works if used with right argument.
	 * {@link actionsandpool.resourcepool.ResourcePool#freeResource(actionsandpool.resource.Resource)}
	 * .
	 */
	@Test
	public void testFreeResource() {
		ResourcePool<R> resourcePool = createResourcePool();

		R resource = resourcePool.provideResource(); // resource comes from the
														// resource pool

		try {
			assertFalse(resourcePool.isInAvailableResources(resource));
			assertTrue(resourcePool.isInNotAvailableResources(resource));
			resourcePool.freeResource(resource);
			assertTrue(resourcePool.isInAvailableResources(resource));
			assertFalse(resourcePool.isInNotAvailableResources(resource));
		} catch (IllegalArgumentException e) {
			fail("freeResource is given the right argument, this shouldn't throw exception");
		}
	}

	/**
	 * Test that if no action is available provideResource throw Exception
	 * {@link actionsandpool.resourcepool.ResourcePool#provideResource()}.
	 */
	@Test(expected = NoSuchElementException.class)
	public void provideResourceThrowExceptionIfNoActionAvailable() {
		ResourcePool<R> resourcePool = createResourcePool();

		while (resourcePool.canProvide())
			resourcePool.provideResource();

		resourcePool.provideResource(); // should throw NSEE
	}

	/**
	 * Test that provideResource provide resource when there is an available
	 * one. {@link actionsandpool.resourcepool.ResourcePool#provideResource()}.
	 */
	@Test
	public void provideResourceGivesAResourceWhenAvailable() {
		ResourcePool<R> resourcePool = createResourcePool(); // one resource is
																// available

		R resource = resourcePool.provideResource();
		assertNotNull(resource);
	}

}
