/**
 * 
 */
package actionsandpool.resource;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests for Basket resource
 * 
 * @author Honoré Nintunze, Shijin Xu and Xavier Van De Woestyne
 *
 */
public class BasketResourceTest extends ResourceTest<Basket> {

	@Override
	protected Basket createResource() {
		return new Basket();
	}

	@Test
	public void testNotEquals() {
		Basket basket = new Basket();
		Cubicle cubicle = new Cubicle();
		assertFalse(basket.equals(cubicle));
	}

}
