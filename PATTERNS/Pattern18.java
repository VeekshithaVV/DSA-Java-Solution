//Pattern-18: Alpha-Triangle Pattern
package PATTERNS;

import java.util.*;
public class Pattern18 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the n:");
        int n = input.nextInt();
        print_pattern18(n);
    }
    public static void print_pattern18(int n){
        for(int i=n-1; i>=0; i--){
            char ch = (char) ('A'+i);
            for(int j=i; j<n; j++){
                System.out.print(ch+" ");
                ch++;
            }
            System.out.println();
        }
    }
}

//OUTPUT
/*
Enter the n:5
E 
D E
C D E
B C D E
A B C D E
*/