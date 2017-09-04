import java.util.Scanner;

public class Day {
    //==================================================================================
    // Properties
    //==================================================================================

    private String name;
    private double expenses;

    //==================================================================================
    // Constructors
    //==================================================================================

    public Day(String name) {
        this.name = name;
        this.expenses = 0;
    }

    //==================================================================================
    // Accessors
    //==================================================================================

    public String getName() {
        return name;
    }

    public double getExpenses() {
        return expenses;
    }

    public void inputExpenses(Scanner scanner) {
        System.out.print(name + ": ");                                  // Makes the user input the cost for the day
        double helper = Double.parseDouble(scanner.nextLine());

        expenses += helper;
    }

}
