package System.Managers.Ellementaries;

import java.time.Instant;

public class TransactionWithCar extends TransactionWithTime {
	private Car _car;
	
// region ******************************** CTORS ********************************	
	protected TransactionWithCar() {
		
		super();
		_car = new Car();
	}
	
	protected TransactionWithCar(Instant aTimeShift ,String aDuration,Car aCar){
		super(aTimeShift,aDuration);
		_car = aCar;
	}
// endregion
// region ******************************** Property_access_methods **************
	public Car GetCar(){
		return _car;
	}
	
	public void SetCar(Car aCar){
		_car = aCar;
	}
// endregion
}
