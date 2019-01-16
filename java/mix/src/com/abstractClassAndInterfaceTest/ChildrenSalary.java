class ChildrenSalary extends AbstractEmployee {
	double salary;

	public ChildrenSalary(String name, int number, double salary) {
		super(name, number);
		setSalary(salary);
		System.out.println("CHILDREN: Salary - Constructor");
	}

	public void mailCheck() {
		checkingMailTest();
		System.out.println("CHILDREN: Mail: " + getName() + " " + getNumber() + " " + salary);
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double newSalary) {
		salary = newSalary;
	}

	@Override
	void checkingMailTest() {
		System.out.println("I'm checking mail");

	}
}