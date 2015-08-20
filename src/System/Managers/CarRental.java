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

public class CarRental extends Manager implements IO{
// region ********************************************************** MEMBERS_AND_CTOR ********
	public static TransactionQueue _queueWaiting;
	public static TransactionQueue _queueReady;
		
	public static SchedAlgo _schedAlgo;
	
	Employer _tempEmployer;
	public static CarRental Instance = new CarRental();
	
	MetricsCalculator _queueFinished;
	
	static boolean _ifDispatcherNotRun;
	
	private CarRental() {	
		_queueWaiting = new TransactionQueue();
		_queueReady = new TransactionQueue();
		
		_cpu = CPU.Instance;
		_tempEmployer = Employer.Instance;
				
		_queueFinished = new MetricsCalculator();	
	}
	
// endregion	
// region ********************************************************** MAIN_LOOP ***************
	
	@Override
	protected void init(Integer aValue) {	

		_queueReady.clear();
		_schedAlgo = FCFSAlgo.Instance;	
	}

	@Override
	protected void work() {			
		Scheduler.Perform();
		Dispatcher.Instance.Run(_queueReady.size());
		
		timeEllapse();		
		updateStatesIfAnyProcessFinished();	
		List<Transaction> _finishedTransactions = releaseFinishedTransactionsAndSendThemToCalculator();
		releaseCars(_finishedTransactions);
		releaseFinishedTransactionsAndSendThemToCalculator();			
	}

	@Override
	protected Object cleanup() {
		
		_tempEmployer.addEarnings(_queueFinished.GetTotalCost());
		_queueFinished.clear();
		
		return _tempEmployer.GetEarnings();
	}
//endregion
// region ********************************************************** OTHER_METHODS ***********
	
	public void addTransaction(Transaction aTransaction) {	
		_queueWaiting.add(aTransaction);
	}
		
	private void timeEllapse(){			
		_cpu.Tick();
	}
	
	private void updateStatesIfAnyProcessFinished() {	
		CPU.Instance.stream()
		.forEach(core -> core.handleStateChange() );
	}
	
	private List<Transaction> releaseFinishedTransactionsAndSendThemToCalculator() {	

		List<Transaction> _finishedTransactions = CPU.Instance.stream()
				.filter(core -> core.GetState().equals(TransactionState.END))
				.collect(Collectors.toList());
		
		_finishedTransactions.stream()
			.forEach(process -> sendToCalculator(process));
			
		CPU.Instance.removeAll(_finishedTransactions);
		
		return _finishedTransactions;
	}

	private void releaseCars(List<Transaction> aFinishedTransactions) {
		
		List<Car> _releasedCars = aFinishedTransactions.stream()
				.filter(core -> core.GetState().equals(TransactionState.END))
				.map(transaction -> transaction.GetCar())
				.collect(Collectors.toList());
		
		Employer.Instance.addCars(_releasedCars);
	}

	private void sendToCalculator(Transaction aFinished) {
		_queueFinished.add(new Transaction(aFinished));				
	}

	public TransactionQueue GetQueueReady() {
		return _queueReady;
	}
	
	public TransactionQueue GetQueueWaiting() {
		return _queueWaiting;
	}
	
	public MetricsCalculator GetFinishedTransactions() {
		return _queueFinished;
	}

	@Override
	public String GetFolder() {
		return "CarRental";
	}

	@Override
	public String GetName() {
		return "CarRental;";
	}

	@Override
	public String GetID() {
		return "0";
	}

	public boolean LoadState() throws IOException{

		Gson newGsonReader = new Gson();
		
		try
		{
			List<String> lines = Files.readAllLines(Paths.get(GetFolder()+"\\"+GetName()+"_"+GetID()+".txt"), Charset.defaultCharset());
		
		for (String line : lines) {
			readFromFile(newGsonReader.fromJson(line, this.getClass()));
			}	
		}
		catch(IOException e)
		{
			return false;
		}
		
		return true;
	}
	
	private void readFromFile(CarRental aRental){
		_queueFinished = aRental.GetFinishedTransactions();
		_queueReady = aRental.GetQueueReady();
		_queueWaiting = aRental.GetQueueWaiting();
	}
	
//endregion
}