package System.Managers;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.Gson;

import System.Algorithms.Scheduling.FCFSAlgo;
import System.Algorithms.Scheduling.SchedAlgo;
import System.Collections.Specialize.TransactionQueue;
import System.Hardware.CPU;
import System.Managers.Ellementaries.Car;
import System.Managers.Ellementaries.Transaction;
import System.Managers.Enums.TransactionState;
import System.Persons.Employer;
import System.Persons.IO;

// TODO: Auto-generated Javadoc
/**
 * The Class CarRental.
 */
public class CarRental extends Manager implements IO {

	/** The _if dispatcher not run. */
	static boolean _ifDispatcherNotRun;

	/** The _queue ready. */
	public static TransactionQueue _queueReady;

	/** The _queue waiting. */
	// region **********************************************************
	// MEMBERS_AND_CTOR ********
	public static TransactionQueue _queueWaiting;

	/** The _sched algo. */
	public static SchedAlgo _schedAlgo;

	/** The Instance. */
	public static CarRental Instance = new CarRental();

	/** The _queue finished. */
	MetricsCalculator _queueFinished;

	/** The _temp employer. */
	Employer _tempEmployer;

	/**
	 * Instantiates a new car rental.
	 */
	private CarRental() {
		CarRental._queueWaiting = new TransactionQueue();
		CarRental._queueReady = new TransactionQueue();

		_cpu = CPU.Instance;
		_tempEmployer = Employer.Instance;

		_queueFinished = new MetricsCalculator();
	}

	// endregion
	// region **********************************************************
	// MAIN_LOOP ***************

	/**
	 * Adds the transaction.
	 *
	 * @param aTransaction
	 *            the a transaction
	 */
	public void addTransaction(Transaction aTransaction) {
		CarRental._queueWaiting.add(aTransaction);
	}

	/**
	 * Gets the finished transactions.
	 *
	 * @return the metrics calculator
	 */
	public MetricsCalculator GetFinishedTransactions() {
		return _queueFinished;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see System.Persons.IO#GetFolder()
	 */
	@Override
	public String GetFolder() {
		return "CarRental";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see System.Persons.IO#GetID()
	 */
	@Override
	public String GetID() {
		return "0";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see System.Persons.IO#GetName()
	 */
	@Override
	public String GetName() {
		return "CarRental;";
	}

	/**
	 * Gets the queue ready.
	 *
	 * @return the transaction queue
	 */
	public TransactionQueue GetQueueReady() {
		return CarRental._queueReady;
	}

	/**
	 * Gets the queue waiting.
	 *
	 * @return the transaction queue
	 */
	public TransactionQueue GetQueueWaiting() {
		return CarRental._queueWaiting;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see System.Persons.IO#LoadState()
	 */
	@Override
	public boolean LoadState() throws IOException {

		final Gson newGsonReader = new Gson();

		try {
			final List<String> lines = Files.readAllLines(
					Paths.get(GetFolder() + "\\" + GetName() + "_" + GetID() + ".txt"), Charset.defaultCharset());

			for (final String line : lines)
				readFromFile(newGsonReader.fromJson(line, this.getClass()));
		} catch (final IOException e) {
			return false;
		}

		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see System.Managers.Manager#cleanup()
	 */
	@Override
	protected Object cleanup() {

		_tempEmployer.addEarnings(_queueFinished.GetTotalCost());
		_queueFinished.clear();

		return _tempEmployer.GetEarnings();
	}
	// endregion
	// region **********************************************************
	// OTHER_METHODS ***********

	/*
	 * (non-Javadoc)
	 * 
	 * @see System.Managers.Manager#init(java.lang.Integer)
	 */
	@Override
	protected void init(Integer aValue) {

		CarRental._queueReady.clear();
		CarRental._schedAlgo = FCFSAlgo.Instance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see System.Managers.Manager#work()
	 */
	@Override
	protected void work() {
		Scheduler.Perform();
		Dispatcher.Instance.Run(CarRental._queueReady.size());

		timeEllapse();
		updateStatesIfAnyProcessFinished();
		final List<Transaction> _finishedTransactions = releaseFinishedTransactionsAndSendThemToCalculator();
		releaseCars(_finishedTransactions);
		releaseFinishedTransactionsAndSendThemToCalculator();
	}

	/**
	 * Read from file.
	 *
	 * @param aRental
	 *            the a rental
	 */
	private void readFromFile(CarRental aRental) {
		_queueFinished = aRental.GetFinishedTransactions();
		CarRental._queueReady = aRental.GetQueueReady();
		CarRental._queueWaiting = aRental.GetQueueWaiting();
	}

	/**
	 * Release cars.
	 *
	 * @param aFinishedTransactions
	 *            the a finished transactions
	 */
	private void releaseCars(List<Transaction> aFinishedTransactions) {

		final List<Car> _releasedCars = aFinishedTransactions.stream()
				.filter(core -> core.GetState().equals(TransactionState.END)).map(transaction -> transaction.GetCar())
				.collect(Collectors.toList());

		Employer.Instance.addCars(_releasedCars);
	}

	/**
	 * Release finished transactions and send them to calculator.
	 *
	 * @return the list
	 */
	private List<Transaction> releaseFinishedTransactionsAndSendThemToCalculator() {

		final List<Transaction> _finishedTransactions = CPU.Instance.stream()
				.filter(core -> core.GetState().equals(TransactionState.END)).collect(Collectors.toList());

		_finishedTransactions.stream().forEach(process -> sendToCalculator(process));

		CPU.Instance.removeAll(_finishedTransactions);

		return _finishedTransactions;
	}

	/**
	 * Send to calculator.
	 *
	 * @param aFinished
	 *            the a finished
	 */
	private void sendToCalculator(Transaction aFinished) {
		_queueFinished.add(new Transaction(aFinished));
	}

	/**
	 * Time ellapse.
	 */
	private void timeEllapse() {
		_cpu.Tick();
	}

	/**
	 * Update states if any process finished.
	 */
	private void updateStatesIfAnyProcessFinished() {
		CPU.Instance.stream().forEach(core -> core.handleStateChange());
	}

	// endregion
}