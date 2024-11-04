package _SchoolStuff.Task.Midterms;

import java.util.Scanner;
public class SumOdd {

  public static void main(String[] args) {
    int n = 0, ctr = 1;
    int sq = 0, cb = 0;
    int totalSqr = 0, totalCb = 0;
    Scanner input = new Scanner (System.in);
    
    System.out.print("Enter number: ");
    n = input.nextInt();
    System.out.println();
    
    System.out.print("Number\tSquare\tCube");
    System.out.println("\n");
    
    while (ctr <= n ) {
      sq = ctr * ctr;
      cb = ctr * ctr * ctr;
      
      System.out.print(ctr);
      System.out.print("\t" + sq);
      totalSqr += sq;
      
      System.out.print("\t" + cb);
      totalCb += cb;
      
      System.out.println();
      ctr = ctr + 2;
    }
    System.out.println("\nTOTAL\t" + totalSqr + "\t" + totalCb);
    input.close();
  }
}

