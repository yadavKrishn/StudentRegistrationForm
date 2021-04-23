package com.pack.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name="stu5000")
public class Student {
	@Id
	private Integer studentid;
	@NotEmpty
	@Size(min=6,max=25)
	private String name;
	@NotNull
	@Min(value=20)
	@Max(value=50)
	private Integer age;
	@NotEmpty()
	private String address;
	@NotEmpty()
	private String gender;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull()
	private  Date dob;
	@NotEmpty()
	@Email()
	private String email;
	public Integer getStudentid() {
		return studentid;
	}
	public void setStudentid(Integer studentid) {
		this.studentid = studentid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Student(Integer studentid, String name, Integer age, String address, String gender, Date dob, String email) {
		super();
		this.studentid = studentid;
		this.name = name;
		this.age = age;
		this.address = address;
		this.gender = gender;
		this.dob = dob;
		this.email = email;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
