package System.Managers;

import java.util.LinkedList;

import System.Managers.Ellementaries.Transaction;


@SuppressWarnings("serial")
public class MetricsCalculator extends LinkedList<Transaction>{
	
	public Integer GetTotalCost(){
		return stream()
			.mapToInt(cost -> cost.CalculateCost())
			.sum();
	}
}
