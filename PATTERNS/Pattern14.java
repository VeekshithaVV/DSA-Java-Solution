//Pattern-14: Increasing Letter Triangle Pattern
package PATTERNS;

import java.util.*;
public class Pattern14 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the N:");
        int n = input.nextInt();
        print_pattern14(n);
    }
    public static void print_pattern14(int n){
        for(int i=0; i<n; i++){
            for(char ch = 'A'; ch <='A' + i; ch++){
                System.out.print(ch+" ");
            }
            System.out.println();
        }
    }
}

//OUTPUT
/*
Enter the N:5
A 
A B
A B C
A B C D
A B C D E
*/