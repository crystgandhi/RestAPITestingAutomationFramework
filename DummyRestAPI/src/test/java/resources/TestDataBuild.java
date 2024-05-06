package resources;

import PojoEmployee.CreateEmployeeDataPojo;

public class TestDataBuild {
	
	public CreateEmployeeDataPojo employeeData() {
	CreateEmployeeDataPojo employeeData=new CreateEmployeeDataPojo();
	employeeData.setName("test");
	employeeData.setAge("123");
	employeeData.setSalary("23");
	return employeeData;

}}
