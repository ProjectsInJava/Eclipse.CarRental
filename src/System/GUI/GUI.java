package System.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import System.Hardware.CPU;
import System.Managers.CarRental;
import System.Managers.Ellementaries.Car;
import System.Managers.Ellementaries.Transaction;
import System.Persons.Customer;
import System.Persons.Employer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.JScrollPane;
import javax.swing.JList;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class GUI {
// region ******************************* MEMBERS *********************************
	private JFrame frmCarrentalbt;
	private JTextField tBCustomerName;
	private JTextField tBCustomerID;
	private JTextField tBLengthOfRent;
	JSpinner nUDLoopSize = new JSpinner();
	JList<Object> listCurrentTransactionsEmployer = new JList<>();
	JList<Object> listEmptyCarsEmployer = new JList<>();
	JList<Object> listEmptyCarsCustomer = new JList<>();
	JList<Object> listNewTransactionsCustomer = new JList<>();
	JLabel lblClockValue = new JLabel("__");
	
	private CarRental _rental = CarRental.Instance;
	private CPU _tempCPU = CPU.Instance;
	private Employer _employer = Employer.Instance;
	
	private JTextField tBCarBrandEmployer;
	private JTextField tBCarModelEmployer;
	private JTextField tBCarPricePerDayEmployer;
	
// endregion
// region ******************************* Updating_Load_Saving_States_And_Views ***
	
	private void updateViews() {
		GUIController.UpdateEmptyCarList(listEmptyCarsCustomer);
		GUIController.UpdateEmptyCarList(listEmptyCarsEmployer);
		GUIController.UpdateClock(lblClockValue);
		GUIController.UpdateNewTransactions(listNewTransactionsCustomer);
		GUIController.UpdateCurrentTransactions(listCurrentTransactionsEmployer);
	}
	
	private void loadStates() throws IOException {
		Employer.Instance.LoadState();
		Employer.Instance.LoadEarnings();
		CPU.Instance.LoadState();
		CPU.Instance.LoadClockState();
		CarRental.Instance.LoadState();
	}
	
	private void saveStates() throws IOException {
		Employer.Instance.SaveState();
		Employer.Instance.SaveEarnings();
		CPU.Instance.SaveState();
		CPU.Instance.SaveClockState();
		CarRental.Instance.SaveState();
	}

// endregion	
// region ******************************* Auto_Generated_CTOR_Init ****************
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					TempWindow _tempWindows = new TempWindow();
					_tempWindows.GetFrame().setVisible(true);
					window.frmCarrentalbt.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCarrentalbt = new JFrame();
		frmCarrentalbt.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				
				try {
					loadStates();
								} catch (IOException e) {
					e.printStackTrace();
				}
				
				updateViews();
			}
// endregion		
// region ******************************* WindowClosing ***************************
			@Override
			public void windowClosing(WindowEvent e) {			

					try {
						saveStates();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
			}

		});
		
// endregion
// region ******************************* Auto_Generated **************************
	
		frmCarrentalbt.setTitle("CarRentalBT");

		frmCarrentalbt.setBounds(0, 0, 1024, 768);
		frmCarrentalbt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmCarrentalbt.getContentPane().add(panel, BorderLayout.CENTER);
		
		
		
// endregion
// region ******************************* Tab_Changing_Action *********************
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				
				updateViews();
			}
		});
		
//endregion
// region ******************************* Auto_Generated **************************
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Customer", null, panel_1, null);
		
		JLabel lblNewLabel = new JLabel("Customer Name");
		
		tBCustomerName = new JTextField();
		tBCustomerName.setColumns(10);
		
		JLabel lblCustomerId = new JLabel("Customer ID");
		
		tBCustomerID = new JTextField();
		tBCustomerID.setColumns(10);
		
		tBLengthOfRent = new JTextField();
		tBLengthOfRent.setColumns(10);
		
		JLabel lblLengthOfRent = new JLabel("Length Of Rent");
		
// endregion		
// region ******************************* Order_Button_Action *********************
	
		JButton btnOrder = new JButton("Order");
		btnOrder.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				Transaction _tempTransaction = new Transaction();
				Customer _tempCustomer = new Customer();
				
				_tempCustomer.SetName(tBCustomerName.getText());
				_tempCustomer.SetID(tBCustomerID.getText());
				
				Car _tempCar = new Car((Car) listEmptyCarsCustomer.getSelectedValue());
				
				_tempTransaction.SetBuyer(_tempCustomer);
				_tempTransaction.SetCar(_tempCar);
				_tempTransaction.SetTimeExecute(Long.parseLong(tBLengthOfRent.getText()));
				_tempTransaction.SetTimeShift(_tempCPU.GetClock());
				
				_rental.addTransaction(_tempTransaction);	
				
				updateViews();
			}
		});

// endregion
// region ******************************* Auto_Generated **************************
		JScrollPane scrollPane_2 = new JScrollPane();
		
		JLabel lblNewLabel_3 = new JLabel("AvailableCars");
		
		JLabel lblNewtransactions = new JLabel("NewTransactions");
		
		JScrollPane scrollPane_3 = new JScrollPane();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(tBCustomerName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCustomerId)
						.addComponent(tBCustomerID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLengthOfRent)
						.addComponent(tBLengthOfRent, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnOrder))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 339, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane_3, GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
						.addComponent(lblNewtransactions, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel)
							.addComponent(lblNewLabel_3))
						.addComponent(lblNewtransactions))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(tBCustomerName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblCustomerId)
							.addGap(6)
							.addComponent(tBCustomerID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblLengthOfRent)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(tBLengthOfRent, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnOrder))
						.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
							.addComponent(scrollPane_3, GroupLayout.PREFERRED_SIZE, 339, GroupLayout.PREFERRED_SIZE)
							.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(308, Short.MAX_VALUE))
		);
		

		scrollPane_3.setViewportView(listNewTransactionsCustomer);
		scrollPane_2.setViewportView(listEmptyCarsCustomer);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Employer", null, panel_2, null);
		
		JLabel lblNewLabel_1 = new JLabel("CarBrand");
		
		tBCarBrandEmployer = new JTextField();
		tBCarBrandEmployer.setColumns(10);
		
		JLabel lblCarmodel = new JLabel("CarModel");
		
		tBCarModelEmployer = new JTextField();
		tBCarModelEmployer.setColumns(10);
		
		JLabel lblCarpriceperday = new JLabel("CarPricePerDay");
		
		tBCarPricePerDayEmployer = new JTextField();
		tBCarPricePerDayEmployer.setColumns(10);
// endregion
// region ******************************* Add_Car_Button_Action *******************
	
		JButton btnAddCar = new JButton("AddCar");
		btnAddCar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Car _tempCar = new Car();
				_tempCar.SetBrand(tBCarBrandEmployer.getText());
				_tempCar.SetModel(tBCarModelEmployer.getText());
				_tempCar.SetCostPerDay(Integer.valueOf(tBCarPricePerDayEmployer.getText()));
				
				_employer.addCar(_tempCar);

				updateViews();
			}
		});
		
// endregion
// region ******************************* Auto_Generated **************************
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel_2 = new JLabel("AvailableCars");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JLabel lblCurrenttransactions = new JLabel("CurrentTransactions");
		
// endregion
// region ******************************* Recalculate_Button_Action ***************
		
		JButton btnNewButton = new JButton("RecalculateThrough");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				CarRental.Instance.Run((Integer) nUDLoopSize.getValue());

				updateViews();
				
				String result = "";
				result+=_employer.GetEarnings()+"\n";
				result+="Day:"+CPU.Instance.GetClock().getEpochSecond()+"\n";
				
				JOptionPane.showMessageDialog(frmCarrentalbt,result
					   );
			}
		});
// endregion	
// region ******************************* Auto_Generated **************************
		JLabel lblNewLabel_4 = new JLabel("Day");

		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel_1)
								.addComponent(tBCarBrandEmployer)
								.addComponent(tBCarModelEmployer)
								.addComponent(tBCarPricePerDayEmployer)
								.addComponent(btnAddCar)
								.addComponent(lblCarmodel, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCarpriceperday, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(27)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2))
							.addGap(18)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCurrenttransactions)))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(137)
							.addComponent(lblNewLabel_4)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblClockValue)
							.addGap(18)
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(nUDLoopSize, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(357, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_2)
						.addComponent(lblCurrenttransactions))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 411, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(tBCarBrandEmployer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblCarmodel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tBCarModelEmployer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblCarpriceperday)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tBCarPricePerDayEmployer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnAddCar))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 411, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(lblClockValue)
						.addComponent(btnNewButton)
						.addComponent(nUDLoopSize, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		nUDLoopSize.setModel(new SpinnerNumberModel(1, 0, 5000, 1));
		
		scrollPane_1.setViewportView(listCurrentTransactionsEmployer);
		scrollPane.setViewportView(listEmptyCarsEmployer);
		panel_2.setLayout(gl_panel_2);
		panel.setLayout(gl_panel);
	}
//endregion
}

