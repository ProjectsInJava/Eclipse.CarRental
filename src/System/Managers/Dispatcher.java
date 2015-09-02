package System.Managers;

import java.util.List;
import java.util.stream.Collectors;

import System.Collections.Specialize.TransactionQueue;
import System.Hardware.CPU;
import System.Managers.Ellementaries.Car;
import System.Managers.Ellementaries.Transaction;
import System.Managers.Enums.TransactionState;
import System.Persons.Employer;

// TODO: Auto-generated Javadoc
/**
 * The Class Dispatcher.
 */
public class Dispatcher extends Manager {
	// region **********************************************************
	// MEMBERS_AND_CTOR ********

	/** The Instance. */
	public static Dispatcher Instance = new Dispatcher();

	/** The _employer. */
	private final Employer _employer = Employer.Instance;

	/** The _error transactions. */
	private final TransactionQueue _errorTransactions;

	/** The _temp trans. */
	private Transaction _tempTrans;

	/**
	 * Instantiates a new dispatcher.
	 */
	private Dispatcher() {
		_tempTrans = new Transaction();
		_errorTransactions = new TransactionQueue();
	}

	// endregion
	// region **********************************************************
	// MAIN_LOOP ***************

	/*
	 * (non-Javadoc)
	 * 
	 * @see System.Managers.Manager#cleanup()
	 */
	@Override
	protected Object cleanup() {
		CarRental._queueReady.addAll(_errorTransactions);
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see System.Managers.Manager#init(java.lang.Integer)
	 */
	@Override
	protected void init(Integer aValue) {
		_errorTransactions.clear();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see System.Managers.Manager#work()
	 */
	@Override
	protected void work() {

		_tempTrans = CarRental._queueReady.dequeue();
		carDispatcher(_tempTrans);

		if (_tempTrans.GetState() == TransactionState.CAR)
			_errorTransactions.enqueue(_tempTrans);
		else
			dispatcherAllocatesThemToCPU(_tempTrans);
	}

	// endregion
	// region **********************************************************
	// OTHER_METHODS ***********

	/**
	 * Car dispatcher.
	 *
	 * @param aTransaction
	 *            the a transaction
	 */
	private void carDispatcher(Transaction aTransaction) {

		final List<Car> _readyCars = Employer.Instance.GetCars().stream()
				.filter(car -> car.GetBrand().equals(aTransaction.GetCar().GetBrand()))
				.filter(car -> car.GetModel().equals(aTransaction.GetCar().GetModel())).collect(Collectors.toList());

		if (!_readyCars.isEmpty()) {

			aTransaction.GetCustomer().addCar(_readyCars.get(0));
			Employer.Instance.GetCars().remove(0);

			aTransaction.Ready();
		} else
			aTransaction.Car();
	}

	/**
	 * Dispatcher allocates them to cpu.
	 *
	 * @param aTransaction
	 *            the a transaction
	 */
	private void dispatcherAllocatesThemToCPU(Transaction aTransaction) {
		CPU.Instance.add(aTransaction);
	}

	// endregion
}
