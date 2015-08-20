package System.Managers.Ellementaries;

import java.time.Instant;
import java.util.Comparator;


public class TransactionWithTime extends TransactionWithState{

	private Instant _timeStartShift;
	private Instant _timeProcessorTotal;
	private Instant _timeWaiting;
	
// region ******************************** CTORS *********************************	
	protected TransactionWithTime(){
		super();
		
		_timeStartShift = Instant.ofEpochSecond(0);
		_timeProcessorTotal = Instant.ofEpochSecond(0);
		_timeWaiting = Instant.ofEpochSecond(0);
	}
	
	protected TransactionWithTime(Instant aTimeShift ,String aDuration){
		super();
		
		_timeStartShift = aTimeShift;
		_timeProcessorTotal = Instant.ofEpochSecond(Long.parseLong(aDuration));
		_timeWaiting = Instant.ofEpochSecond(0);
	}
// endregion
// region ******************************** Property_access_methods **************

	public long GetTimeExecuteValue(){
		return _timeProcessorTotal.getEpochSecond();
	}
	
	public Instant GetTimeWaiting(){
		return _timeWaiting;
	}
	
	public long GetTimeWaitingValue(){
		return _timeWaiting.getEpochSecond();
	}
	
	public Instant GetTimeShift(){
		return _timeStartShift;
	}

	public Instant GetTimeExecute(){
		return _timeProcessorTotal;
	}

	public void SetTimeShift(long aValue){
		_timeStartShift = Instant.ofEpochSecond(aValue);
	}
	
	public void SetTimeShift(Instant aValue){
		_timeStartShift = aValue;
	}

	public void SetTimeExecute(long aValue){
		_timeProcessorTotal = Instant.ofEpochSecond(aValue);
	}
	
	public void SetTimeExecute(Instant aValue){
		_timeProcessorTotal = aValue;
	}
	
	public void SetTimeWaiting(Instant aValue){
		_timeWaiting = aValue;
	}
// endregion
	
	public void DecreaseTimeExecute(long aElapsed){
		_timeProcessorTotal = _timeProcessorTotal.minusSeconds(aElapsed);
	}

	public void IncreaseTimeExecute(long aElapsed){
		_timeProcessorTotal = _timeProcessorTotal.plusSeconds(aElapsed);
	}


	public static Comparator<?> TimeShiftComparator(){

		return Comparator.comparing(process-> ((TransactionWithTime) process).GetTimeShift());
	}
	

	public void IncreaseTimeWaiting(long aElapsed){
		_timeWaiting = _timeWaiting.plusSeconds(aElapsed);
	}

	public void DecreaseTimeWaiting(long aElapsed){
		_timeWaiting = _timeWaiting.minusSeconds(aElapsed);
	}

	
	public boolean handleStateChange(){		
		
		boolean valRet = false;
		
		if(GetTimeExecute().equals(Instant.ofEpochSecond(0)))	
			{
				End();	
				valRet = true;
			}
		
		return valRet;
	}
}
