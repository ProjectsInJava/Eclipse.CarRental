package System.Managers.Ellementaries;

public class Car {
// region ******************************* MEMBERS ***************************************

	private String _brand;
	private String _model;
	private Integer _costPerDay;
	
// endregion
// region ******************************* CTORS ***************************************** 
	
	public Car(){	
		_brand = "";
		_model = "";
		_costPerDay = 0;
	}
	
	public Car(String aBrand, String aModel ,Integer aCostPerDay){		
		_brand = aBrand;
		_model = aModel;
		_costPerDay = aCostPerDay;
	}
	
	public Car(Car aCar){	  
		_model = aCar.GetModel();
		_brand = aCar.GetBrand();
		_costPerDay = aCar.GetCostPerDay();		
	}
	
// endregion
// region ******************************* PROPERTY_ACCESS_METHODS ***********************
	
	public void SetModel(String aModel){
		 _model = aModel;
	}
	
	public void SetBrand(String aBrand){
		_brand = aBrand;
	}
	
	public String GetModel() {
		return _model;
	}
	
	public String GetBrand(){
		return _brand;
	}
	
	public Integer GetCostPerDay(){
		return _costPerDay;
	}
	
	public void SetCostPerDay(Integer aCost){
		_costPerDay = aCost;
	}
	
// region ******************************* STANDARD_METHODS *****************************
	
	public String toString(){
		return "[Brand: "+_brand+", Model: "+_model+", PricePerDay: "+_costPerDay+"]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_brand == null) ? 0 : _brand.hashCode());
		result = prime * result + ((_model == null) ? 0 : _model.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (_brand == null) {
			if (other._brand != null)
				return false;
		} else if (!_brand.equals(other._brand))
			return false;
		if (_model == null) {
			if (other._model != null)
				return false;
		} else if (!_model.equals(other._model))
			return false;
		return true;
	}


	

// endregion

}
