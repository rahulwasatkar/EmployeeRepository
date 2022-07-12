package com.employeemicroservice.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int employeeId;
	private String employeeAdd;
	private String employeeName;
	private long sallery;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeAdd=" + employeeAdd + ", employeeName=" + employeeName
				+ ", sallery=" + sallery + "]";
	}
	public Employee(int employeeId, String employeeAdd, String employeeName, long sallery) {
		super();
		this.employeeId = employeeId;
		this.employeeAdd = employeeAdd;
		this.employeeName = employeeName;
		this.sallery = sallery;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeAdd() {
		return employeeAdd;
	}
	public void setEmployeeAdd(String employeeAdd) {
		this.employeeAdd = employeeAdd;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public long getSallery() {
		return sallery;
	}
	public void setSallery(long sallery) {
		this.sallery = sallery;
	}

}
