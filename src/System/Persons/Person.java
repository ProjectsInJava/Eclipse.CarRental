package System.Persons;

public abstract class Person {

	private String _name;
	private String _id;
	
	public Person(){
		_name = "_";
		_id = "_";
	}

	public Person(String aName,String aID){
		_name = aName;
		_id = aID;
	}
	
	public void SetName(String aName){
		_name = aName;
	}
	
	public void SetID(String aID){
		_id = aID;
	}
	
	public String GetName(){
		return _name;
	}
	
	public String GetID(){
		return _id;
	}
	
	@Override
	public String toString() {
		return "Person [_name=" + _name + ", _id=" + _id + "]";
	}
}
