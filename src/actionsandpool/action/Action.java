package actionsandpool.action;

import actionsandpool.action.exception.ActionFinishedException;

/**
 * An Action is an object that can progress in time with a determined number of
 * steps from a <strong>ready</strong> state to a <strong>finished</strong>
 * state. A started action is in current state named <strong>in
 * progress</strong>.
 * 
 * @author Honoré Nintunze, Shijin Xu and Xavier Van De Woestyne
 * 
 */
public abstract class Action {

	// FIELDS
	protected ActionState state;
	protected String msg; // a description of the action

	/**
	 * Enum ActionState that represent the different state of an action
	 * 
	 * @author Honoré Nintunze, Shijin Xu and Xavier Van De Woestyne
	 *
	 */
	public enum ActionState {
		READY, INPROGRESS, FINISHED
	}

	// CONSTRUCTOR
	/**
	 * Create an action initialized in state ready.
	 */
	public Action() {
		this.setState(ActionState.READY);
	}

	/**
	 * Create an action initialized in state ready and that has a description.
	 * 
	 * @param msg
	 *            the description of the action
	 */
	public Action(String msg) {
		this();
		this.msg = msg;
	}

	// ABSTRACT METHOD(S)

	/**
	 * Perform one step of the action
	 */
	protected abstract void reallyDoStep();

	// METHOD(S)

	/**
	 * tests if the action is finished before performing the step, and then
	 * perform the action
	 * 
	 * @throws ActionFinishedException
	 *             if action is already finished
	 */
	public void doStep() throws ActionFinishedException {
		if (isFinished()) {
			throw new ActionFinishedException();
		} else {
			if (this.msg != null)
				System.out.printf(this.msg);
			this.reallyDoStep();
		}
	}

	/**
	 * Return true if the action is finished
	 * 
	 * @return true if and only if the action is in FINISHED state
	 */
	public boolean isFinished() {
		return (this.state == ActionState.FINISHED);
	}

	/**
	 * Return true if the action is ready.
	 * 
	 * @return true if and only if the action is ready.
	 */
	public boolean isReady() {
		return (this.state == ActionState.READY);
	}

	/**
	 * Return true if the action is in progress
	 * 
	 * @return true if and only if the action is in progress
	 */
	public boolean isInProgress() {
		return (this.state == ActionState.INPROGRESS);
	}

	/**
	 * Return the actual state
	 * 
	 * @return the state the action is in now.
	 */
	public ActionState getState() {
		return this.state;
	}

	/**
	 * Sets the actual state of the Action
	 * 
	 * @param state
	 *            the state to set
	 */
	protected void setState(ActionState state) {
		this.state = state;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		Action other = (Action) obj;
		if (this.state != other.state)
			return false;
		return true;
	}

}
