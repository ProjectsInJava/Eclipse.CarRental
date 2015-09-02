package System.Managers.Ellementaries;

import java.time.Instant;

import System.Persons.Customer;

// TODO: Auto-generated Javadoc
/**
 * The Class Transaction.
 */
public class Transaction extends TransactionWithCar {

	/** The Constant NULL. */
	public static final Transaction NULL = new Transaction();

	/** The _buyer. */
	private Customer _buyer;

	/**
	 * Instantiates a new transaction.
	 */
	public Transaction() {
		super();

		_buyer = new Customer();
	}

	/**
	 * Instantiates a new transaction.
	 *
	 * @param aClock
	 *            the a clock
	 * @param aDuration
	 *            the a duration
	 * @param aCar
	 *            the a car
	 * @param aBuyer
	 *            the a buyer
	 */
	public Transaction(Instant aClock, String aDuration, Car aCar, Customer aBuyer) {

		super(aClock, aDuration, aCar);

		_buyer = aBuyer;
	}

	/**
	 * Instantiates a new transaction.
	 *
	 * @param aTransaction
	 *            the a transaction
	 */
	public Transaction(Transaction aTransaction) {
		_buyer = aTransaction.GetCustomer();
		_state = aTransaction.GetState();
		SetCar(aTransaction.GetCar());
		SetTimeShift(aTransaction.GetTimeShift());
		SetTimeExecute(aTransaction.GetTimeExecute());
		SetTimeWaiting(aTransaction.GetTimeWaiting());
	}

	/**
	 * Calculate cost.
	 *
	 * @return the integer
	 */
	public Integer CalculateCost() {
		return (int) (GetTimeWaiting().getEpochSecond() * GetCar().GetCostPerDay());
	}

	/**
	 * Gets the customer.
	 *
	 * @return the customer
	 */
	public Customer GetCustomer() {
		return _buyer;
	}

	/**
	 * Perform.
	 */
	public void Perform() {
		DecreaseTimeExecute(1);
		IncreaseTimeWaiting(1);
	}

	/**
	 * Sets the buyer.
	 *
	 * @param aBuyer
	 *            the a buyer
	 */
	public void SetBuyer(Customer aBuyer) {
		_buyer = aBuyer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String _first = "";

		_first = "[TS:" + GetTimeShift().getEpochSecond() + ",TE:" + GetTimeExecute().getEpochSecond() + ",TW:"
				+ GetTimeWaiting().getEpochSecond() + ",ST:" + GetState() + ",Car:" + GetCar().toString() + "]";

		return _first;
	}
}
