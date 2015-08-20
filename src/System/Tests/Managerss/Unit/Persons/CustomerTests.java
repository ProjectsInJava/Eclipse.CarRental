package System.Tests.Managerss.Unit.Persons;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import System.Managers.Ellementaries.Car;
import System.Persons.Customer;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerTests {

	Customer _customer;
	Car _tempCar = new Car("Volvo","XC90",90);
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		_customer = new Customer("Pawel","AWE294510");
	}

	@Test
	public void testAddNewCar() {
		_customer.addCar(_tempCar);	
		assertTrue(_customer.GetCars().contains( _tempCar));	
	}
	
	@Test
	public void testSaveState() throws IOException {
		_customer.addCar(_tempCar);
		_customer.SaveState();
	}
	
	@Test
	public void testLoadState() throws IOException {
		_customer.addCar(_tempCar);
		_customer.SaveState();
		
		assertTrue(_customer.LoadState());
	}
}

