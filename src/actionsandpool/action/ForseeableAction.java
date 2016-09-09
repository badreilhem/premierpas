package actionsandpool.action;

/**
 * ForseeableAction is an action in which the number of steps is known at the
 * construction.
 * 
 * @author Honoré Nintunze, Shijin Xu and Xavier Van De Woestyne
 * 
 */
public class ForseeableAction extends Action {

	// Fields
	protected int stepCounter = 0;
	protected int maxSteps;

	// Constructor

	/**
	 * Create an action with a given number of step to finish it.
	 * 
	 * @param nbSteps
	 *            the number of step of the action
	 * @throws IllegalArgumentException
	 *             if negative value is given to the constructor
	 */
	public ForseeableAction(int nbSteps) throws IllegalArgumentException {
		super();
		if (nbSteps < 0)
			throw new IllegalArgumentException();
		this.maxSteps = nbSteps;
	}

	/**
	 * @param msg
	 *            the description of the action
	 * @param nbSteps
	 *            the number of step of the action
	 * @throws IllegalArgumentException
	 *             if negative value is given to the constructor
	 */
	public ForseeableAction(String msg, int nbSteps)
			throws IllegalArgumentException {
		this(nbSteps);
		this.msg = msg;
	}

	// Methods

	/*
	 * Perform one step of the action
	 * 
	 * @see actionsandpool.action.Action#reallyDoStep()
	 */
	protected void reallyDoStep() {
		this.stepCounter++;
		System.out.printf("(%d/%d)\n", stepCounter, maxSteps);
		if (this.stepCounter < this.maxSteps)
			this.setState(ActionState.INPROGRESS);
		else
			this.setState(ActionState.FINISHED);
	}

}
