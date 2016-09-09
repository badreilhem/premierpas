package actionsandpool.pool;

import actionsandpool.action.exception.ActionFinishedException;
import actionsandpool.action.scheduler.FairScheduler;
import actionsandpool.resourcepool.BasketPool;
import actionsandpool.resourcepool.CubiclePool;

public class Pool {

	public static void main(String[] args) throws ActionFinishedException {
		BasketPool baskets = new BasketPool(6);
		CubiclePool cubicles = new CubiclePool(3);
		FairScheduler s = new FairScheduler();

		s.addAction(new Swimmer("Jean", baskets, cubicles, 6, 4, 8));
		s.addAction(new Swimmer("Paul", baskets, cubicles, 2, 10, 4));
		s.addAction(new Swimmer("Bruno", baskets, cubicles, 10, 18, 10));
		s.addAction(new Swimmer("Marcel", baskets, cubicles, 3, 7, 5));
		s.addAction(new Swimmer("Anatole", baskets, cubicles, 18, 3, 3));
		s.addAction(new Swimmer("Clement", baskets, cubicles, 3, 6, 10));
		s.addAction(new Swimmer("Desire", baskets, cubicles, 6, 5, 7));

		int nbSteps = 0;
		while (!s.isFinished()) {
			nbSteps++;
			s.doStep();
		}
		System.out.println("Finished in " + nbSteps + " steps");
	}
}
