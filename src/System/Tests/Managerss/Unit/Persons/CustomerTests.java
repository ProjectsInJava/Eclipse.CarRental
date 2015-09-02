package System.Tests.Managerss.Unit.Persons;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import System.Managers.Ellementaries.Car;
import System.Persons.Customer;

// TODO: Auto-generated Javadoc
/**
 * The Class CustomerTests.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerTests {

	/** The _customer. */
	Customer _customer;

	/** The _temp car. */
	Car _tempCar = new Car("Volvo", "XC90", 90);

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
		_customer = new Customer("Pawel", "AWE294510");
	}

	/**
	 * Test add new car.
	 */
	@Test
	public void testAddNewCar() {
		_customer.addCar(_tempCar);
		Assert.assertTrue(_customer.GetCars().contains(_tempCar));
	}

	/**
	 * Test load state.
	 *
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Test
	public void testLoadState() throws IOException {
		_customer.addCar(_tempCar);
		_customer.SaveState();

		Assert.assertTrue(_customer.LoadState());
	}

	/**
	 * Test save state.
	 *
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Test
	public void testSaveState() throws IOException {
		_customer.addCar(_tempCar);
		_customer.SaveState();
	}
}
