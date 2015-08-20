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

@SuppressWarnings("serial")
public class CPUWithTime extends ArrayList<Transaction>{

	private Instant _cpuClock;
	
	protected CPUWithTime(){
		_cpuClock = Instant.ofEpochSecond(0);
	}
	
// region ***************************************** Working_With_Time	****************************************
	public void Tick() {
		_cpuClock = _cpuClock.plusSeconds(1);

		stream().forEach(trans -> trans.Perform());
	}

	public Instant GetClock(){
		return _cpuClock;
	}

	public void ClockTick() {
		_cpuClock = _cpuClock.plusSeconds(1);
	}

	public Instant ClockReset(){
		return _cpuClock = Instant.ofEpochSecond(0);
	}
// endregion
// region ***************************************** Working_With_States ****************************************
	
	public void SaveClockState() throws IOException{
		
		Gson newGsonWriter = new Gson();
		String stringFileinJSON = newGsonWriter.toJson(_cpuClock);
		String path = "Clock"+"\\"+"Clock"+".txt";
		Files.write(Paths.get(path), stringFileinJSON.getBytes());		
	}
	
	public void LoadClockState() throws IOException{
		
		Gson newGsonReader = new Gson();
		
		try
		{
		List<String> lines = Files.readAllLines(Paths.get("Clock\\Clock.txt"), Charset.defaultCharset());
		
		for (String line : lines) {
			_cpuClock = newGsonReader.fromJson(line, Instant.class);
		}	
		}
		catch(IOException e)
		{
			
		}
	}

	protected void init(Instant fromJson) {
		_cpuClock = fromJson;
	}
	
// endregion
}
