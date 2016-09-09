/**
 * 
 */
package actionsandpool.resource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

/**
 * Tests for resources
 * 
 * @author Honoré Nintunze, Shijin Xu and Xavier Van De Woestyne
 *
 */
public abstract class ResourceTest<R extends Resource> {

	@Test
	public void testEquals() {
		R resource1 = createResource();
		R resource2 = createResource();
		assertFalse(resource1.equals(resource2));
		assertEquals(resource1, resource1);
		assertEquals(resource2, resource2);
	}

	protected abstract R createResource();

}
