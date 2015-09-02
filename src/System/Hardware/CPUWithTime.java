package System.Hardware;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import System.Managers.Ellementaries.Transaction;

// TODO: Auto-generated Javadoc
/**
 * The Class CPUWithTime.
 */
@SuppressWarnings("serial")
public class CPUWithTime extends ArrayList<Transaction> {

	/** The _cpu clock. */
	private Instant _cpuClock;

	/**
	 * Instantiates a new CPU with time.
	 */
	protected CPUWithTime() {
		_cpuClock = Instant.ofEpochSecond(0);
	}

	/**
	 * Clock reset.
	 *
	 * @return the instant
	 */
	public Instant ClockReset() {
		return _cpuClock = Instant.ofEpochSecond(0);
	}
	// endregion
	// region ***************************************** Working_With_States
	// ****************************************

	/**
	 * Clock tick.
	 */
	public void ClockTick() {
		_cpuClock = _cpuClock.plusSeconds(1);
	}

	/**
	 * Gets the clock.
	 *
	 * @return the instant
	 */
	public Instant GetClock() {
		return _cpuClock;
	}

	/**
	 * Load clock state.
	 *
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void LoadClockState() throws IOException {

		final Gson newGsonReader = new Gson();

		try {
			final List<String> lines = Files.readAllLines(Paths.get("Clock\\Clock.txt"), Charset.defaultCharset());

			for (final String line : lines)
				_cpuClock = newGsonReader.fromJson(line, Instant.class);
		} catch (final IOException e) {

		}
	}

	/**
	 * Save clock state.
	 *
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void SaveClockState() throws IOException {

		final Gson newGsonWriter = new Gson();
		final String stringFileinJSON = newGsonWriter.toJson(_cpuClock);
		final String path = "Clock" + "\\" + "Clock" + ".txt";
		Files.write(Paths.get(path), stringFileinJSON.getBytes());
	}

	/**
	 * Tick.
	 */
	// region ***************************************** Working_With_Time
	// ****************************************
	public void Tick() {
		_cpuClock = _cpuClock.plusSeconds(1);

		stream().forEach(trans -> trans.Perform());
	}

	/**
	 * Inits the.
	 *
	 * @param fromJson
	 *            the from json
	 */
	protected void init(Instant fromJson) {
		_cpuClock = fromJson;
	}

	// endregion
}
