//Pattern - 21: Hollow Rectangle Pattern

package Patterns_01;

import java.util.*;
public class Pattern21{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the value of N:");
        int N = input.nextInt();
        print_pattern21(N);
    }
    public static void print_pattern21(int n){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==0 || i==n-1 || j==0 || j==n-1){
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
Enter the value of N:4
****
*  *
*  *
****
*/