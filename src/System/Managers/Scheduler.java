package System.Managers;

import java.time.Instant;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import System.Collections.Specialize.TransactionQueue;
import System.Hardware.CPU;
import System.Managers.Ellementaries.Transaction;

// TODO: Auto-generated Javadoc
/**
 * The Class Scheduler.
 */
public class Scheduler {

	/**
	 * Checks if is ready to work.
	 *
	 * @return the predicate
	 */
	public static Predicate<Instant> IsReadyToWork() {
		return Scheduler.IsReadyBeforeActualTime().or(time -> time.equals(CPU.Instance.GetClock()));
	}

	/**
	 * Perform.
	 */
	public static void Perform() {

		final List<Transaction> _readyTransactions = CarRental._queueWaiting.stream()
				.filter(transaction -> Scheduler.IsReadyToWork().test(transaction.GetTimeShift()))
				.collect(Collectors.toList());

		CarRental._queueReady.addAll(_readyTransactions);
		CarRental._queueWaiting.removeAll(CarRental._queueReady);

		// **************** SCHEDULING_ALGO ********************

		CarRental._schedAlgo.SupplyPull(CarRental._queueReady);
		CarRental._queueReady = (TransactionQueue) CarRental._schedAlgo.SupplyPush();

		// *************** STATE_CHANGE ************************

		CarRental._queueReady.stream().forEach(transaction -> transaction.Ready());
	}

	/**
	 * Checks if is ready before actual time.
	 *
	 * @return the predicate
	 */
	private static Predicate<Instant> IsReadyBeforeActualTime() {
		return time -> time.isBefore(CPU.Instance.GetClock());
	}
}
