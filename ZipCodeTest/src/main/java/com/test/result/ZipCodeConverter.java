package com.test.result;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ZipCodeConverter {

	private String zipcodeRanges;

	/**
	 * This is the constructur.
	 * @param zipcodeRanges
	 */
	public ZipCodeConverter(String zipcodeRanges) {
		this.zipcodeRanges = zipcodeRanges;
	}

	public List<ZipCodeDTO> sortByLowerLimit(List<ZipCodeDTO> zipcodeRangeList) {
		Collections.sort(zipcodeRangeList, new ZipCodeSorting());
		return zipcodeRangeList;
	}

	/**
	 * This method is used to collect the all zip codes in array formate
	 * @return
	 */
	public List<ZipCodeDTO> stripZipcode() {
		String[] zipcodeIntervals = zipcodeRanges.split(" ");
		return loadZipcode(zipcodeIntervals);
	}

	/**
	 * This method is used to convert string array in to DTO object.
	 * @param zipcodeRange
	 * @return
	 */
	public List<ZipCodeDTO> loadZipcode(String[] zipcodeRange) {
		List<ZipCodeDTO> zipcodesList = new LinkedList<ZipCodeDTO>();
		for (int i = 0; i < zipcodeRange.length; i++) {
			System.out.println("value" + zipcodeRange[i]);
			String[] zipRange = zipcodeRange[i].replaceAll("\\[|\\]", "").split(",");
			int lowerBound = Integer.parseInt(zipRange[0]);
			int upperBound = Integer.parseInt(zipRange[1]);
			ZipCodeDTO codeDTO = new ZipCodeDTO(lowerBound, upperBound);
			zipcodesList.add(codeDTO);
		}
		return zipcodesList;
	}

	/**
	 * This method is used to re-arrange the zip code.
	 * @param sortedZipCodeList
	 * @return
	 */
	public List<ZipCodeDTO> mergeZipcodes(List<ZipCodeDTO> sortedZipCodeList) {
		List<ZipCodeDTO> mergedZipcodeList = new ArrayList<ZipCodeDTO>();
		ZipCodeDTO zipcode = null;
		for (ZipCodeDTO zipCodeDTO : sortedZipCodeList) {
			if (zipcode == null)
				zipcode = zipCodeDTO;
			else {
				if (zipcode.getUpperLimit() >= zipCodeDTO.getLowerLimit()) {
					zipcode.setUpperLimit(Math.max(zipcode.getUpperLimit(), zipCodeDTO.getUpperLimit()));
				} else {
					mergedZipcodeList.add(zipcode);
					zipcode = zipCodeDTO;
				}
			}
		}
		mergedZipcodeList.add(zipcode);
		return mergedZipcodeList;
	}

	public static void main(String[] args) {
	}

}
