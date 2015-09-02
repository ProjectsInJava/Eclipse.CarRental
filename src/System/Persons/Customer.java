package System.Persons;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.google.gson.Gson;

// TODO: Auto-generated Javadoc
/**
 * The Class Customer.
 */
public class Customer extends CarOwner implements IO {

	/**
	 * Instantiates a new customer.
	 */
	public Customer() {
		super();
	}

	/**
	 * Instantiates a new customer.
	 *
	 * @param aName
	 *            the a name
	 * @param aID
	 *            the a id
	 */
	public Customer(String aName, String aID) {
		super(aName, aID);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see System.Persons.IO#GetFolder()
	 */
	@Override
	public String GetFolder() {
		return "Customers";
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
				super.init(newGsonReader.fromJson(line, this.getClass()));
		} catch (final IOException e) {
			return false;
		}

		return true;
	}
}
