//Pattern-19: Symmetric-Void Pattern
package PATTERNS;

import java.util.*;
public class Pattern19 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the n:");
        int n = input.nextInt();
        print_pattern19(n);
    }
    public static void print_pattern19(int n){
        //UPPER HALf
        int initial_space = 0;
        for(int i=0; i<n;i++){
            //STAR
            for(int j=1; j<=n-i;j++){
                System.out.print("*");
            }
            //SPACE
            for(int j=0; j<initial_space; j++){
                System.out.print(" ");
            }
            //STAR
            for(int j=1; j<=n-i; j++){
                System.out.print("*");
            }
            initial_space += 2;
            System.out.println();
        }
        //LOWER HALF
        initial_space = 2 * n - 2;
        for(int i=1; i<=n; i++){
            //STAR
            for(int j=1; j<=i; j++){
                System.out.print("*");
            }
            //SPACE
            for(int j=0; j<initial_space; j++){
                System.out.print(" ");
            }
            //STAR
            for(int j=1; j<=i; j++){
                System.out.print("*");
            }
            initial_space -= 2;
            System.out.println();
        }
    }

}

//OUTPUT
/*
Enter the n:5
**********
****  ****
***    ***
**      **
*        *
*        *
**      **
***    ***
****  ****
**********
*/