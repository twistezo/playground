import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Lambda expression
 * Used only with functional interface.
 * Functional interface: interface with a single method only.
 *
 * Shortcut: a -> a.canCalculate()
 *  a: parameter name
 *  a.canCalculate(): method body
 *
 * Full: (int a) -> {return a.canCalculate();}
 */

public class Lambdas {
    private final static int c = 20;
    private final static int d = 4;

    /**
     * Functional interfaces example
     */
    interface StringOperation {
        void printMessage(String message);
    }

    interface MathOperation {
        int operation(int a, int b);
    }

    public static void main(String[] args) {

        System.out.println("Numbers: a=20, b=4\n");

        helloWorld();
        lambdaDeclarations();
        lambdaLoops();
        lambdaSorting();
    }

    /**
     * Standard hello world example
     */
    private static void helloWorld() {

        /*
          Lambda hello world example
         */
        StringOperation stringOp = message -> System.out.println(message);
        stringOp.printMessage("Hello Lambda!");

    }

    /**
     * Different ways to declare Lambda
     */
    private static void lambdaDeclarations() {
        /*
          With type declaration
         */
        MathOperation addition = (int a, int b) -> a + b;
        System.out.println("Addition: " + addition.operation(c, d));

        /*
          Without type declaration
         */
        MathOperation subtraction = (a, b) -> a - b;
        System.out.println("Subtraction: " + subtraction.operation(c, d));

        /*
          With return statement along with curly braces
         */
        MathOperation multiplication = (int a, int b) -> {
            return a * b;
        };
        System.out.println("Multiplication: " + multiplication.operation(c, d));

        /*
          Without return statement and without curly braces
         */
        MathOperation division = (int a, int b) -> a / b;
        System.out.println("Division: " + division.operation(c, d));
    }

    /**
     * forEach loops using Lambda
     */
    private static void lambdaLoops() {

        /*
          Traditional loop
         */
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            numbers.add(i);
        System.out.print("\nTraditional loop: ");
        for (Integer i : numbers)
            System.out.print(numbers.get(i) + "; ");

        /*
          Lambda loop v1
         */
        System.out.print("\nLambda loop: ");
        numbers.forEach((i) -> System.out.print(i + "; "));

        /*
        Lambda loop v2
         */
        System.out.print("\nDifferent way Lambda loop: ");
        numbers.forEach(System.out::print);
    }

    /**
     * Sorting collections using Lambda
     */
    private static void lambdaSorting() {

        /*
        Sorting collection using Lambda
         */
        String[] animals = { "dog", "mouse", "rat", "pig", "cat" };

        /*
        Standard way
         */
        Arrays.sort(animals, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1.compareTo(o2));
            }
        });

        /*
        Using Lambda v1
         */
        Comparator<String> sortByName = (String s1, String s2) -> (s1.compareTo(s2));
        Arrays.sort(animals, sortByName);

        /*
        Using Lambda v2
         */
        Arrays.sort(animals, (String s1, String s2) -> (s1.compareTo(s2)));

        /*
        Result
         */
        System.out.println("\n\nSorting using Lambda: ");
        for (String animal : animals) {
            System.out.print(animal + "; ");
        }
    }

    /**
     * Creating new thread using Lambda
     */
    private static void lambdaNewThread() {
        /*
        Standard way
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("New Thread. Hello!");
            }
        });

        /*
        Using Lambda
         */
        new Thread(() -> System.out.println("New Thread using Lambda. Hello!")).start();
    }

}