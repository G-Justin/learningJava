import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Justin on 8/13/2017.
 */
public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        BirdMenu database = new BirdMenu();

        database.checkInput(reader);

    }
}



