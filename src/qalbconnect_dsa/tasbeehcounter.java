package qalbconnect_dsa;
import java.util.Scanner;
import java.util.Stack;

public class tasbeehcounter {

    // Stack to store history of counts
    public Stack<Integer> countHistory = new Stack<>();
    public int currentCount = 0;

    // Increment count and save to history
    public void increment() {
        countHistory.push(currentCount);
        currentCount++;
    }

    // Reset count and save to history
    public void reset() {
        countHistory.push(currentCount);
        currentCount = 0;
    }

    // Undo last action by popping from history
    public void undo() {
        if (!countHistory.isEmpty()) {
            currentCount = countHistory.pop();
        } else {
            System.out.println("No actions to undo.");
        }
    }

    // Get the current count
    public int getCurrentCount() {
        return currentCount;
    }

    // Display the main menu
    public void displayMenu() {
        System.out.println("\n=== Tasbeeh Counter ===");
        System.out.println("1. Increment Count");
        System.out.println("2. Reset Count");
        System.out.println("3. Undo Last Action");
        System.out.println("4. Show Current Count");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    // Main method to run the application
    public static void main(String[] args) {
        tasbeehcounter counter = new tasbeehcounter();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            counter.displayMenu();
            int choice;

            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                scanner.nextLine(); // Clear invalid input
                continue;
            }

            switch (choice) {
                case 1:
                    counter.increment();
                    System.out.println("Incremented! Current Count: " + counter.getCurrentCount());
                    break;
                case 2:
                    counter.reset();
                    System.out.println("Count Reset! Current Count: " + counter.getCurrentCount());
                    break;
                case 3:
                    counter.undo();
                    System.out.println("Undo Completed! Current Count: " + counter.getCurrentCount());
                    break;
                case 4:
                    System.out.println("Current Count: " + counter.getCurrentCount());
                    break;
                case 5:
                    System.out.println("Exiting the application. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }

        scanner.close();
    }
}
