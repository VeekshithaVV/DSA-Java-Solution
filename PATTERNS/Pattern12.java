//Pattern - 12: Number Crown Pattern
package PATTERNS;

import java.util.*;
public class Pattern12 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the N:");
        int n = input.nextInt();
        print_pattern12(n);
    }
    public static void print_pattern12(int n){
        int spaces = 2 * (n-1);
        for(int i=1; i<=n; i++){
            //NUMBERS
            for(int j=1; j<=i; j++){
                System.out.print(j);
            }
            //SPACE
            for(int j=1; j<=spaces; j++){
                System.out.print(" ");
            }
            //NUMBERs
            for(int j=i; j>0;j--){
                System.out.print(j);
            }
            System.out.println();
            spaces -= 2;
        }
        
    }
}

//OUTPUT
/*
Enter the N:5
1        1
12      21
123    321
1234  4321
1234554321
*/
