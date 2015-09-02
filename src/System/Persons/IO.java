package System.Persons;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.gson.Gson;

// TODO: Auto-generated Javadoc
/**
 * The Interface IO.
 */
public interface IO {

	/**
	 * Gets the folder.
	 *
	 * @return the string
	 */
	public abstract String GetFolder();

	/**
	 * Gets the id.
	 *
	 * @return the string
	 */
	public abstract String GetID();

	/**
	 * Gets the name.
	 *
	 * @return the string
	 */
	public abstract String GetName();

	/**
	 * Load state.
	 *
	 * @return true, if successful
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public boolean LoadState() throws IOException;

	/**
	 * Save state.
	 *
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public default void SaveState() throws IOException {

		final Gson newGsonWriter = new Gson();
		final String stringFileinJSON = newGsonWriter.toJson(this);
		final String path = GetFolder() + "\\" + GetName() + "_" + GetID() + ".txt";
		Files.write(Paths.get(path), stringFileinJSON.getBytes());
	}
}
