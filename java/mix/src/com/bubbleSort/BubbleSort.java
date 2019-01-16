import java.util.ArrayList;
import java.util.Random;

public class BubbleSort {

    private static ArrayList<Integer> randomNumbers() {
        Random random = new Random();
        ArrayList<Integer> rand = new ArrayList<Integer>();

        for (int i = 0; i < 20; i++) {
            rand.add(random.nextInt(100) - 100);
        }
        return rand;
    }

    private static ArrayList<Integer> sort(ArrayList<Integer> list) {
        System.out.println("Sorting...");
        ArrayList<Integer> sortedList = new ArrayList<Integer>(list);
        int temp;
        boolean isSorted = false;

        while (!isSorted) {

            for (int i = 0; i < sortedList.size() - 1; i++) {
                if (sortedList.get(i) > sortedList.get(i + 1)) {

                    temp = sortedList.get(i + 1);
                    //Move bigger to next position
                    sortedList.set(i + 1, sortedList.get(i));
                    //Move lower to before position
                    sortedList.set(i, temp);

                    isSorted = false;
                }
            }

            isSorted = true;
        }
        return sortedList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> unsortedList = new ArrayList<Integer>(randomNumbers());
        System.out.println("Unsorted list: " + unsortedList);

        ArrayList<Integer> sorted = new ArrayList<Integer>(sort(unsortedList));
        System.out.println("Sorted list: " + sorted);

    }

}