package employeedata.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeid;
	private String employeename;
	private String employeeemail;
	private String employeepwd;
	@Override
	public String toString() {
		return "Employee [employeeid=" + employeeid + ", employeename=" + employeename + ", employeeemail="
				+ employeeemail + ", employeepwd=" + employeepwd + ", employeecontact=" + employeecontact + "]";
	}
	public Employee(int employeeid, String employeename, String employeeemail, String employeepwd,
			long employeecontact) {
		this.employeeid = employeeid;
		this.employeename = employeename;
		this.employeeemail = employeeemail;
		this.employeepwd = employeepwd;
		this.employeecontact = employeecontact;
	}
	public Employee() {
		super();
	}
	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	public String getEmployeename() {
		return employeename;
	}
	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}
	public String getEmployeeemail() {
		return employeeemail;
	}
	public void setEmployeeemail(String employeeemail) {
		this.employeeemail = employeeemail;
	}
	public String getEmployeepwd() {
		return employeepwd;
	}
	public void setEmployeepwd(String employeepwd) {
		this.employeepwd = employeepwd;
	}
	public long getEmployeecontact() {
		return employeecontact;
	}
	public void setEmployeecontact(long employeecontact) {
		this.employeecontact = employeecontact;
	}
	private long employeecontact;

}
