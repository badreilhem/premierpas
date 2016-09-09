/**
 * 
 */
package actionsandpool.mock;

import actionsandpool.pool.Swimmer;
import actionsandpool.resourcepool.BasketPool;
import actionsandpool.resourcepool.CubiclePool;

/**
 * SwimmerMock is a mock for testing Swimmer. It is a sequentialScheduler with
 * no action in it
 * 
 * @author Honoré Nintunze, Shijin Xu and Xavier Van De Woestyne
 * 
 */
public class SwimmerMock extends Swimmer {

	public SwimmerMock(String name, BasketPool baskets, CubiclePool cubicles,
			int timeToUndress, int timeToSwim, int timeToDress) {
		super(name, baskets, cubicles, timeToUndress, timeToSwim, timeToDress);
	}

	protected void init() {
		// does nothing
	}

}
