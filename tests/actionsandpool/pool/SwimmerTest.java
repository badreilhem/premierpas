/**
 * 
 */
package actionsandpool.pool;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import actionsandpool.action.ForseeableAction;
import actionsandpool.action.exception.ActionFinishedException;
import actionsandpool.action.resourcepoolaction.FreeResourceAction;
import actionsandpool.action.resourcepoolaction.TakeResourceAction;
import actionsandpool.action.scheduler.Scheduler;
import actionsandpool.action.scheduler.SequentialSchedulerTest;
import actionsandpool.mock.SwimmerMock;
import actionsandpool.resource.Basket;
import actionsandpool.resource.Cubicle;
import actionsandpool.resourcefuluser.ResourcefulUser;
import actionsandpool.resourcepool.BasketPool;
import actionsandpool.resourcepool.CubiclePool;

/**
 * Tests for Swimmer
 * 
 * @author Honoré Nintunze, Shijin Xu and Xavier Van De Woestyne
 * 
 */
public class SwimmerTest extends SequentialSchedulerTest {

	@Override
	protected Scheduler createScheduler() {
		return new SwimmerMock("Annie", new BasketPool(6), new CubiclePool(3),
				6, 4, 8);
	}

	@Test
	public void testDoStepOnSwimmer() {
		int numeberOfAvailableBasket = 1;
		int numeberOfAvailableCubicle = 1;
		int timeToUndress = 5;
		int timeToDress = 5;
		int timeToSwim = 5;
		int timeToTakeABasketAndFreeIt = 2 * numeberOfAvailableBasket;
		int timeToTakeACubicleAndFreeIt = 2 * 2 * numeberOfAvailableCubicle;
		ResourcefulUser<Basket> basketUser = new ResourcefulUser<Basket>();
		ResourcefulUser<Cubicle> cubicleUser = new ResourcefulUser<Cubicle>();
		BasketPool baskets = new BasketPool(numeberOfAvailableBasket);
		CubiclePool cubicles = new CubiclePool(numeberOfAvailableCubicle);

		Scheduler swimmer = new SwimmerMock("Axelle", baskets, cubicles,
				timeToUndress, timeToSwim, timeToDress);

		// actions for the swimmer
		swimmer.addAction(new TakeResourceAction<Basket>("", baskets,
				basketUser));
		swimmer.addAction(new TakeResourceAction<Cubicle>("", cubicles,
				cubicleUser));
		swimmer.addAction(new ForseeableAction("", timeToUndress));
		swimmer.addAction(new FreeResourceAction<Cubicle>("", cubicles,
				cubicleUser));
		swimmer.addAction(new ForseeableAction("", timeToSwim));
		swimmer.addAction(new TakeResourceAction<Cubicle>("", cubicles,
				cubicleUser));
		swimmer.addAction(new ForseeableAction("", timeToDress));
		swimmer.addAction(new FreeResourceAction<Cubicle>("", cubicles,
				cubicleUser));
		swimmer.addAction(new FreeResourceAction<Basket>("", baskets,
				basketUser));

		// time to perform all actions
		int time = timeToDress + timeToUndress + timeToSwim
				+ timeToTakeABasketAndFreeIt + timeToTakeACubicleAndFreeIt;
		int stepCounter = 0;

		// perform all actions
		try {
			while (!swimmer.isFinished()) {
				swimmer.doStep();
				stepCounter++;
			}

			// verify that the number of steps performed is the same as expected
			assertEquals(time, stepCounter);
		} catch (ActionFinishedException e) {
			fail("shouldn't throw exception");
		}

	}

	@Test
	public void testInit() {
		int numeberOfAvailableCubicle = 1;
		int numeberOfAvailableBasket = 1;
		int timeToUndress = 5;
		int timeToDress = 5;
		int timeToSwim = 5;
		int timeToTakeABasketAndFreeIt = 2 * numeberOfAvailableBasket;
		int timeToTakeACubicleAndFreeIt = 2 * 2 * numeberOfAvailableCubicle;
		BasketPool baskets = new BasketPool(numeberOfAvailableBasket);
		CubiclePool cubicles = new CubiclePool(numeberOfAvailableCubicle);

		Scheduler swimmer = new Swimmer("Axelle", baskets, cubicles,
				timeToUndress, timeToSwim, timeToDress);

		// time to perform all actions
		int time = timeToDress + timeToUndress + timeToSwim
				+ timeToTakeABasketAndFreeIt + timeToTakeACubicleAndFreeIt;
		int stepCounter = 0;

		// perform all actions
		try {
			while (!swimmer.isFinished()) {
				swimmer.doStep();
				stepCounter++;
			}

			// verify that the number of steps performed is the same as expected
			assertEquals(time, stepCounter);
		} catch (ActionFinishedException e) {
			fail("shouldn't throw exception");
		}
	}
}
