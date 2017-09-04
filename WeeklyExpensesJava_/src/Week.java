import java.util.ArrayList;
import java.util.Scanner;

public class Week {

    //==================================================================================
    // Properties
    //==================================================================================

    private Scanner scanner;
    private ArrayList<Day> days;
    private double expenses_total;
    private double expenses_percentage;
    private double expenses_average;

    //==================================================================================
    // Constructors
    //==================================================================================

    public Week() {
        this.scanner = new Scanner(System.in);
        this.days = new ArrayList<Day>();
        this.expenses_total = 0;
        this.expenses_percentage = 0;
        this.expenses_average = 0;
    }

    //==================================================================================
    // Accessors
    //==================================================================================

    public double getExpenses_total() {
        return expenses_total;
    }

    private void calculateExpenses() {
        for (Day day : days) {                               // total of days' expenses
            expenses_total += day.getExpenses();
        }
    }

    public double getExpenses_percentage() {
        return expenses_percentage;
    }

    private void calculatePercentage(double allowance) {
        expenses_percentage = (getExpenses_total() / allowance) * 100;     // Percentage of allowance spent
    }

    public double getExpenses_average(){
        return expenses_average;
    }

    private void calculateAverage() {
        expenses_average = getExpenses_total() / 7;                          // Average cost per DAY
    }

    public void initializeWeek(double allowance) {
        days.add(new Day("Sunday"));                           // main program that gets the value of cost for
        days.add(new Day("Monday"));                           // each day
        days.add(new Day("Tuesday"));
        days.add(new Day("Wednesday"));
        days.add(new Day("Thursday"));
        days.add(new Day("Friday"));
        days.add(new Day("Saturday"));

        for (Day day : days) {
            day.inputExpenses(scanner);                      // Actual input method
        }

        calculateExpenses();
        calculatePercentage(allowance);                     // calculate the values of the instance variable of this class
        calculateAverage();

        printResults();
    }

    public void printResults() {
        System.out.println("Total expenses: " + getExpenses_total());
        System.out.println("Percentage of allowance spent: " + getExpenses_percentage() + "%");
        System.out.println("Average cost: " + getExpenses_average());
    }



}
