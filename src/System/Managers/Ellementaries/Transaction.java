package System.Managers.Ellementaries;

import java.time.Instant;

import System.Persons.Customer;

public class Transaction extends TransactionWithCar{
	
	public static final Transaction NULL = new Transaction();
	
	private Customer _buyer;
	
	public Transaction() {
		super();
		
		_buyer = new Customer();
	}
	
	public Transaction(Transaction aTransaction ) {
		_buyer = aTransaction.GetCustomer();
		_state = aTransaction.GetState();
		SetCar(aTransaction.GetCar());
		SetTimeShift(aTransaction.GetTimeShift());
		SetTimeExecute(aTransaction.GetTimeExecute());
		SetTimeWaiting(aTransaction.GetTimeWaiting());
	}
	
	public Transaction(Instant aClock,  String aDuration, Car aCar , Customer aBuyer) {
		
		super(aClock,aDuration,aCar);	
		
		_buyer = aBuyer;		
	}
	
	public void SetBuyer(Customer aBuyer){
		_buyer = aBuyer;
	}

	public Customer GetCustomer() {
		return _buyer;
	}
	
	public void Perform() {
		DecreaseTimeExecute(1); 
		IncreaseTimeWaiting(1);
	}
	
	public Integer CalculateCost(){
		return (int) (GetTimeWaiting().getEpochSecond()*GetCar().GetCostPerDay());
	}
	public String toString(){
		String _first = "";
		
		_first="[TS:"+GetTimeShift().getEpochSecond()+",TE:"+GetTimeExecute().getEpochSecond()+",TW:"+GetTimeWaiting().getEpochSecond()+",ST:"+GetState()+",Car:"+GetCar().toString()+"]";
		
		return _first;
	}
}
