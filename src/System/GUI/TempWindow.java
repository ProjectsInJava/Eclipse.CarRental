package System.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;

// TODO: Auto-generated Javadoc
/**
 * The Class TempWindow.
 */
public class TempWindow {

	/** The frame. */
	private JFrame frame;

	/**
	 * Create the application.
	 */
	public TempWindow() {
		initialize();
	}

	/**
	 * Launch the application.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				final TempWindow window = new TempWindow();
				window.frame.setVisible(true);
			} catch (final Exception e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * Gets the frame.
	 *
	 * @return the j frame
	 */
	public JFrame GetFrame() {
		return frame;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
