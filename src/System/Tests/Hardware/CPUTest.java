package System.Tests.Hardware;

import static org.junit.Assert.*;

import java.io.IOException;
import java.time.Instant;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import System.Hardware.CPU;
import System.Managers.Ellementaries.Car;
import System.Managers.Ellementaries.Transaction;
import System.Persons.Customer;

public class CPUTest {

	CPU _tempCPU = CPU.Instance;
	Customer _customer;
	Car _tempCar = new Car("Volvo","XC90",90);
	Transaction _transaction;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		_transaction = new Transaction(Instant.ofEpochSecond(0),"3",_tempCar,_customer);
		_customer = new Customer("Pawel","AWE294510");
	}
	
	@Test
	public void testSaveClockState() throws IOException {
		CPU.Instance.ClockTick();
		CPU.Instance.ClockTick();
		
		CPU.Instance.SaveClockState();

		assertEquals(CPU.Instance.GetClock(),Instant.ofEpochSecond(2));
	}
	
	@Test
	public void testLoadState() throws IOException {
		CPU.Instance.LoadClockState();

		assertEquals(CPU.Instance.GetClock(),Instant.ofEpochSecond(2));
	}
	
	
	@Test
	public void testAddTransactions() {
		CPU.Instance.add(_transaction);
		CPU.Instance.add(_transaction);
		CPU.Instance.add(_transaction);
		
		assertEquals(CPU.Instance.size(),3);
		assertTrue(CPU.Instance.contains(_transaction));
	}

	@Test
	public void testGetFolder() {
		assertEquals(_tempCPU.GetFolder(),"CPU");
	}

	@Test
	public void testGetName() {
		assertEquals(_tempCPU.GetFolder(),"CPU");
	}

	@Test
	public void testGetID() {
		assertEquals(_tempCPU.GetFolder(),"CPU");
	}

}
