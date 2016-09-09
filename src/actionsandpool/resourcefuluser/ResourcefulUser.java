package actionsandpool.resourcefuluser;

import actionsandpool.resource.Resource;

public class ResourcefulUser<R extends Resource> {
	protected R ressource;

	/**
	 * return the resource that this ResourcefulUser is using
	 * 
	 * @return the resource that this ResourcefulUser is using
	 */
	public R getRessource() {
		return this.ressource;
	}

	/**
	 * give a resource to this ResourcefulUser
	 * 
	 * @param ressource
	 *            the resource to give to this ResourcefulUser
	 */
	public void setRessource(R ressource) {
		this.ressource = ressource;
	}

	/**
	 * tell the ResourcefulUser that he doesn't have a resource anymore
	 */
	public void resetRessource() {
		this.ressource = null;
	}
}
