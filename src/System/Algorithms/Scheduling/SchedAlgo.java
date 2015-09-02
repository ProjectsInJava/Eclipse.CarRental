package System.Algorithms.Scheduling;

import java.util.Comparator;

import System.Collections.Specialize.TransactionQueue;

// TODO: Auto-generated Javadoc
/**
 * The Class SchedAlgo.
 */
public abstract class SchedAlgo implements IServer {
	// region ******************************** MEMBERS
	/** The _temp register. */
	// ********************************
	protected TransactionQueue _tempRegister;

	/**
	 * Order.
	 */
	public void order() {
		_tempRegister.sort(Comparator.comparing(process -> process.GetTimeShift()));
	}
	// endregion

	// endregion
	// region ******************************** OVERLOADED
	/*
	 * (non-Javadoc)
	 * 
	 * @see System.Algorithms.Scheduling.IServer#SupplyPull(java.lang.Object)
	 */
	// ********************************
	@Override
	public void SupplyPull(Object aValue) {
		_tempRegister = (TransactionQueue) aValue;
	}

	// endregion
	// region ******************************** ORDER
	// ********************************

	/*
	 * (non-Javadoc)
	 * 
	 * @see System.Algorithms.Scheduling.IServer#SupplyPush()
	 */
	@Override
	public Object SupplyPush() {
		order();
		return _tempRegister;
	}
}