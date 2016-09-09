package actionsandpool.action.scheduler;

import actionsandpool.action.Action;

/**
 * A FairScheduler is a Scheduler the progression of its action is done in
 * parallel.
 * 
 * @author Honoré Nintunze, Shijin Xu and Xavier Van De Woestyne
 * 
 */
public class FairScheduler extends Scheduler {

	// Constructor
	/**
	 * create a fair scheduler with description
	 */
	public FairScheduler() {
		super();
	}

	/**
	 * create a fair scheduler with description
	 * 
	 * @param msg
	 *            the description of the action
	 */
	public FairScheduler(String msg) {
		super(msg);
	}

	// Methods

	/**
	 * Push current action to the end of the list
	 */
	protected void currentToEnd() {
		Action c = this.actionList.remove(0);
		this.addAction(c);
	}

	/*
	 * perform a step of the action
	 * 
	 * @see actionsandpool.action.scheduler.Scheduler#reallyDoStep()
	 */
	@Override
	protected void reallyDoStep() {
		try {
			currentAction = nextActionUnfinished();
			doStepOnCurrentAction();
			if (currentAction.isFinished())
				removeAction(currentAction);
			else
				this.currentToEnd();
		} catch (Exception e) { // if no action is unfinished
			this.setState(ActionState.FINISHED);
		}

	}

}
