package System.Algorithms.Scheduling;

import java.util.Comparator;

import System.Collections.Specialize.TransactionQueue;

public abstract class SchedAlgo implements IServer{
// region ******************************** MEMBERS ********************************
	protected TransactionQueue _tempRegister;
	// endregion
// region ******************************** OVERLOADED ********************************
	@Override
	public void SupplyPull(Object aValue) {
		_tempRegister = (TransactionQueue) aValue;
	}

	@Override
	public Object SupplyPush() {
		order();
		return _tempRegister;
	}
	
	// endregion
// region ******************************** ORDER ********************************
	
	public void order() {
		_tempRegister.sort(Comparator.comparing(process -> process.GetTimeShift()));
	}
	// endregion
}