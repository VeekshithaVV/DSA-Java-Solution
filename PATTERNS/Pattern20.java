//Pattern - 20: Symmetric-Butterfly Pattern
package PATTERNS;

import java.util.*;
public class Pattern20 {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the n:");
        int n = input.nextInt();
        print_pattern20(n);
    }
    public static void print_pattern20(int n){
        int initial_space = 2 * n - 2;
        for(int i=1; i<=2*n-1; i++){
            int star = i; //Initial stars are same as row number
            if(i > n){
                star = 2 * n - i;
            }
            //STAR
            for(int j=1; j<=star;j++){
                System.out.print("*");
            }
            //SPACE
            for(int j=1; j<=initial_space; j++){
                System.out.print(" ");
            }
            //STAR
            for(int j=1; j<=star; j++){
                System.out.print("*");
            }
            System.out.println();
            if(i < n){
                initial_space -= 2;
            }
            else{
                initial_space += 2;
            }
        }
    }
}

//OUTPUT
/*
Enter the n:5
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