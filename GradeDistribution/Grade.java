import java.util.ArrayList;
import java.util.Scanner;

/*Justin G
 **/
public class Grade {

    public static ArrayList<Integer> inputGrades(Scanner scanner, ArrayList<Integer> grades) {
        int i = 0;

        for (;;) {
            System.out.println("Input grade: ");
            int grade = Integer.parseInt(scanner.nextLine());
            if (inputCheck(grade) == false) {
                break;
            }
            grades.add(grade);
        }

        return grades;
    }

    public static boolean inputCheck(int grade) {
        if (grade < 0) {
            return false;
        } else if (grade > 60) {
            return false;
        }
        return true;
    }

    public static void printDistribution(ArrayList<Integer> grades) {
        String zero = "";
        String one = "";
        String two = "";
        String three = "";
        String four = "";
        String five = "";

        int accepted = 0;
        double acceptance_rate = 0.0;

        for (int i = 0; i < grades.size(); i++) {
            if ((grades.get(i) > 55) && (grades.get(i) <= 60)) {
                five += "*";
                accepted++;
            } else if ((grades.get(i) > 50) && (grades.get(i) <= 55)) {
                four += "*";
                accepted++;
            } else if ((grades.get(i) > 45) && (grades.get(i) <= 50)) {
                three += "*";
                accepted++;
            } else if ((grades.get(i) > 40) && (grades.get(i) <= 45)) {
                two += "*";
                accepted++;
            } else if ((grades.get(i) > 35) && (grades.get(i) <= 40)) {
                one += "*";
                accepted++;
            } else if ((grades.get(i) < 30) && (grades.get(i) >= 0)){
                zero += "*";
            }
        }

            System.out.println("Grade distribution: ");
            System.out.print("5: " + five);
            System.out.print("\n4: " + four);
            System.out.print("\n3: " + three);
            System.out.print("\n2: " + two);
            System.out.print("\n1: " + one);
            System.out.print("\n0: " + zero);


            System.out.println();
            System.out.println("Acceptance rate: " + getAcceptance_rate(accepted, grades.size()));
        }


    public static double getAcceptance_rate(int accepted, int length) {
        return (100 * accepted) / length;
    }

}
