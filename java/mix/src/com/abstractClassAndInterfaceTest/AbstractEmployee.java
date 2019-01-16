abstract class AbstractEmployee {
	private String name;
	private int number;

	public AbstractEmployee(String name, int number) {
		System.out.println("ABSTRACT: Employee - Constructor");
		this.name = name;
		this.number = number;
	}

	abstract void checkingMailTest();

	public void mailCheck() {
		System.out.println("ABSTRACT: Mail: " + this.name + this.number);
	}

	public String getName() {
		return name;
	}

	public int getNumber() {
		return number;
	}
}