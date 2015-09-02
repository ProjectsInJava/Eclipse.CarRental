package System.Hardware;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.Gson;

import System.Persons.IO;

// TODO: Auto-generated Javadoc
/**
 * The Class CPUWithIO.
 */
@SuppressWarnings("serial")
public class CPUWithIO extends CPUWithTime implements IO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see System.Persons.IO#GetFolder()
	 */
	@Override
	public String GetFolder() {
		return "CPU";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see System.Persons.IO#GetID()
	 */
	@Override
	public String GetID() {
		return "CPU";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see System.Persons.IO#GetName()
	 */
	@Override
	public String GetName() {
		return "CPU";
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
			final List<String> lines = Files.readAllLines(Paths.get(GetFolder() + "\\CPU_CPU.txt"),
					Charset.defaultCharset());

			for (final String line : lines)
				init(newGsonReader.fromJson(line, this.getClass()));
		} catch (final IOException e) {
			return false;
		}

		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.AbstractCollection#toString()
	 */
	@Override
	public String toString() {
		String second = "";

		second = stream().map(i -> i.toString()).collect(Collectors.joining(","));

		return "[Clock:" + GetClock().getEpochSecond() + ",Cores:" + second + ",CoresSize:" + size() + "]";
	}

	/**
	 * Inits the.
	 *
	 * @param fromJson
	 *            the from json
	 */
	private void init(CPUWithIO fromJson) {
		super.init(fromJson.GetClock());
		clear();
		addAll(fromJson);
	}
}
