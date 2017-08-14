import java.util.ArrayList;
import java.util.Scanner;

/**
 * Justin G
 */
public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer>();

        Grade.inputGrades(reader, list);

        Grade.printDistribution(list);



    }
}



