package System.Hardware;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import System.Persons.IO;

@SuppressWarnings("serial")
public class CPUWithIO extends CPUWithTime implements IO
{
	public String toString(){
		String second = "";

		second = stream()
			     .map(i -> i.toString())
			     .collect(Collectors.joining(","));

		return "[Clock:"+GetClock().getEpochSecond()+",Cores:"+second+",CoresSize:"+ size()+ "]";
	}

	public boolean LoadState() throws IOException{

		Gson newGsonReader = new Gson();
		
		try
		{
		List<String> lines = Files.readAllLines(Paths.get(GetFolder()+"\\CPU_CPU.txt"), Charset.defaultCharset());
		
		for (String line : lines) {
			init(newGsonReader.fromJson(line, this.getClass()));
		}	
		}
		catch(IOException e)
		{
			return false;
		}
		
		return true;
	}
	

	private void init(CPUWithIO fromJson) {
		super.init(fromJson.GetClock());
		clear();
		addAll(fromJson);
	}

	@Override
	public String GetFolder() {
		return "CPU";
	}

	@Override
	public String GetName() {
		return "CPU";
	}

	@Override
	public String GetID() {
		return "CPU";
	}
}
