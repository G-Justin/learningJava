import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Ian on 8/13/2017.
 */
public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer>();

        Grade.inputGrades(reader, list);

        Grade.printDistribution(list);



    }
}



