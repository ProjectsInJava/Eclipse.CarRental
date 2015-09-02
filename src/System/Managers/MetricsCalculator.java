package System.Managers;

import java.util.LinkedList;

import System.Managers.Ellementaries.Transaction;

// TODO: Auto-generated Javadoc
/**
 * The Class MetricsCalculator.
 */
@SuppressWarnings("serial")
public class MetricsCalculator extends LinkedList<Transaction> {

	/**
	 * Gets the total cost.
	 *
	 * @return the integer
	 */
	public Integer GetTotalCost() {
		return stream().mapToInt(cost -> cost.CalculateCost()).sum();
	}
}
