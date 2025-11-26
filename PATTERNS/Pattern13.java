//Pattern - 13: Increasing Number Triangle Pattern
package PATTERNS;

import java.util.*;
public class Pattern13 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the N:");
        int n = input.nextInt();
        print_pattern13(n);
    }
    public static void print_pattern13(int n){
        int num = 1;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                System.out.print(num+" ");
                num++;
            }
            System.out.println();
        }
    }
    
}

//OUTPUT
/*
Enter the N:5
1 
2 3
4 5 6
7 8 9 10
11 12 13 14 15
*/
