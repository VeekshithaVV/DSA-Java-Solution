////Pattern-1: Rectangular Star Pattern

package Patterns_01;

import java.util.*;
public class Pattern01 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the value of N:");
        int N = input.nextInt();
        print_pattern01(N);
    }
    public static void print_pattern01(int n){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

//OUTPUT
/*
Enter the value of N:5
*****
*****
*****
*****
*****
*/