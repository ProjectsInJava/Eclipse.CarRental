package System.Collections.Specialize;

import java.util.LinkedList;

import System.Managers.Ellementaries.Transaction;

@SuppressWarnings("serial")
public  class TransactionQueue extends LinkedList<Transaction>
{
	protected String _name;

	public TransactionQueue(){
		super();
	}

	public TransactionQueue(TransactionQueue _readyQueue) {
		addAll(_readyQueue);
	}

	public boolean enqueue(Transaction aTransaction){
		return offer(aTransaction);		
	}

	public Transaction dequeue(){							
		return poll();		
	}
}