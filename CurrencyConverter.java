import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double usdToEur = 0.95;  // Example conversion rates
        double usdToGbp = 0.82;
        double usdToInr = 82.0;

        System.out.println("Welcome to the Currency Converter!");
        System.out.println("Available currencies: ");
        System.out.println("1. EUR (Euro)");
        System.out.println("2. GBP (British Pound)");
        System.out.println("3. INR (Indian Rupee)");

        System.out.print("Enter amount in USD: ");
        double amountInUsd = scanner.nextDouble();

        System.out.print("Enter the target currency (1 for EUR, 2 for GBP, 3 for INR): ");
        int choice = scanner.nextInt();

        double convertedAmount = 0;
        String currency = "";

        switch (choice) {
            case 1:
                convertedAmount = amountInUsd * usdToEur;
                currency = "EUR";
                break;
            case 2:
                convertedAmount = amountInUsd * usdToGbp;
                currency = "GBP";
                break;
            case 3:
                convertedAmount = amountInUsd * usdToInr;
                currency = "INR";
                break;
            default:
                System.out.println("Invalid choice!");
                System.exit(0);
        }

        System.out.println("Converted amount: " + convertedAmount + " " + currency);
        scanner.close();
    }
}
