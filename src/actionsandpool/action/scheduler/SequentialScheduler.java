package actionsandpool.action.scheduler;

/**
 * In a SequentialScheduler, the action are ordered and are terminated one by
 * one.
 * 
 * @author Honoré Nintunze, Shijin Xu and Xavier Van De Woestyne
 */
public class SequentialScheduler extends Scheduler {

	// Constructor
	/**
	 * create a sequential scheduler
	 */
	public SequentialScheduler() {
		super();
	}

	/**
	 * create a sequential scheduler with description
	 * 
	 * @param msg
	 *            the description of the action
	 */
	public SequentialScheduler(String msg) {
		super(msg);
	}

	// Methods

	/*
	 * Perform one step of the action
	 * 
	 * @see actionsandpool.action.action.scheduler.Scheduler#reallyDoStep()
	 */
	@Override
	protected void reallyDoStep() {
		try {
			if (currentAction.isFinished()) {
				removeAction(currentAction);
				currentAction = nextActionUnfinished();
				this.doStepOnCurrentAction();
			} else
				doStepOnCurrentAction();

		} catch (Exception e) { // if no action is unfinished
			this.setState(ActionState.FINISHED);
		}

	}

}
