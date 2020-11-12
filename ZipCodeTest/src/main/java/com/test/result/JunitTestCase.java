package com.test.result;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;
import junit.framework.TestCase;

public class JunitTestCase extends TestCase {
	List<ZipCodeDTO> codeDTOs = null;

	protected void setUp() {
		String zipCodeValues = "[94133,94133] [94200,94299] [94226,94399] ";
		ZipCodeConverter zipCodeConverter = new ZipCodeConverter(zipCodeValues);

		System.out.println("Values" + zipCodeConverter.sortByLowerLimit(zipCodeConverter.stripZipcode()));
		codeDTOs = zipCodeConverter.mergeZipcodes(zipCodeConverter.sortByLowerLimit(zipCodeConverter.stripZipcode()));
		System.out.println("Your Result is-");
		for (ZipCodeDTO codeDTO : codeDTOs) {
			System.out.println("[" + codeDTO.getLowerLimit() + "," + codeDTO.getUpperLimit() + "]");
		}
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testSalutationMessage() {
		List<ZipCodeDTO> codeDTOs1 = new ArrayList<ZipCodeDTO>();
		ZipCodeDTO zipCodeDTO=new ZipCodeDTO(94133,94133);
		codeDTOs1.add(zipCodeDTO);
		ZipCodeDTO zipCodeDTO1=new ZipCodeDTO(94200,94399);
		codeDTOs1.add(zipCodeDTO1);
		Assert.assertEquals(codeDTOs, codeDTOs1);

	}

}
