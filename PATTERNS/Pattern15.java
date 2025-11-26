//Pattern-15: Reverse Letter Triangle Pattern
package PATTERNS;

import java.util.*;
public class Pattern15 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the n:");
        int n = input.nextInt();
        print_pattern15(n);
    }
    public static void print_pattern15(int n){
        for(int i=n; i>0; i--){
            for(char ch = 'A'; ch <'A'+i; ch++){
                System.out.print(ch+" ");
            }
            System.out.println();
        }
    }
}

//OUTPUT
/*
Enter the n:5
A B C D E 
A B C D
A B C
A B
A
*/