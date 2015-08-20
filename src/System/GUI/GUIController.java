package System.GUI;

import javax.swing.JLabel;
import javax.swing.JList;

import System.Hardware.CPU;
import System.Managers.CarRental;
import System.Persons.Employer;

public class GUIController {
	
	public static void UpdateEmptyCarList(JList<Object> aJList) {
		aJList.setListData(Employer.Instance.GetCars().toArray());
	}
	
	public static void UpdateNewTransactions(JList<Object> aJList) {	
		aJList.setListData(CarRental.Instance.GetQueueWaiting().toArray());
	}

	public static void UpdateClock(JLabel lblClockValue) {
		lblClockValue.setText(String.valueOf(CPU.Instance.GetClock().getEpochSecond()));
	}

	public static void UpdateCurrentTransactions(JList<Object> aJList) {
		aJList.setListData(CPU.Instance.toArray());
	}
}
