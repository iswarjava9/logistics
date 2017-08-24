package com.suis.logistics;

import java.time.LocalDate;
import java.util.List;

public class EmployeeDto {

	private String name;
	private Integer age;
	private Double salary;
	private LocalDate date;
	private String departmentName;

	private List<AddressDto> addressList;

	public EmployeeDto(String name, Integer age, Double salary, LocalDate date, String departmentName,
			List<AddressDto> addressList) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.date = date;
		this.departmentName = departmentName;
		this.addressList = addressList;
	}
	public List<AddressDto> getAddressList() {
		return addressList;
	}
	public void setAddressList(List<AddressDto> addressList) {
		this.addressList = addressList;
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
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}




}
