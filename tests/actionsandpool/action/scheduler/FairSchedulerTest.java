/**
 * 
 */
package actionsandpool.action.scheduler;

import static org.junit.Assert.*;

import org.junit.Test;

import actionsandpool.action.Action;
import actionsandpool.action.exception.ActionFinishedException;
import actionsandpool.mock.OneStepAction;
import actionsandpool.mock.TwoStepAction;

/**
 * Tests for fair scheduler
 * 
 * @author Honoré Nintunze, Shijin Xu and Xavier Van De Woestyne
 *
 */
public class FairSchedulerTest extends SchedulerTest {

	@Override
	protected Scheduler createScheduler() {
		return new FairScheduler();
	}

	@Test
	public void testDoStepIsFair() throws ActionFinishedException {
		Action action1 = new TwoStepAction();
		Action action2 = new OneStepAction();
		FairScheduler scheduler = new FairScheduler();
		scheduler.addAction(action1);
		scheduler.addAction(action2);

		try {
			assertFalse(action1.isFinished()); // step 0/2
			assertFalse(action2.isFinished()); // step 0/1

			scheduler.doStep(); // doStep on action1, action1 in progress
			assertFalse(action1.isFinished()); // step 1/2
			assertFalse(action2.isFinished()); // step 0/1

			scheduler.doStep(); // doStep on action2, action2 finishes
			assertFalse(action1.isFinished()); // step 1/2
			assertTrue(action2.isFinished()); // step 1/1

			scheduler.doStep(); // doStep on action1 again and action1 finishes
			assertTrue(action1.isFinished()); // step 2/2
			assertTrue(action2.isFinished()); // step 1/1

		} catch (ActionFinishedException e) {
			fail("The scheduler shouldn't have finished.");
		}
	}
}
