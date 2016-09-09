/**
 * 
 */
package actionsandpool.mock;

import actionsandpool.action.ForseeableAction;

/**
 * OneStepAction is a mock for testing Action. It is an action with only one
 * step
 * 
 * @author Honoré Nintunze, Shijin Xu and Xavier Van De Woestyne
 * 
 */
public class OneStepAction extends ForseeableAction {

	public OneStepAction() throws IllegalArgumentException {
		super(1);
	}

}
