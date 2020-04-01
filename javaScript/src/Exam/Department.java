package Exam;

public class Department {
	int departmentId;
	String departmenName;
	int managerId;
	int locationId;
	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmenName=" + departmenName + ", managerId="
				+ managerId + ", locationId=" + locationId + "]";
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmenName() {
		return departmenName;
	}
	public void setDepartmenName(String departmenName) {
		this.departmenName = departmenName;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	

	
}
