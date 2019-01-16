/**
 * @Differences
 * Abstract class vs standard class:
 * -can't create object from abstract class
 * -abstract class can't be final class
 * -abstract class can have abstract method 
 * -abstract class can inherite from only one class
 * -abstract method should be overriden in inheriting(children) class
 * -abstract method can't be static
 * -abstract method doesn't have implementations
 * -children must implement abstract method
 * -if abstract class have constructor you must implement it
 */

class AbstractTest {

	public static void main(String[] args) {

		AbstractEmployee employee = new ChildrenSalary("John", 20, 200);
		ChildrenSalary salary = new ChildrenSalary("Adam", 50, 500);

		employee.mailCheck();
		salary.mailCheck();
	}

}
