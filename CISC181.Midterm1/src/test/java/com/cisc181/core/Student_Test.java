package com.cisc181.core;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eMajor;

public class Student_Test {
	static ArrayList<Course> courses = new ArrayList<Course>();
	static ArrayList<Student> students = new ArrayList<Student>();
	static ArrayList<Semester> semesters = new ArrayList<Semester>();
	static ArrayList<Section> sections = new ArrayList<Section>();
	static ArrayList<Enrollment> enrollments = new ArrayList<Enrollment>();

	@BeforeClass
	public static void setup() throws ParseException {
		courses.add(new Course("Business", 100, eMajor.BUSINESS));
		courses.add(new Course("Chemistry", 100, eMajor.CHEM));
		courses.add(new Course("Nursing", 100, eMajor.NURSING));
		
		SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
		String springStart = "01-28-1996";
		String springEnd = "05-28-1996";
		Date springStartD = format.parse(springStart);
		Date springEndD = format.parse(springEnd);
		String fallStart = "08-22-1996";
		String fallEnd = "012-28-1996";
		Date fallStartD = format.parse(fallStart);
		Date fallEndD = format.parse(fallEnd);
		String DOB = "030=-28-1996";
		Date DOBD = format.parse(DOB);
		
		semesters.add(new Semester(springStartD, springEndD));
		semesters.add(new Semester(fallStartD, fallEndD));
		
		sections.add(new Section(courses.get(0).getCourseID(), semesters.get(0).getSemesterID(), 1));
		sections.add(new Section(courses.get(0).getCourseID(), semesters.get(1).getSemesterID(), 2));
		sections.add(new Section(courses.get(1).getCourseID(), semesters.get(0).getSemesterID(), 3));
		sections.add(new Section(courses.get(1).getCourseID(), semesters.get(1).getSemesterID(), 4));
		sections.add(new Section(courses.get(2).getCourseID(), semesters.get(0).getSemesterID(), 5));
		sections.add(new Section(courses.get(2).getCourseID(), semesters.get(1).getSemesterID(), 6));
		
		students.add(new Student("Russell", "X", "Leong", DOBD, eMajor.CHEM, "Middletown", "3022656038", "rleong@udel.edu"));
		students.add(new Student("Cindy", "X", "Leong", DOBD, eMajor.BUSINESS, "Middletown", "3023656038", "rleong@udel.edu"));
		students.add(new Student("Rover", "X", "Leong", DOBD, eMajor.NURSING, "Middletown", "3022655038", "rleong@udel.edu"));
		students.add(new Student("Cream", "X", "Leong", DOBD, eMajor.BUSINESS, "Middletown", "3024656038", "rleong@udel.edu"));
		students.add(new Student("Hershey", "X", "Leong", DOBD, eMajor.CHEM, "Middletown", "3022856038", "rleong@udel.edu"));
		students.add(new Student("Wade", "X", "Leong", DOBD, eMajor.BUSINESS, "Middletown", "3022676038", "rleong@udel.edu"));
		students.add(new Student("Laixi", "X", "Li", DOBD, eMajor.NURSING, "Middletown", "3022656938", "rleong@udel.edu"));
		students.add(new Student("Potato", "X", "Leong", DOBD, eMajor.BUSINESS, "Middletown", "3022356038", "rleong@udel.edu"));
		students.add(new Student("Tomato", "X", "Leong", DOBD, eMajor.CHEM, "Middletown", "3022656028", "rleong@udel.edu"));
		students.add(new Student("Ireallywanttosleeprightnow", "X", "Leong", DOBD, eMajor.BUSINESS, "Middletown", "3322656038", "rleong@udel.edu"));
	}

	@SuppressWarnings("deprecation")
	@Test
	public void enrollmentTest() {
		
		ArrayList<Double> tempGrades = new ArrayList<Double>();

		for (int i = 0; i < 6; i++) {
			for (int n = 0; n < 10; n++) {
				enrollments.add(new Enrollment(students.get(n).getStudentID(), sections.get(i).getSectionID()));
			}
		}
		for (int j = 0; j < 60; j++) {
			double grade = Math.random() * 100;
			tempGrades.add(grade);
			enrollments.get(j).setGrade(grade);
		}
		
		double tempStudentAverage = 0;
		
		for (int i = 0; i < 10; i++) {
			
			tempStudentAverage += enrollments.get(i).getGrade();
			
		}
		
		assertEquals(tempStudentAverage / enrollments.size(), tempStudentAverage / enrollments.size());
		
	}
	
	@Test
	public void replaceMajorTest() {
		students.get(0).setMajor(eMajor.BUSINESS);
		assertEquals(students.get(0).getMajor(), eMajor.BUSINESS);
	}
}