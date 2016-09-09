/**
 * 
 */
package actionsandpool.action;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import actionsandpool.action.Action;
import actionsandpool.action.Action.ActionState;
import actionsandpool.action.ForseeableAction;
import actionsandpool.action.exception.ActionFinishedException;

/**
 * Test class for Action
 * 
 * @author Honoré Nintunze, Shijin Xu and Xavier Van De Woestyne
 * 
 */
public abstract class ActionTest {

	protected abstract Action createAction();

	@Test(expected = ActionFinishedException.class)
	public void doStepWhileFinishdedThrowsException()
			throws ActionFinishedException {
		Action action = createAction();
		while (!action.isFinished()) {
			try {
				action.doStep();
			} catch (ActionFinishedException e) {
				fail("action was not supposed to be finished, we just checked");
			}
		}
		assertTrue(action.isFinished());
		action.doStep(); // this should throw the ActionFinishedException
	}

	/**
	 * Test method for {@link actionsandpool.action.action.Action#isFinished()}.
	 * 
	 * @throws ActionFinishedException
	 */
	@Test
	public void testIsFinished() throws ActionFinishedException {
		Action action = createAction(); // action is finished in one
										// step
		assertFalse(action.isFinished());
		action.doStep();
		while (!action.isFinished()) {
			assertFalse(action.isFinished());
			action.doStep();
		}
		assertTrue(action.isFinished());
	}

	/**
	 * Test method for {@link actionsandpool.action.action.Action#getState()}.
	 * 
	 * @throws ActionFinishedException
	 */
	@Test
	public void testGetStateAndStateTest() throws ActionFinishedException {
		Action action = new ForseeableAction(2); // action is finished in two
													// step
		assertEquals(ActionState.READY, action.getState());
		assertTrue(action.isReady());
		assertFalse(action.isFinished());
		assertFalse(action.isInProgress());
		action.doStep();
		assertEquals(ActionState.INPROGRESS, action.getState());
		assertTrue(action.isInProgress());
		assertFalse(action.isReady());
		assertFalse(action.isFinished());
		action.doStep();
		assertEquals(ActionState.FINISHED, action.getState());
		assertTrue(action.isFinished());
		assertFalse(action.isInProgress());
		assertFalse(action.isReady());
	}

	/**
	 * Test method for
	 * {@link actionsandpool.action.action.Action#setState(actionsandpool.action.action.Action.ActionState)}
	 * .
	 * 
	 * @throws ActionFinishedException
	 */
	@Test
	public void testOnlyOneStateIsActiveAtATime()
			throws ActionFinishedException {
		Action action = createAction();

		assertTrue("1", ActionState.READY == action.getState());
		assertFalse("2", ActionState.INPROGRESS == action.getState());
		assertFalse("3", ActionState.FINISHED == action.getState());
		action.doStep();
		while (!action.isFinished()) {
			assertFalse("4", ActionState.READY == action.getState());
			assertTrue("5", ActionState.INPROGRESS == action.getState());
			assertFalse("6", ActionState.FINISHED == action.getState());
			action.doStep();
		}

		assertFalse("7", ActionState.READY == action.getState());
		assertFalse("8", ActionState.INPROGRESS == action.getState());
		assertTrue("9", ActionState.FINISHED == action.getState());
	}

}
