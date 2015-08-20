package System.Tests.Managerss.Unit.Persons;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import System.Managers.Ellementaries.Car;
import System.Persons.Employer;

public class EmployerTests {

	Employer _employer = Employer.Instance;
	Car _tempCar = new Car("Volvo","XC90",50);
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      

	@Test
	public void testAddNewCar() {	
		_employer.addCar(_tempCar);	
		assertTrue(_employer.GetCars().contains(_tempCar));	
	}
	

	@Test
	public void testAddTwoTheSameCars() {
		_employer.ResetCars();
		_employer.addCar(_tempCar);
		_employer.addCar(_tempCar);
		
		assertEquals(_employer.GetCars().size(),2);	
	}
	
	@Test
	public void testSaveState() throws IOException{
		_employer.SaveState();	
		System.out.println("true");
	}
	
	@Test
	public void testLoadState() throws IOException{	
		_employer.SaveState();
		assertTrue(_employer.LoadState());
	}
}
