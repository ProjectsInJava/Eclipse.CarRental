package System.Persons;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.google.gson.Gson;

public class Customer extends CarOwner implements IO{
	
	public Customer(){
		super();
	}

	public Customer(String aName, String aID) {
		super(aName,aID);
	}
	
	public boolean LoadState() throws IOException{
		Gson newGsonReader = new Gson();
		
		try{
		List<String> lines = Files.readAllLines(Paths.get(GetFolder()+"\\"+GetName()+"_"+GetID()+".txt"), Charset.defaultCharset());
		
		for (String line : lines) {
			super.init(newGsonReader.fromJson(line, this.getClass()));
		}	
		}catch(IOException e){
			return false;
		}
		
		return true;
	}

	@Override
	public String GetFolder() {
		return "Customers";
	}
}
