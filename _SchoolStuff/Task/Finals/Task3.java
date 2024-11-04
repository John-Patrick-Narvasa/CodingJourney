package _SchoolStuff.Task.Finals;

/*1st case:
enter number: 4
output : 
16 15 14 13 
 9 10 11 12
 8 7 6 5
 1 2 3 4

 2nd case
enter number: 5
output : 
21 22 23 24 25 
20 19 18 17 16
11 12 13 14 15 
10 9 8 7 6 
1 2 3 4 5
		
*/


import java.util.Scanner;
public class Task3 {
  public static void main(String[] args) {

    snakePattern();
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
}


