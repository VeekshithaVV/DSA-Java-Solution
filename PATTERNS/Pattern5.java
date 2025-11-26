//Pattern-5: Inverted Right Pyramid
package PATTERNS;

import java.util.*;
public class Pattern5 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the value of n:");
        int n = input.nextInt();
        print_pattern5(n);
    }
    public static void print_pattern5(int n){
        for(int i=n; i>=1; i--){
            for(int j=1; j<=i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}

//OUTPUT
/*
Enter the value of n:5
* * * * * 
* * * *
* * *
* *
*
 */