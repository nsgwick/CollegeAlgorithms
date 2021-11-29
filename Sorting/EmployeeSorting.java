// Import modules
import java.util.*;
/**
 * College work for sorting employees by their commission quantity.
 */
public class EmployeeSorting {
	// Initiate a static and empty list of employees which will be added to.
	private static List<Employee> employees = new ArrayList<>();
	// Main method - runs on runtime.
	public static void main(String[] args) {
		// Add 5 example employees to demonstrate the functionality of this program.
		employees.add(new Employee("Jack",1,6));
		employees.add(new Employee("Max",2,3));
		employees.add(new Employee("Jake",3,2));
		employees.add(new Employee("Joab",4,7));
		employees.add(new Employee("Rob",5,1));
		// Display the employees' details in their current order (ordered by ID).
		displayEmployees();
		// Sort the employees list by the commission quantity per employee from low to high.
		employees = sortByCommissionQuantitiesLowToHigh(employees);
		// Output that it has been sorted.
		System.out.println("Sorted.");
		// Display the employees' details in their new order (ordered by commission quantity).
		displayEmployees();
		System.exit(0);
	}
	private static List<Employee> sortByCommissionQuantitiesLowToHigh(List<Employee> employees) {
		// Sort the employees list.
		employees.sort(Comparator.comparing(Employee::getCommissionQuantity));
		// Return the sorted list of employees.
		return employees;
	}
	private static void displayEmployees() {
		// Cycle through the elements in the employees list.
		for(Employee e : employees) {
			// Output the details of each employee to a new line.
			System.out.println(e.getStringOfDetails());
		}
	}
}
// Employee class.
class Employee {
	// Set up the private variables per object
	private String name;
	private int id;
	private List<Commission> commissions;
	// Create the constructor
	public Employee(final String n, final int ID, final int defaultCommissionQuantity) {
		// This code runs when an Employee object is created.
		// Initialise the relevant private variables.
		this.name = n;
		this.id = ID;
		this.commissions = new ArrayList<>();
		// Add the relevant amount of (empty) commissions (for demonstration).
		for(int i = 0; i < defaultCommissionQuantity; i++) {
			// Add an empty commission to the commissions list of the object.
			this.commissions.add(new Commission());
		}
	}
	/**
	 * Get the number of commissions.
	 * @return The size of the list of commissions.
	 */
	public int getCommissionQuantity() {
		// Return the size of the commissions list.
		return this.commissions.size();
	}
	/**
	 * Use this when outputting an employee's details to the console.
	 * @return A readable string of details.
	 */
	public String getStringOfDetails() {
		// Concatenate the values and return the concatenated string.
		return "Comms: " + this.getCommissionQuantity() + ", Name: " + name + ", id: " + id;
	}
}
// Empty Commission class (standard object).
class Commission {}
