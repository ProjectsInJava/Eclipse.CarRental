package System.Tests.Managers.Unit;

import static org.junit.Assert.*;

import java.io.IOException;
import java.time.Instant;
import java.util.LinkedList;

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

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CarRentalTest {

	CarRental _rental;	
	Customer _tempCustomer;
	Employer _tempEmployer = Employer.Instance;
	
	Car _tempCar1 = new Car("Volvo","XC90",50);
	Car _tempCar2 = new Car("Volvo","XC60",40);
	Car _tempCar3 = new Car("Volvo","XC40",30);
	
	Integer _retVal;
	Transaction _tempTransaction;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		_rental = CarRental.Instance;
		
		_tempCustomer = new Customer("Pawel","AWE294510");
		
		LinkedList<Car> _cars = new LinkedList<>();
		_cars.add(_tempCar1);
		_cars.add(_tempCar2);
		_cars.add(_tempCar3);
		
		_tempEmployer.addCars(_cars);
	}

	@Test
	public void testEarningsTo9Day() {
		
		_rental.addTransaction(new Transaction(Instant.ofEpochSecond(0),"3",_tempCar1,_tempCustomer));
		_rental.addTransaction(new Transaction(Instant.ofEpochSecond(0),"2",_tempCar2,_tempCustomer));
		_rental.addTransaction(new Transaction(Instant.ofEpochSecond(0),"9",_tempCar3,_tempCustomer));
		
		_retVal = (Integer) _rental.Run(9);
		
		assertEquals(_retVal.intValue(),500);
		reset();		
	}
	
	@Test
	public void testEarningsT10But5DayWasEnd() {
		
		_tempEmployer.ResetCars();
		_tempEmployer.addCar(_tempCar1);
		_rental.addTransaction(new Transaction(Instant.ofEpochSecond(0),"5",_tempCar1,_tempCustomer));
		
		_retVal = (Integer) _rental.Run(10);
		
		assertEquals(_tempEmployer.GetCars().size(),1);
		reset();		
	}
	
	@Test
	public void testEarningsTo5Day() {
		
		_rental.addTransaction(new Transaction(Instant.ofEpochSecond(0),"3",_tempCar1,_tempCustomer));
		_rental.addTransaction(new Transaction(Instant.ofEpochSecond(0),"2",_tempCar2,_tempCustomer));
		_rental.addTransaction(new Transaction(Instant.ofEpochSecond(0),"9",_tempCar3,_tempCustomer));
		
		_retVal = (Integer) _rental.Run(5);
		
		assertEquals(_retVal.intValue(),230);
		reset();	
	}
	
	
	@Test
	public void testRunFor9Seconds() {
		
		_rental.addTransaction(new Transaction(Instant.ofEpochSecond(0),"3",_tempCar1,_tempCustomer));
		_rental.addTransaction(new Transaction(Instant.ofEpochSecond(0),"2",_tempCar2,_tempCustomer));
		_rental.addTransaction(new Transaction(Instant.ofEpochSecond(0),"9",_tempCar3,_tempCustomer));
		
		_retVal = (Integer) _rental.Run(5);
		assertTrue(CPU.Instance.GetClock().equals(Instant.ofEpochSecond(5)));
		reset();
	}	
	
	@Test
	public void testWaitingTransactionForCar() {
		
		_tempEmployer.ResetCars();
		_tempEmployer.addCar(_tempCar1);
		
		Transaction _tempTransaction = new Transaction(Instant.ofEpochSecond(0),"3",_tempCar1,_tempCustomer);
		
		_rental.addTransaction(_tempTransaction);
		_rental.addTransaction(_tempTransaction);
		
		_retVal = (Integer) _rental.Run(3);
		
		assertTrue(_rental.GetQueueReady().contains(_tempTransaction));
		reset();
	}
	
	@Test
	public void testSaveState() throws IOException {
		
		_rental.addTransaction(new Transaction(Instant.ofEpochSecond(0),"3",_tempCar1,_tempCustomer));
		_rental.addTransaction(new Transaction(Instant.ofEpochSecond(0),"2",_tempCar2,_tempCustomer));
		_rental.addTransaction(new Transaction(Instant.ofEpochSecond(0),"9",_tempCar3,_tempCustomer));
		
		_rental.SaveState();
		
		assertTrue(true);
		reset();
	}
	
	private void reset(){
		CPU.Instance.ClockReset();
		CPU.Instance.clear();
		Employer.Instance.ResetEarnings();
	}
}
