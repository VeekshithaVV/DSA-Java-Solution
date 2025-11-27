//Symmetric-Butterfly Pattern
package Patterns_01;

import java.util.*;
public class Pattern20 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the value of N:");
        int N = input.nextInt();
        print_pattern20(N);
    }
    public static void print_pattern20(int n){
        int initial_space = 2 * n - 2;
        for(int i=1; i<= 2 * n - 1; i++){
            int star = i; //initial stars are same as row size
            if( i > n){
                star = 2 * n - i;
            }
            //STAR
            for(int j=1; j<= star; j++){
                System.out.print("*");
            }
            //SPACE
            for(int j=1; j<=initial_space; j++){
                System.out.print(" ");
            }
            //STAR
            for(int j=1; j<= star; j++){
                System.out.print("*");
            }
            if( i < n){
                initial_space -= 2;
            }
            else{
                initial_space += 2;
            }
            System.out.println();
        }
    }
}

//OUTPUT
/*
Enter the value of N:5
*        *
**      **
***    ***
****  ****
**********
****  ****
***    ***
**      **
*        *
*/