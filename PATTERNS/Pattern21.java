//Pattern - 21: Hollow Rectangle Pattern
package PATTERNS;

import java.util.*;
public class Pattern21 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the n:");
        int n = input.nextInt();
        print_pattern21(n);
    }
    public static void print_pattern21(int n){
        for(int i=1; i<= n; i++){
            for(int j=1; j<=n; j++){
                if(i==1 || i==n || j==1 || j ==n){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}

//OUTPUT
/*
Enter the n:5
*****
*   *
*   *
*   *
*****
*/