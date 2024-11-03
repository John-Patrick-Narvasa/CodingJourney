package _SchoolStuff.Task.Finals;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        printPattern();
    }
    
    public static void printPattern() {
        int rows = 1;
        char Char;
    
        Scanner scan = new Scanner(System.in);
    
        System.out.print("Enter Character: ");
        Char = scan.next().charAt(0);
    
        System.out.print("Enter Size: ");
        rows = scan.nextInt();
    
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                if (j == 1) {
                    System.out.print("");
                } else {
                    System.out.print("-");
                }
            }
            System.out.print(Char);
            for (int j = rows; j >= 1; j--) {
                if (j == rows) {
                    System.out.print("");
                } else {
                    System.out.print("-");
                }
            }
            System.out.println();
        }
        scan.close();
    }
}
