import java.util.ArrayList;
import java.util.Scanner;

public class WeeklyTemperatures {

    public static void main(String[] args) {
        // Initialize the Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Create and populate the ArrayList for days of the week
        ArrayList<String> daysOfWeek = new ArrayList<>();
        daysOfWeek.add("Monday");
        daysOfWeek.add("Tuesday");
        daysOfWeek.add("Wednesday");
        daysOfWeek.add("Thursday");
        daysOfWeek.add("Friday");
        daysOfWeek.add("Saturday");
        daysOfWeek.add("Sunday");

        // Create and populate the ArrayList for average temperatures
        ArrayList<Double> dailyTemps = new ArrayList<>();
        dailyTemps.add(65.5); // Monday temp
        dailyTemps.add(68.0); // Tuesday temp
        dailyTemps.add(70.2); // Wednesday temp
        dailyTemps.add(69.8); // Thursday temp
        dailyTemps.add(72.5); // Friday temp
        dailyTemps.add(75.0); // Saturday temp
        dailyTemps.add(74.1); // Sunday temp

        boolean keepRunning = true;

        System.out.println("Welcome to the Weekly Temperature Tracker!");

        // Looping construct to keep asking the user for input
        while (keepRunning) {
            System.out.println("\nEnter a day of the week (e.g., Monday) or type 'week' for the weekly summary.");
            System.out.print("Type 'exit' to quit: ");
            
            // Read input and clean it up (trim whitespace)
            String userInput = scanner.nextLine().trim();

            // Decision constructs to handle different inputs
            if (userInput.equalsIgnoreCase("exit")) {
                System.out.println("Exiting program. Goodbye!");
                keepRunning = false;

            } else if (userInput.equalsIgnoreCase("week")) {
                double tempSum = 0;
                System.out.println("\n--- Weekly Temperatures ---");
                
                // Loop through parallel ArrayLists to display all days and calculate the sum
                for (int i = 0; i < daysOfWeek.size(); i++) {
                    System.out.println(daysOfWeek.get(i) + ": " + dailyTemps.get(i) + " degrees");
                    tempSum += dailyTemps.get(i);
                }
                
                // Calculate and display the weekly average
                double weeklyAverage = tempSum / dailyTemps.size();
                System.out.printf("Weekly Average: %.2f degrees\n", weeklyAverage);

            } else {
                // Check if the user entered a valid day of the week
                boolean dayFound = false;
                
                for (int i = 0; i < daysOfWeek.size(); i++) {
                    if (daysOfWeek.get(i).equalsIgnoreCase(userInput)) {
                        System.out.println("\nThe average temperature for " + daysOfWeek.get(i) + " is " + dailyTemps.get(i) + " degrees.");
                        dayFound = true;
                        break;
                    }
                }
                
                if (!dayFound) {
                    System.out.println("\nInvalid input. Please ensure you type a valid day of the week or 'week'.");
                }
            }
        }
        
        scanner.close();
    }
}