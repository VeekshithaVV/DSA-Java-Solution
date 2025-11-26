//Pattern - 8: Inverted Star Pyramid
package PATTERNS;

import java.util.*;
public class Pattern08 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the value of N:");
        int n = input.nextInt();
        print_pattern8(n);
    }
    public static void print_pattern8(int n){
        for(int i=n-1; i>=0; i--){
            //SPACE
            for(int j=0; j<n-i+1; j++){
                System.out.print(" ");
            }
            //STAR
            for(int j=0; j<2*i+1; j++){
                System.out.print("*");
            }
            //SPACE
            for(int j=0; j<n-i+1; j++){
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}

//OUTPUT
/*
Enter the value of N:4   
  *******  
   *****
    ***
     *
*/