package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Student_table")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int sid;
	
	@Column(length = 20)
	private String name;
	
	@Column(length = 20, name = "roll_no")
    private String rollNo;
	
	@Column(length = 20)
	private String dob;

	@Column(length = 20)	private String section;

	@Column(length = 20)
	private String gender;
	
	@Column(length = 20)
	private String stream;
	
	@ManyToOne
    @JoinColumn(name = "user_id")
    private Teacher teacher;
	
	// Default constructor
	public Student() {
	}

	public Student(int sid, String name, String roll_no, String section, String gender, String stream, String dob,Teacher teacher) {
		super();
		this.sid = sid;
		this.name = name;
		this.rollNo = roll_no;
		this.section = section;
		this.gender = gender;
		this.stream = stream;
		this.dob = dob;
		this.teacher=teacher;
	}
	
	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}
		
	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", name=" + name + ", rollNo=" + rollNo + ", section=" + section + ", gender="
				+ gender + ", stream=" + stream + ", dob=" + dob + ", teacher= " +teacher+"]";
	}
}
