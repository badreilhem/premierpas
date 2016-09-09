package actionsandpool.pool;

import actionsandpool.action.ForseeableAction;
import actionsandpool.action.resourcepoolaction.FreeResourceAction;
import actionsandpool.action.resourcepoolaction.TakeResourceAction;
import actionsandpool.action.scheduler.SequentialScheduler;
import actionsandpool.resource.Basket;
import actionsandpool.resource.Cubicle;
import actionsandpool.resourcefuluser.ResourcefulUser;
import actionsandpool.resourcepool.BasketPool;
import actionsandpool.resourcepool.CubiclePool;

/**
 * Swimmer represent a swimmer who wants to go to the swimming pool and has to
 * perform actions in a specific order.
 * 
 * @author Honoré Nintunze, Shijin Xu and Xavier Van De Woestyne
 * 
 */
public class Swimmer extends SequentialScheduler {
	protected String name;
	protected BasketPool baskets;
	protected CubiclePool cubicles;
	protected int timeToUndress;
	protected int timeToSwim;
	protected int timeToDress;
	protected ResourcefulUser<Basket> basketUser;
	protected ResourcefulUser<Cubicle> cubicleUser;

	/**
	 * Create a Swimmer
	 * 
	 * @param name
	 *            the name of the swimmer
	 * @param baskets
	 *            the baskets administrator
	 * @param cubicles
	 *            the cubicles administrator
	 * @param timeToUndress
	 *            the time it takes to undress
	 * @param timeToSwim
	 *            the time it take to swim
	 * @param timeToDress
	 *            the time it takes to dress
	 */
	public Swimmer(String name, BasketPool baskets, CubiclePool cubicles,
			int timeToUndress, int timeToSwim, int timeToDress) {
		super((name + "'s turn\n"));
		this.name = name;
		this.baskets = baskets;
		this.cubicles = cubicles;
		this.timeToDress = timeToDress;
		this.timeToSwim = timeToSwim;
		this.timeToUndress = timeToUndress;
		this.basketUser = new ResourcefulUser<Basket>();
		this.cubicleUser = new ResourcefulUser<Cubicle>();
		this.init();
	}

	/**
	 * add actions that the swimmer has to perform at the swimming pool.
	 */
	protected void init() {
		addAction(new TakeResourceAction<Basket>(" " + this.name
				+ " trying to take resource from pool basket... ",
				this.baskets, this.basketUser));
		/* 1.firstly take a basket */
		addAction(new TakeResourceAction<Cubicle>(" " + this.name
				+ " trying to take resource from pool cubicle... ",
				this.cubicles, this.cubicleUser));
		/* 2.secondly enter a cubicle */
		addAction(new ForseeableAction(" " + this.name + " undressing ",
				this.timeToUndress));
		/* 3.thirdly he takes off his clothes */
		addAction(new FreeResourceAction<Cubicle>(" " + this.name
				+ " freeing resource from pool cubicle... ", this.cubicles,
				this.cubicleUser));
		/* 4.go out of the cubicle */
		addAction(new ForseeableAction(" " + this.name + " swimming ",
				this.timeToSwim));
		/* 5.swimming in the pool */
		addAction(new TakeResourceAction<Cubicle>(" " + this.name
				+ " trying to take resource from pool cubicle... ",
				this.cubicles, this.cubicleUser));
		/* 6.enter cubicle again */
		addAction(new ForseeableAction(" " + this.name + " dressing ",
				this.timeToDress));
		/* 7.dressing */
		addAction(new FreeResourceAction<Cubicle>(" " + this.name
				+ " freeing resource from pool cubicle... ", this.cubicles,
				this.cubicleUser));
		/* 8. go out of the cubicle */
		addAction(new FreeResourceAction<Basket>(" " + this.name
				+ " freeing resource from pool basket... ", this.baskets,
				this.basketUser));
		/* 9 finally give back the basket */
	}

}
