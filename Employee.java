
/**
 * This class stores the name of an employee, the name of the employee supervisor, and the employee's salary
 * @author Michael
 *
 */

public class Employee {

	public Employee(String employeeName, String supervisorName, double employeeSalary) {
		emp = employeeName;
		empSupervisor = supervisorName;
		salary = employeeSalary;
	}
	
	public String getName() {
		return emp;
	}
	public String getSupervisor() {
		return empSupervisor;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double newSalary) {
		salary = newSalary;
	}
	public String toString() {
		return (emp + " supervisor: " + empSupervisor + " salary : " + salary);
	}
		
	private String emp;
	private String empSupervisor;
	private double salary;
}
