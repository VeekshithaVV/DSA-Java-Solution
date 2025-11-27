//Pattern-15: Reverse Letter Triangle Pattern
package Patterns_01;

import java.util.*;
public class Pattern15 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the value of N:");
        int N = input.nextInt();
        print_pattern15(N);
    }
    public static void print_pattern15(int n){
        for(int i=n-1; i>=0; i--){
            for(char ch = 'A'; ch <='A'+i; ch++){
                System.out.print(ch+" ");
            }
            System.out.println();
        }
    }
}

//OUTPUT
/*
Enter the value of N:5
A B C D E 
A B C D
A B C
A B
A
*/