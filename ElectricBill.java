import java.util.Scanner;

public class ElectricBill {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input user details
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();

        System.out.print("Enter customer ID: ");
        int customerId = scanner.nextInt();

        System.out.print("Enter number of units consumed this month: ");
        double unitsConsumed = scanner.nextDouble();

        System.out.print("Enter Back Dues: ");
        double backdues = scanner.nextDouble();

        // Calculate bill (without fixed charge)
        double billAmount = calculateBill(unitsConsumed);

        // Fixed charge
        double fixedCharge = 50;

        // Apply subsidy
        double subsidy = billAmount * 0.10;
        double amountAfterSubsidy = billAmount - subsidy;

        // Final total
        double totalAmount = amountAfterSubsidy + fixedCharge + backdues;

        // Output
        System.out.println("\n----- Electricity Bill -----");
        System.out.println("Customer Name: " + customerName);
        System.out.println("Customer ID: " + customerId);
        System.out.println("Units Consumed: " + unitsConsumed);

        System.out.printf("Energy Charge: %.2f\n", billAmount);
        System.out.printf("Government Subsidy (10%%): -%.2f\n", subsidy);
        System.out.printf("Fixed Charge: %.2f\n", fixedCharge);
        System.out.printf("Back Dues: %.2f\n", backdues);

        System.out.printf("Total Bill Amount: %.2f\n", totalAmount);
    }

    public static double calculateBill(double units) {
        double amount;

        if (units <= 100) {
            amount = units * 1.5;
        } else if (units <= 300) {
            amount = (100 * 1.5) + ((units - 100) * 2.5);
        } else if (units <= 500) {
            amount = (100 * 1.5) + (200 * 2.5) + ((units - 300) * 4.0);
        } else {
            amount = (100 * 1.5) + (200 * 2.5) + (200 * 4.0) + ((units - 500) * 6.0);
        }

        return amount; // fixed charge removed from here
    }
}