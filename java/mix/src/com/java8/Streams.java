import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {

    public static void main(String[] args) {
        streamExample();
        sortByPriceWithStreams();

    }

    /**
     * A couple of operations written by simple stream() method
     */
    private static void streamExample() {
        List<String> fruits = Arrays.asList("apple", "banana", "cherry", "plum", "pear", "pineapple");

        fruits.stream().filter(s -> s.startsWith("p")).map(String::toUpperCase).sorted().forEach(System.out::println);

    }

    /**
     * Inner class for create Drink objects
     */
    private static class Drink {
        String name;
        int price;

        private Drink(String name, int price) {
            this.name = name;
            this.price = price;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    /**
     * Method for sorting Drink objects by price
     */
    private static void sortByPriceWithStreams() {

        List<Drink> drinks = Arrays.asList(new Drink("Cola", 2), new Drink("Sprite", 50), new Drink("Fanta", 10));

        Double averagePrice = drinks.stream().collect(Collectors.averagingInt(b -> b.price));

        System.out.println(averagePrice);

    }

}