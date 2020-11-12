package com.test.result;

import java.util.Comparator;

/**
 * @author anuroshr
 *
 */
public class ZipCodeSorting implements Comparator<ZipCodeDTO> {

	/**
	 * This method is used to sorting the zipCode w.r.t lower limit.
	 */
	@Override
	public int compare(ZipCodeDTO zipCode1, ZipCodeDTO zipCode2) {

		if (zipCode1.getLowerLimit() > zipCode2.getLowerLimit())
			return 1;
		else
			return -1;

	}

}
