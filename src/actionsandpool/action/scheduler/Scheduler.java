package actionsandpool.action.scheduler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

import actionsandpool.action.Action;
import actionsandpool.action.exception.ActionFinishedException;

/**
 * A Scheduler is an action that owns a set of actions. You can use a scheduler
 * to make progress these actions.
 * 
 * @author Honoré Nintunze, Shijin Xu and Xavier Van De Woestyne
 * 
 */
public abstract class Scheduler extends Action {

	// Fields
	protected ArrayList<Action> actionList;
	protected Action currentAction;

	// Constructor
	/**
	 * create a scheduler
	 */
	public Scheduler() {
		this.actionList = new ArrayList<Action>();
	}

	/**
	 * create a scheduler with a description
	 * 
	 * @param msg
	 *            the description of the action
	 */
	public Scheduler(String msg) {
		super(msg);
		this.actionList = new ArrayList<Action>();
	}

	// Methods

	// abstract method

	/*
	 * Perform one step of the action
	 * 
	 * @see actionsandpool.action.action.Action#reallyDoStep()
	 */
	protected abstract void reallyDoStep();

	// concrete method

	/*
	 * tests if the action is finished before performing the step
	 * 
	 * @see actionsandpool.action.action.Action#doStep()
	 */
	@Override
	public void doStep() throws ActionFinishedException {
		this.initializeCurrentAction();
		super.doStep();
		try {
			// we check that there is still an action unfinished otherwise the
			// scheduler should be in FINISHED state
			this.nextActionUnfinished();
		} catch (NoSuchElementException e) {
			this.setState(ActionState.FINISHED);
		}
	}

	/**
	 * If currentAction isn't set, the method take an unfinished action from the
	 * list and put it in the field
	 */
	protected void initializeCurrentAction() {
		if (this.currentAction == null)
			this.currentAction = this.nextActionUnfinished();
	}

	/**
	 * Add the action in parameter to the list of action of the scheduler
	 * 
	 * @param action
	 *            to add in the list
	 * @return true (as specified in {@link java.util.Collection#add(Object)})
	 */
	public boolean addAction(Action action) {
		return this.actionList.add(action);
	}

	/**
	 * Remove the action given in parameter
	 * 
	 * @param action
	 *            the action to remove
	 * 
	 */
	protected void removeAction(Action action) {
		/*
		 * Iterator<Action> iterator = actionList.iterator(); while
		 * (iterator.hasNext()) { Action itResult = iterator.next(); if
		 * (action.equals(itResult)) { iterator.remove(); return; } }
		 */
		actionList.remove(action);
	}

	/**
	 * Return the next Action unfinished.
	 * 
	 * @return the next Action in the list that isn't finished.
	 * @throws ActionFinishedException
	 *             if no action found.
	 */
	protected Action nextActionUnfinished() throws NoSuchElementException {
		Iterator<Action> iterator = this.actionList.iterator();
		Action action;
		while (iterator.hasNext()) {
			action = iterator.next();
			if (!action.isFinished())
				return action;
		}
		throw new NoSuchElementException();
	}

	/**
	 * Apply doStep on the current action
	 * 
	 * @throws ActionFinishedException
	 *             if currentAction is finished
	 */
	protected void doStepOnCurrentAction() throws ActionFinishedException {
		this.currentAction.doStep();
		this.setState(ActionState.INPROGRESS);
	}

	/*
	 * Return true if obj is equals to this.
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Scheduler other = (Scheduler) obj;
		if (this.actionList == null) {
			if (other.actionList != null)
				return false;
		} else if (!this.actionList.equals(other.actionList))
			return false;
		if (this.currentAction == null) {
			if (other.currentAction != null)
				return false;
		} else if (!this.currentAction.equals(other.currentAction))
			return false;
		return true;
	}

}
