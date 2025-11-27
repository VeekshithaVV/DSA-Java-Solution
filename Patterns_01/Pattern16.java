//Pattern - 16: Alpha-Ramp Pattern
package Patterns_01;

import java.util.*;
public class Pattern16 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the value of N:");
        int N = input.nextInt();
        print_pattern16(N);
    }
    public static void print_pattern16(int n){
        for(int i=0; i<n; i++){
            char ch = (char) ('A' + i);
            for(int j=0; j<=i; j++){
                System.out.print(ch+" ");
            }
            System.out.println();
        }
    }
}

//OUTPUT
/*
Enter the value of N:5
A 
B B
C C C
D D D D
E E E E E
*/