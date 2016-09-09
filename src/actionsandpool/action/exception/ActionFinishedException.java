package actionsandpool.action.exception;

/**
 * ActionFinishedException is thrown when we want to perform a step on an action
 * already finished
 * 
 * @author Honoré Nintunze, Shijin Xu and Xavier Van De Woestyne
 * 
 */
public class ActionFinishedException extends Exception {

	private static final long serialVersionUID = 1L;

	// Constructors

	public ActionFinishedException() {
		super();
	}

	public ActionFinishedException(String msg) {
		super(msg);
	}

	public ActionFinishedException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public ActionFinishedException(Throwable cause) {
		super(cause);
	}

}
