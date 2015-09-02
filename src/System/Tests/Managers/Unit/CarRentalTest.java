package System.Tests.Managers.Unit;

import java.io.IOException;
import java.time.Instant;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import System.Hardware.CPU;
import System.Managers.CarRental;
import System.Managers.Ellementaries.Car;
import System.Managers.Ellementaries.Transaction;
import System.Persons.Customer;
import System.Persons.Employer;

// TODO: Auto-generated Javadoc
/**
 * The Class CarRentalTest.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CarRentalTest {

	/** The _rental. */
	CarRental _rental;

	/** The _ret val. */
	Integer _retVal;

	/** The _temp car1. */
	Car _tempCar1 = new Car("Volvo", "XC90", 50);

	/** The _temp car2. */
	Car _tempCar2 = new Car("Volvo", "XC60", 40);

	/** The _temp car3. */
	Car _tempCar3 = new Car("Volvo", "XC40", 30);

	/** The _temp customer. */
	Customer _tempCustomer;

	/** The _temp employer. */
	Employer _tempEmployer = Employer.Instance;

	/** The _temp transaction. */
	Transaction _tempTransaction;

	/**
	 * Sets the up before class.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * Sets the up.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Before
	public void setUp() throws Exception {
		_rental = CarRental.Instance;

		_tempCustomer = new Customer("Pawel", "AWE294510");

		final LinkedList<Car> _cars = new LinkedList<>();
		_cars.add(_tempCar1);
		_cars.add(_tempCar2);
		_cars.add(_tempCar3);

		_tempEmployer.addCars(_cars);
	}

	/**
	 * Test earnings t10 but5 day was end.
	 */
	@Test
	public void testEarningsT10But5DayWasEnd() {

		_tempEmployer.ResetCars();
		_tempEmployer.addCar(_tempCar1);
		_rental.addTransaction(new Transaction(Instant.ofEpochSecond(0), "5", _tempCar1, _tempCustomer));

		_retVal = (Integer) _rental.Run(10);

		Assert.assertEquals(_tempEmployer.GetCars().size(), 1);
		reset();
	}

	/**
	 * Test earnings to5 day.
	 */
	@Test
	public void testEarningsTo5Day() {

		_rental.addTransaction(new Transaction(Instant.ofEpochSecond(0), "3", _tempCar1, _tempCustomer));
		_rental.addTransaction(new Transaction(Instant.ofEpochSecond(0), "2", _tempCar2, _tempCustomer));
		_rental.addTransaction(new Transaction(Instant.ofEpochSecond(0), "9", _tempCar3, _tempCustomer));

		_retVal = (Integer) _rental.Run(5);

		Assert.assertEquals(_retVal.intValue(), 230);
		reset();
	}

	/**
	 * Test earnings to9 day.
	 */
	@Test
	public void testEarningsTo9Day() {

		_rental.addTransaction(new Transaction(Instant.ofEpochSecond(0), "3", _tempCar1, _tempCustomer));
		_rental.addTransaction(new Transaction(Instant.ofEpochSecond(0), "2", _tempCar2, _tempCustomer));
		_rental.addTransaction(new Transaction(Instant.ofEpochSecond(0), "9", _tempCar3, _tempCustomer));

		_retVal = (Integer) _rental.Run(9);

		Assert.assertEquals(_retVal.intValue(), 500);
		reset();
	}

	/**
	 * Test run for9 seconds.
	 */
	@Test
	public void testRunFor9Seconds() {

		_rental.addTransaction(new Transaction(Instant.ofEpochSecond(0), "3", _tempCar1, _tempCustomer));
		_rental.addTransaction(new Transaction(Instant.ofEpochSecond(0), "2", _tempCar2, _tempCustomer));
		_rental.addTransaction(new Transaction(Instant.ofEpochSecond(0), "9", _tempCar3, _tempCustomer));

		_retVal = (Integer) _rental.Run(5);
		Assert.assertTrue(CPU.Instance.GetClock().equals(Instant.ofEpochSecond(5)));
		reset();
	}

	/**
	 * Test save state.
	 *
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Test
	public void testSaveState() throws IOException {

		_rental.addTransaction(new Transaction(Instant.ofEpochSecond(0), "3", _tempCar1, _tempCustomer));
		_rental.addTransaction(new Transaction(Instant.ofEpochSecond(0), "2", _tempCar2, _tempCustomer));
		_rental.addTransaction(new Transaction(Instant.ofEpochSecond(0), "9", _tempCar3, _tempCustomer));

		_rental.SaveState();

		Assert.assertTrue(true);
		reset();
	}

	/**
	 * Test waiting transaction for car.
	 */
	@Test
	public void testWaitingTransactionForCar() {

		_tempEmployer.ResetCars();
		_tempEmployer.addCar(_tempCar1);

		final Transaction _tempTransaction = new Transaction(Instant.ofEpochSecond(0), "3", _tempCar1, _tempCustomer);

		_rental.addTransaction(_tempTransaction);
		_rental.addTransaction(_tempTransaction);

		_retVal = (Integer) _rental.Run(3);

		Assert.assertTrue(_rental.GetQueueReady().contains(_tempTransaction));
		reset();
	}

	/**
	 * Reset.
	 */
	private void reset() {
		CPU.Instance.ClockReset();
		CPU.Instance.clear();
		Employer.Instance.ResetEarnings();
	}
}
