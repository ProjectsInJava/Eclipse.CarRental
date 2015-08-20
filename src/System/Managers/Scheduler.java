package System.Managers;

import java.time.Instant;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import System.Collections.Specialize.TransactionQueue;
import System.Hardware.CPU;
import System.Managers.Ellementaries.Transaction;

public class Scheduler {
	
	public static void Perform() {	
		
		List<Transaction> _readyTransactions = CarRental._queueWaiting.stream()
				.filter(transaction -> IsReadyToWork().test(transaction.GetTimeShift()))
				.collect(Collectors.toList());
		
		CarRental._queueReady.addAll(_readyTransactions);
		CarRental._queueWaiting.removeAll(CarRental._queueReady);

		// **************** SCHEDULING_ALGO ********************
		
		CarRental._schedAlgo.SupplyPull(CarRental._queueReady);
		CarRental._queueReady = (TransactionQueue) CarRental._schedAlgo.SupplyPush();		
		
		// *************** STATE_CHANGE ************************
		
		CarRental._queueReady.stream()
		.forEach(transaction -> transaction.Ready());
	}
	
	private static Predicate <Instant> IsReadyBeforeActualTime(){ 
		return time-> time.isBefore(CPU.Instance.GetClock());
	}
	
	public static Predicate <Instant> IsReadyToWork(){
		return IsReadyBeforeActualTime().or(time -> time.equals(CPU.Instance.GetClock()));
	}
}
