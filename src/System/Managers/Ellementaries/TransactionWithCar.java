package System.Managers.Ellementaries;

import java.time.Instant;

// TODO: Auto-generated Javadoc
/**
 * The Class TransactionWithCar.
 */
public class TransactionWithCar extends TransactionWithTime {

	/** The _car. */
	private Car _car;

	/**
	 * Instantiates a new transaction with car.
	 */
	// region ******************************** CTORS
	// ********************************
	protected TransactionWithCar() {

		super();
		_car = new Car();
	}

	/**
	 * Instantiates a new transaction with car.
	 *
	 * @param aTimeShift
	 *            the a time shift
	 * @param aDuration
	 *            the a duration
	 * @param aCar
	 *            the a car
	 */
	protected TransactionWithCar(Instant aTimeShift, String aDuration, Car aCar) {
		super(aTimeShift, aDuration);
		_car = aCar;
	}

	// endregion
	/**
	 * Gets the car.
	 *
	 * @return the car
	 */
	// region ******************************** Property_access_methods
	// **************
	public Car GetCar() {
		return _car;
	}

	/**
	 * Sets the car.
	 *
	 * @param aCar
	 *            the a car
	 */
	public void SetCar(Car aCar) {
		_car = aCar;
	}
	// endregion
}
