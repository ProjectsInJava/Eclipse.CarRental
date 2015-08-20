package System.Persons;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.gson.Gson;

public interface IO {
	public default void SaveState() throws IOException{
		
		Gson newGsonWriter = new Gson();
		String stringFileinJSON = newGsonWriter.toJson(this);
		String path = GetFolder()+"\\"+GetName()+"_"+GetID()+".txt";
		Files.write(Paths.get(path), stringFileinJSON.getBytes());		
	}
	
	public boolean LoadState() throws IOException;
	public abstract String GetFolder();
	public abstract String GetName();
	public abstract String GetID();
}
