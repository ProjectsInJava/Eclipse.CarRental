package System.Persons;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.google.gson.Gson;

// TODO: Auto-generated Javadoc
/**
 * The Class Employer.
 */
public class Employer extends CarOwner implements IO {

	/** The Constant Instance. */
	public static final Employer Instance = new Employer();

	/** The _earnings. */
	private Integer _earnings;

	/**
	 * Instantiates a new employer.
	 */
	private Employer() {
		super();
		_earnings = 0;
	}

	/**
	 * Adds the earnings.
	 *
	 * @param getTotalCost
	 *            the get total cost
	 */
	public void addEarnings(Integer getTotalCost) {
		_earnings += getTotalCost;
	}

	/**
	 * Gets the earnings.
	 *
	 * @return the integer
	 */
	public Integer GetEarnings() {
		return _earnings;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see System.Persons.IO#GetFolder()
	 */
	@Override
	public String GetFolder() {
		return "Employers";
	}

	/**
	 * Load earnings.
	 *
	 * @return true, if successful
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public boolean LoadEarnings() throws IOException {

		final Gson newGsonReader = new Gson();

		try {
			final List<String> lines = Files.readAllLines(
					Paths.get(GetFolder() + "\\" + "Earnings" + "_" + "Earnings" + ".txt"), Charset.defaultCharset());

			for (final String line : lines)
				SetEarnings(newGsonReader.fromJson(line, Integer.class));
		} catch (final IOException e) {
			return false;
		}

		return true;
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
			final List<String> lines = Files.readAllLines(Paths.get(GetFolder() + "\\___.txt"),
					Charset.defaultCharset());

			for (final String line : lines)
				init(newGsonReader.fromJson(line, this.getClass()));
		} catch (final IOException e) {
			return false;
		}

		return true;
	}

	/**
	 * Reset earnings.
	 */
	public void ResetEarnings() {
		_earnings = 0;
	}

	/**
	 * Save earnings.
	 *
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void SaveEarnings() throws IOException {

		final Gson newGsonWriter = new Gson();
		final String stringFileinJSON = newGsonWriter.toJson(_earnings);
		final String path = GetFolder() + "\\" + "Earnings" + "_" + "Earnings" + ".txt";
		Files.write(Paths.get(path), stringFileinJSON.getBytes());
	}

	/**
	 * Sets the earnings.
	 *
	 * @param aEarnings
	 *            the a earnings
	 */
	public void SetEarnings(Integer aEarnings) {
		_earnings = aEarnings;
	}
}
