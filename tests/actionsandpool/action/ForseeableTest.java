/**
 * 
 */
package actionsandpool.action;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import actionsandpool.action.Action;
import actionsandpool.action.ForseeableAction;
import actionsandpool.action.exception.ActionFinishedException;

/**
 * Test class for ForseeableAction
 * 
 * @author Honoré Nintunze, Shijin Xu and Xavier Van De Woestyne
 * 
 */
public class ForseeableTest extends ActionTest {

	protected Action createAction() {
		return new ForseeableAction(7);
	}

	/**
	 * Test method for
	 * {@link actionsandpool.action.action.ForseeableAction#reallyDoStep()}
	 * 
	 * @throws ActionFinishedException
	 */
	@Test
	public void reallyDoStepsWith5StepsActionFinishesAnAction()
			throws ActionFinishedException {
		Action action = new ForseeableAction(5); // action with 5 steps
		assertFalse(action.isFinished());

		action.doStep(); // 1 step done
		for (int i = 0; i < 4; i++)
			// 4 more
			action.doStep();

		assertTrue(action.isFinished());

	}

	/**
	 * Test for constructor
	 * {@link actionsandpool.action.action.ForseeableAction#ForseeableAction(int)}
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorThrowsExceptionIfWrongArgumentGiven() {
		new ForseeableAction(-1);
	}
}
