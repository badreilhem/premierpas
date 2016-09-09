/**
 * 
 */
package actionsandpool.resourcepool;

import java.util.HashMap;
import java.util.NoSuchElementException;

import actionsandpool.resource.Resource;

/**
 * ResourcePool is an administrator of Resource
 * 
 * @author Honoré Nintunze, Shijin Xu and Xavier Van De Woestyne
 *
 * @param <R>
 *            a Resource
 */
public abstract class ResourcePool<R extends Resource> {

	// Fields
	protected HashMap<Integer, R> notAvailableResources;
	protected HashMap<Integer, R> availableResources;

	// Constructor
	/**
	 * create a resource administrator with a given number of resource that it
	 * can provide
	 * 
	 * @param nbResourceAvailable
	 *            the number of resource this will be able to provide
	 */
	public ResourcePool(int nbResourceAvailable) {
		R resource;
		this.notAvailableResources = new HashMap<Integer, R>(
				nbResourceAvailable);
		this.availableResources = new HashMap<Integer, R>(nbResourceAvailable);
		for (int i = 0; i < nbResourceAvailable; i++) {
			resource = createResource();
			this.availableResources.put(resource.hashCode(), resource);
		}

	}

	// Methods
	// abstract method
	/**
	 * Create a resource object
	 * 
	 * @return a resource
	 */
	protected abstract R createResource();

	// concrete method

	/**
	 * Test if this can provide a resource
	 * 
	 * @return true if and only if there is still a resource that this can
	 *         provide
	 */
	public boolean canProvide() {
		return !this.availableResources.isEmpty();
	}

	/**
	 * Tests if a resource is in available resource
	 * 
	 * @param resource
	 *            to test if it is in available resources
	 * @return true if resource is in available resources
	 */
	public boolean isInAvailableResources(Resource resource) {
		return (this.availableResources.get(resource.hashCode()) != null);
	}

	/**
	 * Tests if a resource is in not available resource
	 * 
	 * @param resource
	 *            to test if it is in not available resources
	 * @return true if resource is in not available resources
	 */
	public boolean isInNotAvailableResources(Resource resource) {
		return (this.notAvailableResources.get(resource.hashCode()) != null);
	}

	/**
	 * Free a resource that has been provided earlier
	 * 
	 * @param resourceToFree
	 *            the resource to free
	 * @throws IllegalArgumentException
	 *             if the resource given wasn't provided by this ResourcePool
	 */
	public void freeResource(R resourceToFree) throws IllegalArgumentException {
		if (resourceToFree != null
				&& this.isInNotAvailableResources(resourceToFree)) {
			// we remove the resource from notAvailableResources
			this.notAvailableResources.remove(resourceToFree.hashCode());
			// then put it in available resource
			this.availableResources.put(resourceToFree.hashCode(),
					resourceToFree);
		} else
			throw new IllegalArgumentException();
	}

	/**
	 * Provide a resource if there is still one available
	 * 
	 * @return the provided resource
	 * @throws NoSuchElementException
	 *             if no available resources has been found
	 */
	public R provideResource() throws NoSuchElementException {
		if (!this.canProvide())
			throw new NoSuchElementException();
		R resourceToProvide = this.availableResources.values().iterator()
				.next();
		this.availableResources.remove(resourceToProvide.hashCode());
		this.notAvailableResources.put(resourceToProvide.hashCode(),
				resourceToProvide);
		return resourceToProvide;
	}

}