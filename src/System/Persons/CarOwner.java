package System.Persons;

import java.util.LinkedList;
import java.util.List;

import System.Managers.Ellementaries.Car;

// TODO: Auto-generated Javadoc
/**
 * The Class CarOwner.
 */
public abstract class CarOwner extends Person {

	/** The _cars. */
	private LinkedList<Car> _cars;

	/**
	 * Instantiates a new car owner.
	 */
	public CarOwner() {
		super();
		_cars = new LinkedList<Car>();
	}

	/**
	 * Instantiates a new car owner.
	 *
	 * @param aCustomer
	 *            the a customer
	 */
	public CarOwner(CarOwner aCustomer) {
		super();
		init(aCustomer);
	}

	/**
	 * Instantiates a new car owner.
	 *
	 * @param aName
	 *            the a name
	 * @param aID
	 *            the a id
	 */
	public CarOwner(String aName, String aID) {
		super(aName, aID);
		_cars = new LinkedList<Car>();
	}

	/**
	 * Adds the car.
	 *
	 * @param aCar
	 *            the a car
	 */
	public void addCar(Car aCar) {
		_cars.add(aCar);
	}

	/**
	 * Adds the cars.
	 *
	 * @param aCars
	 *            the a cars
	 */
	public void addCars(List<Car> aCars) {
		_cars.addAll(aCars);
	}

	/**
	 * Gets the cars.
	 *
	 * @return the linked list
	 */
	public LinkedList<Car> GetCars() {
		return _cars;
	}

	/**
	 * Reset cars.
	 */
	public void ResetCars() {
		_cars.clear();
	}

	/**
	 * Inits the.
	 *
	 * @param aCustomer
	 *            the a customer
	 */
	protected void init(CarOwner aCustomer) {
		_cars = aCustomer.GetCars();
	}
}
