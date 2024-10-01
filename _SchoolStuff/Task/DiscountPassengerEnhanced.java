

import java.text.DecimalFormat;
import java.util.Scanner;

public class DiscountPassengerEnhanced {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("###,###.##");

        char fareCode, yesOrNo;
        double fare, discount, discountPercentage, businessCharge, newFare;

        
        System.out.print("Enter fare: ");
        fare = input.nextDouble();
        
        System.out.print("Passenger type [O: Ordinary, S: Student, C: Senior Citizen]: ");
        fareCode = input.next().charAt(0);
        
        System.out.print("Travelling in business class? [Y/N]: ");
        yesOrNo = input.next().charAt(0);
        
        businessCharge = 0.0;
        discountPercentage = 0.0;
        newFare = 0.0;
        //safety net
        yesOrNo = Character.toUpperCase(yesOrNo);
        fareCode = Character.toUpperCase(fareCode);

        switch (yesOrNo) {
            case 'Y':
                discountPercentage = conditionY(fareCode, discountPercentage, businessCharge, newFare); // Fixed fareCode parameter here
                break;
            case 'N':
                discountPercentage = conditionN(fareCode, discountPercentage, newFare);  // Fixed fareCode parameter here
                break;
            default:
                System.out.println("invalid input");
                break;
        }

        discount = discount(fare, discountPercentage);
        newFare = newFare(fare,discount,businessCharge);

        System.out.println("\nDiscount: " + df.format(discount));
        System.out.println("Bussiness class charge: " + df.format(businessCharge));
        System.out.println("New fare: " + df.format(newFare));
    }

    public static double conditionY(char fareCode, double discountPercentage, double businessCharge, double newFare) {
        switch (fareCode) {
            case 'O':
                businessCharge = 1000;
                discountPercentage = 0.0;
                break;
            case 'S':
                businessCharge = 700;
                discountPercentage = 0.05;
                break;
            case 'C':
                businessCharge = 500;
                discountPercentage = 0.10;
                break;
        }
        return discountPercentage;
    }
    public static double conditionN(char fareCode, double discountPercentage, double newFare) {
        switch (fareCode) {
            case 'O':
                discountPercentage = 0.0;
                break;
            case 'S':
                discountPercentage = 0.05;
                break;
            case 'C':
                discountPercentage = 0.10;
                break;
            default:
                System.out.println("invalid input");
                break;
        }
        return discountPercentage;
    }

    public static double discount(double fare, double discountPercentage) {
        return fare * discountPercentage;
    }

    public static double newFare(double fare, double discount, double businessCharge) {
        return fare - discount + businessCharge;
    }
}