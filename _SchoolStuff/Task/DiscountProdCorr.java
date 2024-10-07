package _SchoolStuff.Task;

import java.util.Scanner;
import java.text.DecimalFormat;

public class DiscountProdCorr {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("###,###.00");

        String modePayment = "", product = "", product1 = "", product2 = "", product3 = "";
        double price = 0.0, price1 = 0.0, price2 = 0.0, price3 = 0.0;
        double discountRate = 0.0;
        double interest, interest3 = 0.0, interest6 = 0.0, interest12 = 0.0;
        double total = 0.0, monthlyPayment = 0.0;
        int months = 0;
        char item;

        // Input products and prices
        System.out.print("\nEnter Product 1: ");
        product1 = input.nextLine();
        System.out.print("Enter Price: ");
        price1 = input.nextDouble();
        input.nextLine();

        System.out.print("\nEnter Product 2: ");
        product2 = input.nextLine();
        System.out.print("Enter Price: ");
        price2 = input.nextDouble();
        input.nextLine();

        System.out.print("\nEnter Product 3: ");
        product3 = input.nextLine();
        System.out.print("Enter Price: ");
        price3 = input.nextDouble();
        input.nextLine();

        // Input Mode of Payment
        System.out.print("\nInput Mode of Payment Terms");

        System.out.print("\nCash discount (%): ");
        discountRate = input.nextDouble();
        System.out.println("\tYou input " + df.format(discountRate) + "% Discount for Cash");

        System.out.print("\n3 Months Installment Interest (%): ");
        interest3 = input.nextDouble() / 100;
        System.out.println("\tYou input " + df.format(interest3 * 100) + "% Interest for 3 Months Installment");

        System.out.print("\n6 Months Installment Interest (%): ");
        interest6 = input.nextDouble() / 100;
        System.out.println("\tYou input " + df.format(interest6 * 100) + "% Interest for 6 Months Installment");

        System.out.print("\n12 Months Installment Interest (%): ");
        interest12 = input.nextDouble() / 100;
        System.out.println("\tYou input " + df.format(interest12 * 100) + "% Interest for 12 Months Installment");

        // Main menu
        System.out.println("\nMain Menu");
        System.out.println("\n Press I/i: " + product1 + "\tPrice: " + df.format(price1) + " dollars");
        System.out.println("\n Press S/s: " + product2 + "\tPrice: " + df.format(price2) + " dollars");
        System.out.println("\n Press X/x: " + product3 + "\tPrice: " + df.format(price3) + " dollars");

        System.out.print("\nEnter Item: ");
        item = input.next().charAt(0);
        item = Character.toLowerCase(item);
        input.nextLine();

        switch (item) {
            case 'i':
                System.out.println("Product: " + product1 + "\nPrice: " + df.format(price1));
                product = product1;
                price = price1;
                break;
            case 's':
                System.out.println("Product: " + product2 + "\nPrice: " + df.format(price2));
                product = product2;
                price = price2;
                break;
            case 'x':
                System.out.println("Product: " + product3 + "\nPrice: " + df.format(price3));
                product = product3;
                price = price3;
                break;
            default:
                System.out.println("Invalid selection.");
                return;
        }

        System.out.println("\nPress 1: Cash\t" + df.format(discountRate) + "% Discount");
        System.out.println("Press 2: 3 Months Installment\t" + df.format(interest3 * 100) + "% Interest");
        System.out.println("Press 3: 6 Months Installment\t" + df.format(interest6 * 100) + "% Interest");
        System.out.println("Press 4: 12 Months Installment\t" + df.format(interest12 * 100) + "% Interest");

        System.out.print("\nEnter Mode of Payment: ");
        modePayment = input.nextLine().toLowerCase();

        double discount = 0.0;
        switch (modePayment) {
            case "1":
                System.out.println("Mode of payment: Cash");
                discount = price * (discountRate / 100);
                break;

            case "2":
                System.out.println("Mode of payment: 3 Months Installment");
                months = 3;
                break;

            case "3":
                System.out.println("Mode of payment: 6 Months Installment");
                months = 6;
                break;

            case "4":
                System.out.println("Mode of payment: 12 Months Installment");
                months = 12;
                break;

            default:
                System.out.println("Invalid payment mode selected.");
                return;
        }

        double interestAmount = 0.0;
        if (months > 0) {
            switch (months) {
                case 3:
                    interestAmount = price * interest3;
                    break;
                case 6:
                    interestAmount = price * interest6;
                    break;
                case 12:
                    interestAmount = price * interest12;
                    break;
            }
        }

        total = price - discount + interestAmount;
        monthlyPayment = months > 0 ? total / months : 0;

        // Print results
        System.out.print("\nItem: " + product);
        System.out.println("\nPrice: $" + df.format(price));
        System.out.println("Discount: $" + df.format(discount));
        System.out.println("Interest: $" + df.format(interestAmount));
        System.out.println("Total: $" + df.format(total));
        System.out.println("Monthly Payment: $" + df.format(monthlyPayment));

        input.close();
    }
}