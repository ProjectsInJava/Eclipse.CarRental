package System.Persons;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.google.gson.Gson;

public class Employer extends CarOwner implements IO{

	public static final Employer Instance = new Employer();
	private Integer _earnings;

	private Employer(){
		super();
		_earnings = 0;
	}
	
	public boolean LoadState() throws IOException{

		Gson newGsonReader = new Gson();
		
		try
		{
		List<String> lines = Files.readAllLines(Paths.get(GetFolder()+"\\___.txt"), Charset.defaultCharset());
		
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
	
	public void SaveEarnings() throws IOException{
		
		Gson newGsonWriter = new Gson();
		String stringFileinJSON = newGsonWriter.toJson(_earnings);
		String path = GetFolder()+"\\"+"Earnings"+"_"+"Earnings"+".txt";
		Files.write(Paths.get(path), stringFileinJSON.getBytes());		
	}
	
	public boolean LoadEarnings() throws IOException{

		Gson newGsonReader = new Gson();
		
		try
		{
		List<String> lines = Files.readAllLines(Paths.get(GetFolder()+"\\"+"Earnings"+"_"+"Earnings"+".txt"), Charset.defaultCharset());
		
		for (String line : lines) {
			SetEarnings(newGsonReader.fromJson(line, Integer.class));
		}	
		}
		catch(IOException e)
		{
			return false;
		}
		
		return true;
	}

	@Override
	public String GetFolder() {
		return "Employers";
	}

	public void addEarnings(Integer getTotalCost) {
		_earnings+=getTotalCost;
	}

	public Integer GetEarnings() {
		return _earnings;
	}
	
	public void SetEarnings(Integer aEarnings) {
		_earnings = aEarnings;
	}
	
	public void ResetEarnings(){
		_earnings = 0;
	}
}
