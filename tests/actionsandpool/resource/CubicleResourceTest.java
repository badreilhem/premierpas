/**
 * 
 */
package actionsandpool.resource;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

/**
 * Tests for Cubicle resource
 * 
 * @author Honoré Nintunze, Shijin Xu and Xavier Van De Woestyne
 *
 */
public class CubicleResourceTest extends ResourceTest<Cubicle> {

	@Override
	protected Cubicle createResource() {
		return new Cubicle();
	}

	@Test
	public void testNotEquals() {
		Basket basket = new Basket();
		Cubicle cubicle = new Cubicle();
		assertFalse(cubicle.equals(basket));
	}

}
