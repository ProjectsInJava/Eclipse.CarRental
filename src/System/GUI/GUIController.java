package System.GUI;

import javax.swing.JLabel;
import javax.swing.JList;

import System.Hardware.CPU;
import System.Managers.CarRental;
import System.Persons.Employer;

// TODO: Auto-generated Javadoc
/**
 * The Class GUIController.
 */
public class GUIController {

	/**
	 * Update clock.
	 *
	 * @param lblClockValue
	 *            the lbl clock value
	 */
	public static void UpdateClock(JLabel lblClockValue) {
		lblClockValue.setText(String.valueOf(CPU.Instance.GetClock().getEpochSecond()));
	}

	/**
	 * Update current transactions.
	 *
	 * @param aJList
	 *            the a j list
	 */
	public static void UpdateCurrentTransactions(JList<Object> aJList) {
		aJList.setListData(CPU.Instance.toArray());
	}

	/**
	 * Update empty car list.
	 *
	 * @param aJList
	 *            the a j list
	 */
	public static void UpdateEmptyCarList(JList<Object> aJList) {
		aJList.setListData(Employer.Instance.GetCars().toArray());
	}

	/**
	 * Update new transactions.
	 *
	 * @param aJList
	 *            the a j list
	 */
	public static void UpdateNewTransactions(JList<Object> aJList) {
		aJList.setListData(CarRental.Instance.GetQueueWaiting().toArray());
	}
}
