package com.cisc181.core;

import java.util.UUID;

import com.cisc181.eNums.eMajor;

public class Course {

	private UUID CourseID;
	private String CourseName;
	private int GradePoints;
	private eMajor Major;
	
	public Course() {
	}
	
	public Course(String courseName, int gradePoints, eMajor major) {
		this.CourseName = courseName;
		this.GradePoints = gradePoints;
		this.Major = major;
	}
	
	public eMajor getMajor() {
		return Major;
	}
	public void setMajor(eMajor major) {
		Major = major;
	}
	public UUID getCourseID() {
		return CourseID;
	}
	public void setCourseID(UUID courseID) {
		CourseID = courseID;
	}
	public String getCourseName() {
		return CourseName;
	}
	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
	public int getGradePoints() {
		return GradePoints;
	}
	public void setGradePoints(int gradePoints) {
		GradePoints = gradePoints;
	}
	
	
}
