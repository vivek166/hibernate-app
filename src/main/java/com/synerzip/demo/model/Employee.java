package com.synerzip.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="employee")
public class Employee {
	@Id
	@GenericGenerator(name = "custom_id", strategy = "com.synerzip.demo.model.EmployeeIdGenerator")
	@GeneratedValue(generator = "custom_id")
	@Column(name="eid")
	private String eid;
	
	@Column(name="name")
	private String name;
	
	@Column(name="country") 
	private String country;
	
	@Column(name="date")
	private Date date;

	public String getEid() {
		return eid;
	}


	public void setEid(String eid) {
		this.eid = eid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", name=" + name + ", country="
				+ country + ", date=" + date + "]";
	}
}
