package com.google.bean;

public class EmployeeBean {
	private int id;
	private String name;
	private String email;
	private int experience;
	private int number;
	private String resumeurl;
	
	
	@Override
	public String toString() {
		return "EmployeeBean [id=" + id + ", name=" + name + ", email=" + email + ", experience=" + experience
				+ ", number=" + number + ", resumeurl=" + resumeurl + "]";
	}
	public EmployeeBean() {
		super();
	}
	public EmployeeBean(int id, String name, String email, int experience, int number, String resumeurl) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.experience = experience;
		this.number = number;
		this.resumeurl = resumeurl;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getResumeurl() {
		return resumeurl;
	}
	public void setResumeurl(String resumeurl) {
		this.resumeurl = resumeurl;
	}
	
}
