package System.Tests.Hardware;

import java.io.IOException;
import java.time.Instant;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import System.Hardware.CPU;
import System.Managers.Ellementaries.Car;
import System.Managers.Ellementaries.Transaction;
import System.Persons.Customer;

// TODO: Auto-generated Javadoc
/**
 * The Class CPUTest.
 */
public class CPUTest {

	/** The _customer. */
	Customer _customer;

	/** The _temp car. */
	Car _tempCar = new Car("Volvo", "XC90", 90);

	/** The _temp cpu. */
	CPU _tempCPU = CPU.Instance;

	/** The _transaction. */
	Transaction _transaction;

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
		_transaction = new Transaction(Instant.ofEpochSecond(0), "3", _tempCar, _customer);
		_customer = new Customer("Pawel", "AWE294510");
	}

	/**
	 * Test add transactions.
	 */
	@Test
	public void testAddTransactions() {
		CPU.Instance.add(_transaction);
		CPU.Instance.add(_transaction);
		CPU.Instance.add(_transaction);

		Assert.assertEquals(CPU.Instance.size(), 3);
		Assert.assertTrue(CPU.Instance.contains(_transaction));
	}

	/**
	 * Test get folder.
	 */
	@Test
	public void testGetFolder() {
		Assert.assertEquals(_tempCPU.GetFolder(), "CPU");
	}

	/**
	 * Test get id.
	 */
	@Test
	public void testGetID() {
		Assert.assertEquals(_tempCPU.GetFolder(), "CPU");
	}

	/**
	 * Test get name.
	 */
	@Test
	public void testGetName() {
		Assert.assertEquals(_tempCPU.GetFolder(), "CPU");
	}

	/**
	 * Test load state.
	 *
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Test
	public void testLoadState() throws IOException {
		CPU.Instance.LoadClockState();

		Assert.assertEquals(CPU.Instance.GetClock(), Instant.ofEpochSecond(2));
	}

	/**
	 * Test save clock state.
	 *
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Test
	public void testSaveClockState() throws IOException {
		CPU.Instance.ClockTick();
		CPU.Instance.ClockTick();

		CPU.Instance.SaveClockState();

		Assert.assertEquals(CPU.Instance.GetClock(), Instant.ofEpochSecond(2));
	}

}
