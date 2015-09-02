package System.Managers.Ellementaries;

// TODO: Auto-generated Javadoc
/**
 * The Class Car.
 */
public class Car {
	// region ******************************* MEMBERS
	// ***************************************

	/** The _brand. */
	private String _brand;

	/** The _cost per day. */
	private Integer _costPerDay;

	/** The _model. */
	private String _model;

	// endregion
	// region ******************************* CTORS
	// *****************************************

	/**
	 * Instantiates a new car.
	 */
	public Car() {

		_brand = "";
		_model = "";
		_costPerDay = 0;
	}

	/**
	 * Instantiates a new car.
	 *
	 * @param aCar
	 *            the a car
	 */
	public Car(Car aCar) {
		_model = aCar.GetModel();
		_brand = aCar.GetBrand();
		_costPerDay = aCar.GetCostPerDay();
	}

	/**
	 * Instantiates a new car.
	 *
	 * @param aBrand
	 *            the a brand
	 * @param aModel
	 *            the a model
	 * @param aCostPerDay
	 *            the a cost per day
	 */
	public Car(String aBrand, String aModel, Integer aCostPerDay) {
		_brand = aBrand;
		_model = aModel;
		_costPerDay = aCostPerDay;
	}

	// endregion
	// region ******************************* PROPERTY_ACCESS_METHODS
	// ***********************

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Car other = (Car) obj;
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

	/**
	 * Gets the brand.
	 *
	 * @return the string
	 */
	public String GetBrand() {
		return _brand;
	}

	/**
	 * Gets the cost per day.
	 *
	 * @return the integer
	 */
	public Integer GetCostPerDay() {
		return _costPerDay;
	}

	/**
	 * Gets the model.
	 *
	 * @return the string
	 */
	public String GetModel() {
		return _model;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_brand == null) ? 0 : _brand.hashCode());
		result = prime * result + ((_model == null) ? 0 : _model.hashCode());
		return result;
	}

	/**
	 * Sets the brand.
	 *
	 * @param aBrand
	 *            the a brand
	 */
	public void SetBrand(String aBrand) {
		_brand = aBrand;
	}

	// region ******************************* STANDARD_METHODS
	// *****************************

	/**
	 * Sets the cost per day.
	 *
	 * @param aCost
	 *            the a cost
	 */
	public void SetCostPerDay(Integer aCost) {
		_costPerDay = aCost;
	}

	/**
	 * Sets the model.
	 *
	 * @param aModel
	 *            the a model
	 */
	public void SetModel(String aModel) {
		_model = aModel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[Brand: " + _brand + ", Model: " + _model + ", PricePerDay: " + _costPerDay + "]";
	}

	// endregion

}
