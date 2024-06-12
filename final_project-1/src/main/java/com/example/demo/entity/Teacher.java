package com.example.demo.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Teacher_table")
public class Teacher {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int tid;
	
	@Column(length = 20, nullable = true)
	private String tname;
	
	@Column(length = 20, nullable = true)
	private String phoneNo;
 	
	@Column(length = 20, nullable = true)
	private String gender;
	
	@Column(nullable = true)
	private int salary;
	
	@OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Student> students;
	
	@ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

	// Default constructor
	public Teacher() {
	}

	public Teacher(int tid, String tname, String phoneNo, String gender, int salary, Set<Student> students,
			Admin admin) {
		super();
		this.tid = tid;
		this.tname = tname;
		this.phoneNo = phoneNo;
		this.gender = gender;
		this.salary = salary;
		this.students = students;
		this.admin = admin;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}


	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Teacher [tid=" + tid + ", tname=" + tname + ", phoneNo=" + phoneNo + ", gender=" + gender + ", salary="
				+ salary + ", students=" + students + ", admin=" + admin + "]";
	}

	
}
