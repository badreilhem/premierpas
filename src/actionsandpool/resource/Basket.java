package actionsandpool.resource;

/**
 * A basket is a resource that can be provided by BasketPool
 * 
 * @author Honoré Nintunze, Shijin Xu and Xavier Van De Woestyne
 * 
 */
public class Basket implements Resource {

	// Fields
	private static int basketCounter = 0;
	private int id; // id of the basket

	// Constructor
	/**
	 * create a basket
	 */
	public Basket() {
		this.id = basketCounter++;
	}

	// Method
	/*
	 * return a description of the cubicle
	 * 
	 * @see actionsandpool.resource.Resource#description()
	 */
	public String description() {
		return ("basket NO." + id);
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
		Basket other = (Basket) obj;
		if (this.id != other.id)
			return false;
		return true;
	}

}
