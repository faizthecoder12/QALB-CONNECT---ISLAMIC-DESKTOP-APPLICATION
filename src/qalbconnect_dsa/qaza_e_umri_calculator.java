package qalbconnect_dsa;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class qaza_e_umri_calculator {

    private static long fajr = 0;
    private static long zuhr = 0;
    private static long asr = 0;
    private static long maghrib = 0;
    private static long isha = 0;
    private static long witr = 0;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            boolean running = true;

            System.out.print("Enter your gender (male/female): ");
            String gender = scanner.nextLine().toLowerCase();

            int periodDays = 0;
            if (gender.equals("female")) {
                System.out.print("Enter average period days (3 to 10): ");
                periodDays = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                if (periodDays < 3 || periodDays > 10) {
                    System.out.println("Invalid input. Period days must be between 3 and 10.");
                    return;
                }
            }

            while (running) {
                System.out.println("\n=== Qaza Prayers Calculator ===");
                System.out.println("1. Calculate Missed Prayers");
                System.out.println("2. Adjust Prayer Counts");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1 ->
                        calculateMissedPrayers(scanner, formatter, gender, periodDays);
                    case 2 ->
                        adjustPrayerCounts(scanner);
                    case 3 -> {
                        System.out.println("Exiting the application. Goodbye!");
                        running = false;
                    }
                    default ->
                        System.out.println("Invalid choice. Please select a valid option.");
                }
            }
        }
    }

    public static void calculateMissedPrayers(Scanner scanner, DateTimeFormatter formatter, String gender, int periodDays) {
        System.out.print("Enter the date when you became baligh (dd-MM-yyyy): ");
        String startDateInput = scanner.nextLine();
        LocalDate startDate = LocalDate.parse(startDateInput, formatter);

        System.out.print("Enter the current or ending date (dd-MM-yyyy): ");
        String endDateInput = scanner.nextLine();
        LocalDate endDate = LocalDate.parse(endDateInput, formatter);

        if (endDate.isBefore(startDate)) {
            System.out.println("Error: Ending date cannot be before starting date!");
            return;
        }

        long totalDays = ChronoUnit.DAYS.between(startDate, endDate) + 1; // Including the end date

        if (gender.equals("female")) {
            System.out.print("Enter the number of monthly cycles missed: ");
            int totalCycles = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            long excludedPeriodDays = totalCycles * periodDays; // Total excluded days
            long missedDays = totalDays - excludedPeriodDays;

            if (missedDays < 0) {
                missedDays = 0;
            }

            // Output specific to females
            System.out.println("\nMissed Prayers Calculation for Female:");
            System.out.println("Date From: " + startDate.format(formatter));
            System.out.println("Date To: " + endDate.format(formatter));
            System.out.println("Total Days: " + totalDays);
            System.out.println("Excluded Period Days: " + excludedPeriodDays);
            System.out.println("Missed Days (excluding periods): " + missedDays);
            System.out.println("Fajr: " + missedDays);
            System.out.println("Zuhr: " + missedDays);
            System.out.println("Asr: " + missedDays);
            System.out.println("Maghrib: " + missedDays);
            System.out.println("Isha: " + missedDays);
            System.out.println("Witr: " + missedDays);

            storePrayerCounts(missedDays);
        } else {
            // Logic for male users
            long missedDays = totalDays;

            System.out.println("\nMissed Prayers Calculation for Male:");
            System.out.println("Date From: " + startDate.format(formatter));
            System.out.println("Date To: " + endDate.format(formatter));
            System.out.println("Total Days: " + totalDays);
            System.out.println("Missed Days: " + missedDays);
            System.out.println("Fajr: " + missedDays);
            System.out.println("Zuhr: " + missedDays);
            System.out.println("Asr: " + missedDays);
            System.out.println("Maghrib: " + missedDays);
            System.out.println("Isha: " + missedDays);
            System.out.println("Witr: " + missedDays);

            storePrayerCounts(missedDays);
        }
    }

    public static void storePrayerCounts(long totalDays) {
        fajr = zuhr = asr = maghrib = isha = witr = totalDays;
    }

    public static void adjustPrayerCounts(Scanner scanner) {
        System.out.println("\nAdjust Prayer Counts:");
        fajr = adjustIndividualPrayer(scanner, "Fajr", fajr);
        zuhr = adjustIndividualPrayer(scanner, "Zuhr", zuhr);
        asr = adjustIndividualPrayer(scanner, "Asr", asr);
        maghrib = adjustIndividualPrayer(scanner, "Maghrib", maghrib);
        isha = adjustIndividualPrayer(scanner, "Isha", isha);
        witr = adjustIndividualPrayer(scanner, "Witr", witr);
    }

    public static long adjustIndividualPrayer(Scanner scanner, String prayerName, long currentCount) {
        System.out.println("\n" + prayerName + " Current Count: " + currentCount);
        System.out.print("Do you want to adjust " + prayerName + " count? (yes/no): ");
        String choice = scanner.nextLine().toLowerCase();

        if (choice.equals("yes")) {
            System.out.print("Enter adjustment (e.g., +5 or -3): ");
            String adjustment = scanner.nextLine();

            if (adjustment.startsWith("+")) {
                currentCount += Integer.parseInt(adjustment.substring(1));
            } else if (adjustment.startsWith("-")) {
                currentCount -= Integer.parseInt(adjustment.substring(1));
                if (currentCount < 0) {
                    currentCount = 0; // Ensure no negative prayers
                }
            }

            System.out.println("Updated " + prayerName + " count: " + currentCount);
        }
        return currentCount;
    }
}
