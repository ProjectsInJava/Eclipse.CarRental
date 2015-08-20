package System.Tests.Managers.Ellementaries;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import System.Managers.Ellementaries.Car;

public class CarTest {

	Car _tempCar;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		_tempCar = new Car();
	}

	@Test
	public void testSetModel() {
		_tempCar.SetModel("XC90");
		assertEquals(_tempCar.GetModel(),"XC90");
	}

	@Test
	public void testSetBrand() {
		_tempCar.SetBrand("Volvo");
		assertEquals(_tempCar.GetBrand(),"Volvo");
	}

	@Test
	public void testSetCostPerDay() {
		_tempCar.SetCostPerDay(30);
		assertEquals(_tempCar.GetCostPerDay().intValue(),30);
	}

	@Test
	public void testEquals() {
		Car _tempCar1 = new Car("Volvo","XC90",60);
		Car _tempCar2 = new Car("Volvo","XC90",50);
		
		assertEquals(_tempCar1.hashCode(),_tempCar2.hashCode());
	}
}
