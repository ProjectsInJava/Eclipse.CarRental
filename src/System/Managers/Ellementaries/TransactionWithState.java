package System.Managers.Ellementaries;

import System.Managers.Enums.TransactionState;

// TODO: Auto-generated Javadoc
/**
 * The Class TransactionWithState.
 */
public abstract class TransactionWithState {

	/** The _state. */
	TransactionState _state;

	/**
	 * Instantiates a new transaction with state.
	 */
	protected TransactionWithState() {
		init();
	}

	/**
	 * Active.
	 */
	public void Active() {
		_state = TransactionState.ACTIVE;
	}

	// endregion
	// region ********************************* STATES
	// *****************************************************************************

	/**
	 * Car.
	 */
	public void Car() {
		_state = TransactionState.CAR;
	}

	/**
	 * Compare states to.
	 *
	 * @param arg0
	 *            the arg0
	 * @return the int
	 */
	public int compareStatesTo(TransactionState arg0) {
		return GetState().ordinal() - arg0.ordinal();
	}

	/**
	 * End.
	 */
	public void End() {
		_state = TransactionState.END;
	}

	/**
	 * Gets the state.
	 *
	 * @return the transaction state
	 */
	public TransactionState GetState() {
		return _state;
	}

	/**
	 * Gets the state ordinal.
	 *
	 * @return the int
	 */
	public int GetStateOrdinal() {
		return _state.ordinal();
	}
	//
	// public static Consumer<ProcessMyWithState> ChangeStates(){
	// return process -> process.handleStateChange();
	// }

	/**
	 * New.
	 */
	public void New() {
		_state = TransactionState.NEW;
	}

	/**
	 * Ready.
	 */
	public void Ready() {
		_state = TransactionState.READY;
	}

	// endregion
	/**
	 * Compare to.
	 *
	 * @param arg0
	 *            the arg0
	 * @return the int
	 */
	// region ********************************* STANDARD_METHODS
	// ********************************
	protected int compareTo(TransactionWithState arg0) {
		final int first = GetStateOrdinal() - arg0.GetStateOrdinal() == 0 ? 0 : 1;

		return first;
	}

	/**
	 * Inits the.
	 */
	private void init() {
		New();
	}
}
