package com.cisc181.core;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eTitle;

public class Staff_Test {

	static ArrayList<Staff> staffSample = new ArrayList<Staff>();
	
	@BeforeClass
	public static void setupBefore() throws ParseException {
		
		SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
		String DOBTest = "03-28-1996";
		Date DOB = format.parse(DOBTest);

		String HDTest = "03-22-2016";
		Date HD = format.parse(HDTest);
		
		staffSample.add(new Staff("Russell","X","Leong", DOB,
				"123 Dreamland Drive", "3022656038", "rleong@udel.edu",
				"0", 1, 20000, HD, eTitle.MR));
		staffSample.add(new Staff("Wade","X","Leong", DOB,
				"123 Dreamland Drive", "3022656028", "wleong@udel.edu",
				"0", 1, 25000, HD, eTitle.MR));
		staffSample.add(new Staff("Cindy","X","Leong", DOB,
				"123 Dreamland Drive", "3022356038", "cleong@udel.edu",
				"0", 1, 30000, HD, eTitle.MRS));
		staffSample.add(new Staff("Rover","X","Leong", DOB,
				"123 Dreamland Drive", "3022654038", "rleong@udel.edu",
				"0", 1, 28000, HD, eTitle.MR));
		staffSample.add(new Staff("Laixi","X","Li", DOB,
				"123 Dreamland Drive", "3022656538", "lli@udel.edu",
				"0", 1, 200000, HD, eTitle.MRS));
	}
	
	@AfterClass
	public static void setupAfter() throws Exception {
		
	}
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void salaryTest() {
		int averageSalary = 0;
		for(int i = 0; i < staffSample.size(); i++)
			averageSalary += staffSample.get(i).getSalary();
		averageSalary = averageSalary/staffSample.size();
		assertEquals(averageSalary, 60600);
	}	
	
	@Test(expected = PersonException.class)
	public void DOBTestExceptions() throws PersonException, ParseException{
		SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
		String DOBTest = "03-28-1896";
		Date DOB = format.parse(DOBTest);

		String HDTest = "03-22-2016";
		Date HD = format.parse(HDTest);
		
		staffSample.add(new Staff("Laixi","X","Li", DOB,
				"123 Dreamland Drive", "3022656038", "rleong@udel.edu",
				"0", 1, 200000, HD, eTitle.MRS));
	}
	
	@Test(expected = PersonException.class)
	public void phoneTestExceptions() throws PersonException, ParseException{
		SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
		String DOBTest = "03-28-1996";
		Date DOB = format.parse(DOBTest);

		String HDTest = "03-22-2016";
		Date HD = format.parse(HDTest);
		
		staffSample.add(new Staff("Laixi","X","Li", DOB,
				"123 Dreamland Drive", "30226560338", "rleong@udel.edu",
				"0", 1, 200000, HD, eTitle.MRS));
	}

}
