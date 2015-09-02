package System.Tests.Managers.Ellementaries;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import System.Managers.Ellementaries.Car;

// TODO: Auto-generated Javadoc
/**
 * The Class CarTest.
 */
public class CarTest {

	/** The _temp car. */
	Car _tempCar;

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
		_tempCar = new Car();
	}

	/**
	 * Test equals.
	 */
	@Test
	public void testEquals() {
		final Car _tempCar1 = new Car("Volvo", "XC90", 60);
		final Car _tempCar2 = new Car("Volvo", "XC90", 50);

		Assert.assertEquals(_tempCar1.hashCode(), _tempCar2.hashCode());
	}

	/**
	 * Test set brand.
	 */
	@Test
	public void testSetBrand() {
		_tempCar.SetBrand("Volvo");
		Assert.assertEquals(_tempCar.GetBrand(), "Volvo");
	}

	/**
	 * Test set cost per day.
	 */
	@Test
	public void testSetCostPerDay() {
		_tempCar.SetCostPerDay(30);
		Assert.assertEquals(_tempCar.GetCostPerDay().intValue(), 30);
	}

	/**
	 * Test set model.
	 */
	@Test
	public void testSetModel() {
		_tempCar.SetModel("XC90");
		Assert.assertEquals(_tempCar.GetModel(), "XC90");
	}
}
