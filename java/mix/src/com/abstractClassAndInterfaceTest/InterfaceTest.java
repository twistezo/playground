/**
 * Interface vs standard class:
 * -children must implement Interface methods
 * -interface has methods withoud body
 * -interface has by default public abstract methods
 * -interface has by default public static final fields
 * -interface can extend other interface
 *
 * Interface vs Abstract class
 * -class can implement many interfaces 
 * -class can inheritate from one abstract class
 * -interface has only public fields, method
 * -abstract class can have private, protected
 * -interface has only method declaration (without body)
 * -abstract class can have abstract and normal methods
 */

class InterfaceTest implements InterfaceAnimal {

	@Override
	public void eat() {
		System.out.println("Test - eat");
	}

	@Override
	public void travel() {
		System.out.println("Test - travel");
	}

	public static void main(String[] args) {
		InterfaceTest test = new InterfaceTest();

		int number = InterfaceAnimal.NUMBER;
		System.out.println(number);

		test.eat();
		test.travel();
	}

}
