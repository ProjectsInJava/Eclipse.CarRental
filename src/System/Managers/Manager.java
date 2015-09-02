package System.Managers;

import System.Hardware.CPU;

// TODO: Auto-generated Javadoc
/**
 * The Class Manager.
 */
public abstract class Manager {

	/** The _cpu. */
	public CPU _cpu = CPU.Instance;

	/**
	 * Run.
	 *
	 * @param aValue
	 *            the a value
	 * @return the object
	 */
	public Object Run(Integer aValue) {
		init(aValue);
		for (int i = 0; i < aValue; i++)
			work();
		return cleanup();
	}

	/**
	 * Cleanup.
	 *
	 * @return the object
	 */
	protected abstract Object cleanup();

	/**
	 * Inits the.
	 *
	 * @param aValue
	 *            the a value
	 */
	protected abstract void init(Integer aValue);

	/**
	 * Work.
	 */
	protected abstract void work();
}