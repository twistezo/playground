import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * It's popular text game HANGMAN
 */

public class Hangman {
    private static ArrayList<String> passwordBlankArray = new ArrayList<String>();
    private static Scanner userInput = new Scanner(System.in);
    private static String userString;
    private static boolean endGame;
    private static boolean listComparison;
    private static ArrayList<Integer> lifes = new ArrayList<Integer>();

    public static void main(String[] args) {

        logic();
    }

    private static void logic() {

        //Welcome text
        System.out.println(
                ".....:::Welcome:::........" + "\n--------Hangman---------" + "\nCategory of question: Countries");

        //Create password for game (small letters!)
        String passwordToString = "venezuela";

        //Split of hasloString letters
        ArrayList<String> passwordArray = new ArrayList<String>(Arrays.asList(passwordToString.split("")));

        //Fill blank password list "--------"
        for (int i = 0; i < passwordArray.size(); i++) {
            passwordBlankArray.add("-");
        }

        //Number of lifes
        lifes.add(5);

        //Some texts
        String passwordBlankArrayFormatted = passwordBlankArray.toString().replace(",", "") //remove the commas
                .replace("[", "") //remove the right bracket
                .replace("]", "") //remove the left bracket
                .trim(); //remove trailing spaces from partially initialized arrays

        String lifesFormatted = lifes.toString().replace(",", "") //remove the commas
                .replace("[", "") //remove the right bracket
                .replace("]", "") //remove the left bracket
                .trim(); //remove trailing spaces from partially initialized arrays

        System.out.println("\nPassword: " + passwordBlankArrayFormatted);
        System.out.println("Lifes: " + lifesFormatted);

        //Game loop
        while (!endGame) {

            System.out.println("\nEnter letter: ");
            scanner();
            hangman(userString, passwordArray, lifes);
            listComparison = collectionComparison(passwordArray, passwordBlankArray);

            if (listComparison) {
                System.out.println("\nBravo!");
                endGame = true;
            }
            if (lifes.get(0) == 0) {
                System.out.println("\nYou lost! THE END.");
                System.out.println("Correct password: " + passwordToString);
                endGame = true;
            }
        }
    }

    private static void hangman(String u, ArrayList<String> p, ArrayList<Integer> l) {

        //If list isn't empty
        if (!passwordBlankArray.contains(u)) {

            //Check of user input 
            if (p.contains(u)) {
                System.out.println("Letter '" + u + "' is in password.");
            } else {
                System.out.println("Letter '" + u + "' isn't in password. You lost 1 life.");
                l.set(0, l.get(0) - 1);
            }

            //User input position in List
            ArrayList<Integer> indexArrayList = new ArrayList<Integer>();
            for (int i = 0; i < p.size(); i++) {
                if (u.equals(p.get(i))) {
                    indexArrayList.add(i);
                }
            }

            //Set correct letter from password list to password empty list
            for (int i = 0; i < indexArrayList.size(); i++) {
                passwordBlankArray.set(indexArrayList.get(i), p.get(indexArrayList.get(i)));
            }

            //test of list
            String passwordBlankArrayFormatted = passwordBlankArray.toString().replace(",", "") //remove the commas
                    .replace("[", "") //remove the right bracket
                    .replace("]", "") //remove the left bracket
                    .trim(); //remove trailing spaces from partially initialized arrays

            String lifesFormatted = l.toString().replace(",", "") //remove the commas
                    .replace("[", "") //remove the right bracket
                    .replace("]", "") //remove the left bracket
                    .trim(); //remove trailing spaces from partially initialized arrays

            System.out.println("\nPassword: " + passwordBlankArrayFormatted);
            System.out.println("Lifes: " + lifesFormatted);

        } else {
            System.out.println("Letter '" + u + "' you already guess.. 1 life left..");
            l.set(0, l.get(0) - 1);
        }
    }

    private static String scanner() {
        try {
            userString = userInput.next().toLowerCase();

        } catch (IllegalStateException | NoSuchElementException ex) {
            System.out.println("User Input ERROR");
        }
        return userString;
    }

    public static boolean collectionComparison(ArrayList<String> a, ArrayList<String> b) {
        //Check if lists have the same sizes and if they arn't empties
        if ((a.size() != b.size()) || (a == null && b != null) || (a != null && b == null)) {
            return false;
        }

        return a.equals(b);
    }

}