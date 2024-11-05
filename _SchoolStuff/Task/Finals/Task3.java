package _SchoolStuff.Task.Finals;

import java.util.Scanner;
public class Task3 {
  public static void main(String[] args) {
    snakePattern();
    System.out.println();
    snakePatternArray();
  }
  
  static void snakePattern() {
    int num = 0;
    
    Scanner input = new Scanner (System.in);
    System.out.print("Enter a number: ");
    num = input.nextInt();
    int sq = num * num;
    
    int i = num;
    while (i > 0) {
      if (i % 2 == 0) {
        int j = 0;
        while(j<num) {
          System.out.print((sq - j) + "\t");
          j++;
        }
        sq = sq - num;
      }
      else {
        sq -= (num -1);
        int j = 0;
        while(j<num) {
          System.out.print((sq + j) + "\t" );
          j++;
        }
        sq--;
        
      }
      System.out.print("\n");
      i--;
    }
  }

  static void snakePatternArray() {
    int num = 0;
    
    Scanner input = new Scanner (System.in);
    System.out.print("Enter a number: ");
    num = input.nextInt();
    int sq = num * num;
    
  }
}