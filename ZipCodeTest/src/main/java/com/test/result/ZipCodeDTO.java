package com.test.result;

/**
 * @author anuroshr
 * This is the DTO class for zipCode.
 *
 */
public class ZipCodeDTO {

	private int lowerLimit;
	private int upperLimit;
	
	public ZipCodeDTO(int lowerLimit, int upperLimit) {
		super();
		this.lowerLimit = lowerLimit;
		this.upperLimit = upperLimit;
	}

	/**
	 * @return the lowerLimit
	 */
	public int getLowerLimit() {
		return lowerLimit;
	}

	/**
	 * @param lowerLimit the lowerLimit to set
	 */
	public void setLowerLimit(int lowerLimit) {
		this.lowerLimit = lowerLimit;
	}

	/**
	 * @return the upperLimit
	 */
	public int getUpperLimit() {
		return upperLimit;
	}

	/**
	 * @param upperLimit the upperLimit to set
	 */
	public void setUpperLimit(int upperLimit) {
		this.upperLimit = upperLimit;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + lowerLimit;
		result = prime * result + upperLimit;
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
		ZipCodeDTO other = (ZipCodeDTO) obj;
		if (lowerLimit != other.lowerLimit)
			return false;
		if (upperLimit != other.upperLimit)
			return false;
		return true;
	}

	

	

	
	
	

	

}
