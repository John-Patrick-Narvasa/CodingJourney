package Java;

public class Factorial {
    public static void main(String[] args) {
        // int x = 1; (WA KAY PULOS)
        int y = 5;
        int r = y;
        
        for (int x = 1; x < y; x++) { // BEWARE: x <= y outputs 0
            r = r * (y-x);
        }
        System.out.println("Your mom's weight is " + r + " kilograms AHAHAHAHAHA");
    }
}
