package System.Managers.Ellementaries;

import java.time.Instant;
import java.util.Comparator;

// TODO: Auto-generated Javadoc
/**
 * The Class TransactionWithTime.
 */
public class TransactionWithTime extends TransactionWithState {

	/** The _time processor total. */
	private Instant _timeProcessorTotal;

	/** The _time start shift. */
	private Instant _timeStartShift;

	/** The _time waiting. */
	private Instant _timeWaiting;

	/**
	 * Instantiates a new transaction with time.
	 */
	// region ******************************** CTORS
	// *********************************
	protected TransactionWithTime() {
		super();

		_timeStartShift = Instant.ofEpochSecond(0);
		_timeProcessorTotal = Instant.ofEpochSecond(0);
		_timeWaiting = Instant.ofEpochSecond(0);
	}

	/**
	 * Instantiates a new transaction with time.
	 *
	 * @param aTimeShift
	 *            the a time shift
	 * @param aDuration
	 *            the a duration
	 */
	protected TransactionWithTime(Instant aTimeShift, String aDuration) {
		super();

		_timeStartShift = aTimeShift;
		_timeProcessorTotal = Instant.ofEpochSecond(Long.parseLong(aDuration));
		_timeWaiting = Instant.ofEpochSecond(0);
	}
	// endregion
	// region ******************************** Property_access_methods
	// **************

	/**
	 * Time shift comparator.
	 *
	 * @return the comparator
	 */
	public static Comparator<?> TimeShiftComparator() {

		return Comparator.comparing(process -> ((TransactionWithTime) process).GetTimeShift());
	}

	/**
	 * Decrease time execute.
	 *
	 * @param aElapsed
	 *            the a elapsed
	 */
	public void DecreaseTimeExecute(long aElapsed) {
		_timeProcessorTotal = _timeProcessorTotal.minusSeconds(aElapsed);
	}

	/**
	 * Decrease time waiting.
	 *
	 * @param aElapsed
	 *            the a elapsed
	 */
	public void DecreaseTimeWaiting(long aElapsed) {
		_timeWaiting = _timeWaiting.minusSeconds(aElapsed);
	}

	/**
	 * Gets the time execute.
	 *
	 * @return the instant
	 */
	public Instant GetTimeExecute() {
		return _timeProcessorTotal;
	}

	/**
	 * Gets the time execute value.
	 *
	 * @return the long
	 */
	public long GetTimeExecuteValue() {
		return _timeProcessorTotal.getEpochSecond();
	}

	/**
	 * Gets the time shift.
	 *
	 * @return the instant
	 */
	public Instant GetTimeShift() {
		return _timeStartShift;
	}

	/**
	 * Gets the time waiting.
	 *
	 * @return the instant
	 */
	public Instant GetTimeWaiting() {
		return _timeWaiting;
	}

	/**
	 * Gets the time waiting value.
	 *
	 * @return the long
	 */
	public long GetTimeWaitingValue() {
		return _timeWaiting.getEpochSecond();
	}

	/**
	 * Handle state change.
	 *
	 * @return true, if successful
	 */
	public boolean handleStateChange() {

		boolean valRet = false;

		if (GetTimeExecute().equals(Instant.ofEpochSecond(0))) {
			End();
			valRet = true;
		}

		return valRet;
	}

	/**
	 * Increase time execute.
	 *
	 * @param aElapsed
	 *            the a elapsed
	 */
	public void IncreaseTimeExecute(long aElapsed) {
		_timeProcessorTotal = _timeProcessorTotal.plusSeconds(aElapsed);
	}

	/**
	 * Increase time waiting.
	 *
	 * @param aElapsed
	 *            the a elapsed
	 */
	public void IncreaseTimeWaiting(long aElapsed) {
		_timeWaiting = _timeWaiting.plusSeconds(aElapsed);
	}

	/**
	 * Sets the time execute.
	 *
	 * @param aValue
	 *            the a value
	 */
	public void SetTimeExecute(Instant aValue) {
		_timeProcessorTotal = aValue;
	}

	/**
	 * Sets the time execute.
	 *
	 * @param aValue
	 *            the a value
	 */
	public void SetTimeExecute(long aValue) {
		_timeProcessorTotal = Instant.ofEpochSecond(aValue);
	}

	/**
	 * Sets the time shift.
	 *
	 * @param aValue
	 *            the a value
	 */
	public void SetTimeShift(Instant aValue) {
		_timeStartShift = aValue;
	}

	/**
	 * Sets the time shift.
	 *
	 * @param aValue
	 *            the a value
	 */
	public void SetTimeShift(long aValue) {
		_timeStartShift = Instant.ofEpochSecond(aValue);
	}

	/**
	 * Sets the time waiting.
	 *
	 * @param aValue
	 *            the a value
	 */
	public void SetTimeWaiting(Instant aValue) {
		_timeWaiting = aValue;
	}
	// endregion
}
