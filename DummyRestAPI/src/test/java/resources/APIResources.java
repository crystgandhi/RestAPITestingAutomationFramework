package resources;

public enum APIResources {
	
	AllEmployeeDataAPI("/api/v1/employees"),
	SingleEmployeeDataAPI("api/v1/employee/4539"),
	CreateNewEmployeeDataAPI("/api/v1/create"),
	UpdataeEmployeeDataAPI("/api/v1/update/{id}"),
	DeleteEmployeeDataAPI("/api/v1/delete/{id}");
	
	private String resource;

	APIResources(String resource) {
		this.resource=resource;
	}
	
	public String getResouce() {
		return resource;
	}

}
