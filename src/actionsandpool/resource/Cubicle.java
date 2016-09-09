package actionsandpool.resource;

/**
 * A cubicle is a resource that can be provided by CubiclePool
 * 
 * @author Honoré Nintunze, Shijin Xu and Xavier Van De Woestyne
 * 
 */
public class Cubicle implements Resource {

	// Fields
	private static int cubicleCounter = 0;
	private int id; // id of the cubicle

	// Constructor
	/**
	 * create a cubicle
	 */
	public Cubicle() {
		this.id = cubicleCounter++;
	}

	// Method
	/*
	 * return a description of the cubicle
	 * 
	 * @see actionsandpool.resource.Resource#description()
	 */
	public String description() {
		return ("cubicle NO." + id);
	}

	/*
	 * return the hashcode for cubicle
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	/*
	 * return true if this cubicle is equals to object given in parameter
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		Cubicle other = (Cubicle) obj;
		if (this.id != other.id)
			return false;
		return true;
	}

}
