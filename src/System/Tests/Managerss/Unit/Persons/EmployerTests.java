package System.Tests.Managerss.Unit.Persons;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import System.Managers.Ellementaries.Car;
import System.Persons.Employer;

// TODO: Auto-generated Javadoc
/**
 * The Class EmployerTests.
 */
public class EmployerTests {

	/** The _employer. */
	Employer _employer = Employer.Instance;

	/** The _temp car. */
	Car _tempCar = new Car("Volvo", "XC90", 50);

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
	}

	/**
	 * Test add new car.
	 */
	@Test
	public void testAddNewCar() {
		_employer.addCar(_tempCar);
		Assert.assertTrue(_employer.GetCars().contains(_tempCar));
	}

	/**
	 * Test add two the same cars.
	 */
	@Test
	public void testAddTwoTheSameCars() {
		_employer.ResetCars();
		_employer.addCar(_tempCar);
		_employer.addCar(_tempCar);

		Assert.assertEquals(_employer.GetCars().size(), 2);
	}

	/**
	 * Test load state.
	 *
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Test
	public void testLoadState() throws IOException {
		_employer.SaveState();
		Assert.assertTrue(_employer.LoadState());
	}

	/**
	 * Test save state.
	 *
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Test
	public void testSaveState() throws IOException {
		_employer.SaveState();
		System.out.println("true");
	}
}
