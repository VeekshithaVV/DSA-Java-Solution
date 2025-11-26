//Pattern - 16: Alpha-Ramp Pattern
package PATTERNS;

import java.util.*;
public class Pattern16 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the n:");
        int n = input.nextInt();
        print_pattern16(n);
    }
    public static void print_pattern16(int n){
        for(int i=0; i<=n; i++){
            for(int j=0; j<=i; j++){
                char ch = 'A';
                ch+=i;
                System.out.print(ch+" ");
            }
            System.out.println();
        }
    }
}

//OUTPUT
/*
Enter the n:5
A 
B B
C C C
D D D D
E E E E E 
F F F F F F
*/