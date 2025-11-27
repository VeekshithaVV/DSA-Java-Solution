//Pattern - 17: Alpha-Hill Pattern
package Patterns_01;

import java.util.*;
public class Pattern17 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the value of N:");
        int N = input.nextInt();
        print_pattern17(N);
    }
    public static void print_pattern17(int n){
        for(int i=0; i<n; i++){
            //SPACE
            for(int j=0; j<n - i- 1; j++){
                System.out.print(" ");
            }
            //LETTER
            char ch = 'A';
            int break_point = (2 * i + 1)/2;
            for(int j=1; j<=2 * i + 1; j++){
                System.out.print(ch);
                if(j <= break_point){
                    ch++;
                }
                else{
                    ch--;
                }
            }
            //SPACE
            for(int j=0; j<n - i- 1; j++){
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}

//OUTPUT
/*
Enter the value of N:5
    A    
   ABA
  ABCBA
 ABCDCBA
ABCDEDCBA
*/