package System.Persons;

import java.util.LinkedList;
import java.util.List;

import System.Managers.Ellementaries.Car;

public abstract class CarOwner extends Person{
	
	private LinkedList<Car> _cars;
	
	public CarOwner(){
		super();
		_cars = new LinkedList<Car>();
	}
	
	public CarOwner(CarOwner aCustomer){
		super();
		init(aCustomer);
	}
	
	public CarOwner(String aName,String aID){
		super(aName,aID);
		_cars = new LinkedList<Car>();
	}
	
	public void addCar(Car aCar) {
		_cars.add(aCar);
	}
	
	public void addCars(List<Car> aCars) {
		_cars.addAll(aCars);
	}

	public LinkedList<Car> GetCars() {
		return _cars;
	}
	
	public void ResetCars() {
		_cars.clear();
	}
	
	protected void init(CarOwner aCustomer){
		_cars = aCustomer.GetCars();
	}
}
