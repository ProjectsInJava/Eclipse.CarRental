package System.Managers.Ellementaries;

import System.Managers.Enums.TransactionState;

public abstract class TransactionWithState {

	TransactionState _state;
	
	protected TransactionWithState(){
		init();
	}
	
	private void init(){													
		New();			
	}

//endregion
// region ********************************* STATES *****************************************************************************

	public void New(){														
		_state = TransactionState.NEW;			
	}

	public void Ready(){														
		_state = TransactionState.READY;			
	}
	
	public void Active(){														
		_state = TransactionState.ACTIVE;			
	}
	
	public void Car(){
		_state = TransactionState.CAR;		
	}
	
	public void End(){														
		_state = TransactionState.END;			
	}

	public TransactionState GetState(){											
		return _state;		
	}

	public int GetStateOrdinal(){											
		return _state.ordinal();		
	}	
//	
//	public static Consumer<ProcessMyWithState> ChangeStates(){
//		return process -> process.handleStateChange();			
//	}
	
	public int compareStatesTo(TransactionState arg0){ 						
		return GetState().ordinal() - arg0.ordinal();
	}
	
// endregion
// region ********************************* STANDARD_METHODS ******************************** 
	protected int compareTo(TransactionWithState arg0) {		
		int first = GetStateOrdinal() - arg0.GetStateOrdinal() == 0 ? 0 : 1 ;
			
		return first ;
	}
}
