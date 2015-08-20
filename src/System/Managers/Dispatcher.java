package System.Managers;

import java.util.List;
import java.util.stream.Collectors;

import System.Collections.Specialize.TransactionQueue;
import System.Hardware.CPU;
import System.Managers.Ellementaries.Car;
import System.Managers.Ellementaries.Transaction;
import System.Managers.Enums.TransactionState;
import System.Persons.Employer;

public class Dispatcher extends Manager{
// region ********************************************************** MEMBERS_AND_CTOR ********
	
	public static Dispatcher Instance = new Dispatcher();
	private Transaction _tempTrans;
	private TransactionQueue _errorTransactions;
	private Employer _employer = Employer.Instance;

	private Dispatcher(){
		_tempTrans = new Transaction();
		_errorTransactions = new TransactionQueue();
	}
	
// endregion	
// region ********************************************************** MAIN_LOOP ***************
	
	@Override
	protected void init(Integer aValue) {
		_errorTransactions.clear();
	}

	@Override
	protected void work() {
		
		_tempTrans = CarRental._queueReady.dequeue();
		carDispatcher(_tempTrans);
		
		if(_tempTrans.GetState()==TransactionState.CAR)
		{
			_errorTransactions.enqueue(_tempTrans);
		}
		else
		{
			dispatcherAllocatesThemToCPU(_tempTrans);
		}
	}

	@Override
	protected Object cleanup() {
		CarRental._queueReady.addAll(_errorTransactions);
		return null;
	}

// endregion
// region ********************************************************** OTHER_METHODS ***********
	
	private void dispatcherAllocatesThemToCPU(Transaction aTransaction) {
		CPU.Instance.add(aTransaction);	
	}
	
	private void carDispatcher(Transaction aTransaction) {
		
		List<Car> _readyCars = Employer.Instance.GetCars().stream()
				.filter(car -> car.GetBrand().equals(aTransaction.GetCar().GetBrand()))
				.filter(car -> car.GetModel().equals(aTransaction.GetCar().GetModel()))
				.collect(Collectors.toList());
			
			if(!_readyCars.isEmpty()){
				
				aTransaction.GetCustomer().addCar(_readyCars.get(0));
				Employer.Instance.GetCars().remove(0);
				
				aTransaction.Ready();
			}
			else{
				aTransaction.Car();
			}
	}	
	
// endregion
}
