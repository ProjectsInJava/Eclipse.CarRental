package System.Collections.Specialize;

import java.util.LinkedList;

import System.Managers.Ellementaries.Transaction;

// TODO: Auto-generated Javadoc
/**
 * The Class TransactionQueue.
 */
@SuppressWarnings("serial")
public class TransactionQueue extends LinkedList<Transaction> {

	/** The _name. */
	protected String _name;

	/**
	 * Instantiates a new transaction queue.
	 */
	public TransactionQueue() {
		super();
	}

	/**
	 * Instantiates a new transaction queue.
	 *
	 * @param _readyQueue
	 *            the _ready queue
	 */
	public TransactionQueue(TransactionQueue _readyQueue) {
		addAll(_readyQueue);
	}

	/**
	 * Dequeue.
	 *
	 * @return the transaction
	 */
	public Transaction dequeue() {
		return poll();
	}

	/**
	 * Enqueue.
	 *
	 * @param aTransaction
	 *            the a transaction
	 * @return true, if successful
	 */
	public boolean enqueue(Transaction aTransaction) {
		return offer(aTransaction);
	}
}