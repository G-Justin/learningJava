import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Justin on 8/19/2017.
 */
public class BirdMenu {

    //=========================================================================================
    // Properties
    //=========================================================================================

    private ArrayList<Bird> database;

    //=========================================================================================
    // Constructors
    //=========================================================================================

    public BirdMenu() {
        this.database = new ArrayList<Bird>();
    }

    //=========================================================================================
    // Constructors
    //=========================================================================================

    //Gets the user input for the menu
    //Will call the function that the user has input
    public void checkInput(Scanner scanner) {
         for(;;){
            System.out.println("?");
            String input = scanner.nextLine();

            if (input.toUpperCase().equals("ADD")) {
                addBird(scanner);
            } else if (input.toUpperCase().equals("OBSERVATION")) {
                addObservation(scanner);
            } else if (input.toUpperCase().equals("STATISTICS")) {
                printStatistics();
            } else if (input.toUpperCase().equals("SHOW")) {
                showBird(scanner);
            } else if (input.toUpperCase().equals("QUIT")) {
                break;
            } else {
                System.out.println(input + " is not a valid command.");
            }
        }
    }

    //Adds to the array bird_names, latin_names. The observation will be 0 at default.
    public void addBird(Scanner scanner) {
        System.out.println("Bird name: ");
        String name = scanner.nextLine();

        System.out.println("Latin name: ");
        String latin = scanner.nextLine();

        Bird b = new Bird(name, latin);
        database.add(b);
    }

    //Scans for which bird the user wants to add observations too
    // Searches the array
    public void addObservation(Scanner scanner) {
        System.out.println("Which bird: ");
        String bird = scanner.nextLine();

        for(int i = 0; i < database.size(); i++) {
            if (database.get(i).getName().toUpperCase().equals(bird.trim().toUpperCase())) {
                database.get(i).observed();
                System.out.println("Observation added.");
                return;
            }
        }
        System.out.println("The bird entered is not in the database.");

    }

    //Prints out the whole database
    // Bird_name latin_name: x observations
    public void printStatistics() {
        for (Bird bird : database) {
            System.out.println(bird);
        }
    }

    //Shows the data of a specific bird
    public void showBird(Scanner scanner) {
        System.out.println("Which bird: ");
        String searched = scanner.nextLine();

        for (int i = 0; i < database.size(); i++) {
            if (database.get(i).getName().toUpperCase().equals(searched.trim().toUpperCase())) {
                System.out.println(database.get(i));
                return;
            }
        }
        System.out.println("The bird entered is not in the database.");
    }


} //end of class
