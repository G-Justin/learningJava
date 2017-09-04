import java.util.ArrayList;
import java.util.Scanner;

public class WeeklyExpenses {

    //==================================================================================
    // Properties
    //==================================================================================

    private Scanner scanner;
    private ArrayList<Week> weeks;
    private double allowance;
    private double overall_expenses;
    private double overall_percentage;
    private double overall_average;


    //==================================================================================
    // Constructors
    //==================================================================================

    public WeeklyExpenses() {
        this.scanner = new Scanner(System.in);
        this.weeks = new ArrayList<Week>();
        this.allowance = 0;
        this.overall_expenses = 0;
        this.overall_percentage = 0;
        this.overall_average = 0;
    }

    //==================================================================================
    // Accessors
    //==================================================================================

    public void startCalculator() {
        System.out.println("[WEEKLY EXPENSES CALCULATOR]");
        inputAllowance(scanner);                                //Sets the value for allowance.

        do {
            int i = 1;
            System.out.println("[WEEK " + i + "]");

            newWeek();

            i++;                                      // Will execute the main program at least once before
    } while (calculateAgain(scanner));               // asking again.

        printOverallResults();
    }

    private void newWeek() {
        Week week = new Week();                 //Creates a new week, then adds into the array.
        weeks.add(week);
        week.initializeWeek(getAllowance());                  // Calls the primary method of the week object.
    }

    private boolean calculateAgain(Scanner scanner) {
        System.out.println();                                     //Prompts the user to add another week
        System.out.print("Add a new week?(y/n)");
        String answer = scanner.nextLine();
        System.out.println();
        if (answer.equals("y")) {
            return true;
        }

        return false;
    }

    private void printOverallResults() {
        System.out.println("[OVERALL RESULTS]");
        calculateOverallExpenses();                            //Calculate the values first
        calculateOverallPercentage();
        calculateOverallAverage();

        System.out.println("Overall expenses: " + getOverall_expenses());
        System.out.println("Overall percentage spent: " + getOverallPercentage() + "%");
        System.out.println("Overall average expense per week: " + getOverallAverage());
        System.out.println("Allowance remaining: " + (getTotalAllowance() - getOverall_expenses()));
    }

    private void inputAllowance(Scanner scanner) {
        System.out.print("What is your daily allowance: ");              //Gets daily allowance for the weekly allowance
        double helper = Double.parseDouble(scanner.nextLine());          // value

        System.out.print("Include weekends(y/n): ");
        String answer = scanner.nextLine();
        System.out.println();

        if (answer.equals("y")) {
            allowance += helper * 7;                               // include weekends = 7 days of allowance
        } else {
            allowance += helper * 5;                               // else weekends = 5 days of allowance
        }
    }

    private double getAllowance() {
        return allowance;
    }

    private double getTotalAllowance() {
        return allowance * weeks.size();                 // Allowance * number of weeks added by the user
    }

    private double getOverall_expenses() {
        return overall_expenses;
    }

    private void calculateOverallExpenses() {
        for (Week week : weeks) {
            overall_expenses += week.getExpenses_total();    //Total of all weeks' expenses
        }
    }

    private double getOverallPercentage() {
        return overall_percentage;
    }

    private void calculateOverallPercentage(){
        overall_percentage = (getOverall_expenses() / getTotalAllowance()) * 100;
    }

    private double getOverallAverage() {
        return overall_average;
    }

    private void calculateOverallAverage() {
        overall_average = getOverall_expenses() / weeks.size();    //Overall in WEEKS
    }





}
