/**
 * 
 */
package actionsandpool.action.scheduler;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import actionsandpool.action.Action;
import actionsandpool.action.ActionTest;
import actionsandpool.action.ForseeableAction;
import actionsandpool.mock.OneStepAction;

/**
 * Tests for schedulers
 * 
 * @author Honoré Nintunze, Shijin Xu and Xavier Van De Woestyne
 * 
 */
public abstract class SchedulerTest extends ActionTest {

	/** creates a new scheduler */
	protected abstract Scheduler createScheduler();

	/**
	 * create an action which is a scheduler with two OneStepAction in it
	 */
	protected Action createAction() {
		Scheduler scheduler = createScheduler();
		scheduler.addAction(new OneStepAction());
		scheduler.addAction(new OneStepAction());
		return scheduler;
	}

	/**
	 * Test method for
	 * {@link actionsandpool.action.action.scheduler.Scheduler#reallyDoStep()} .
	 */
	@Test
	public void testSchedulerContainingOnlyOneStepAction() throws Exception {
		OneStepAction action1 = new OneStepAction();
		Scheduler scheduler = createScheduler();
		scheduler.addAction(action1);

		assertFalse(scheduler.isFinished());
		assertFalse(action1.isFinished());

		scheduler.doStep();

		assertTrue(scheduler.isFinished());
		assertTrue(action1.isFinished());
	}

	/**
	 * Another test method for
	 * {@link actionsandpool.action.action.scheduler.Scheduler#reallyDoStep()} .
	 */
	@Test
	public void testSchedulerContainingTwoOneStepAction() throws Exception {
		Action action = createAction();
		assertFalse(action.isFinished());
		for (int i = 0; i < 2; i++)
			action.doStep();

		assertTrue(action.isFinished());
	}

	/**
	 * Test method for
	 * {@link actionsandpool.action.action.scheduler.Scheduler#addAction(actionsandpool.action.action.Action)}
	 * .
	 */
	@Test
	public void testAddAction() {
		Scheduler scheduler = createScheduler();
		assertTrue(scheduler.addAction(new ForseeableAction(1)));
	}

}
