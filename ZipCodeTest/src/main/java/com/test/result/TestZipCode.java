package com.test.result;

import java.util.List;
import java.util.Scanner;

public class TestZipCode {
	private static Scanner scan;

	public static void main(String[] args) {
		try {
			scan = new Scanner(System.in);
			String zipCodeValues = scan.nextLine();
			ZipCodeConverter zipCodeConverter = new ZipCodeConverter(zipCodeValues);

			System.out.println("Values" + zipCodeConverter.sortByLowerLimit(zipCodeConverter.stripZipcode()));
			List<ZipCodeDTO> codeDTOs = zipCodeConverter
					.mergeZipcodes(zipCodeConverter.sortByLowerLimit(zipCodeConverter.stripZipcode()));
			System.out.println("Your Result is-");
			for (ZipCodeDTO codeDTO : codeDTOs) {
				System.out.println("[" + codeDTO.getLowerLimit() + "," + codeDTO.getUpperLimit() + "]");
			}
		} catch (Exception e) {
			System.out.print("Exception occured" + e.getMessage());
		}
	}
}