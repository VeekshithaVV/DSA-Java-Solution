//Pattern - 12: Number Crown Pattern
package Patterns_01;

import java.util.*;
public class Pattern12 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the value of N:");
        int N = input.nextInt();
        print_pattern12(N);
    }
    public static void print_pattern12(int n){
        int initial_space = 2 * (n-1);
        for(int i=1; i<=n; i++){
            //NUMBERs
            for(int j=1; j<=i; j++){
                System.out.print(j);
            }
            //SPACE
            for(int j=1; j<=initial_space; j++){
                System.out.print(" ");
            }
            //NUMBERs
            for(int j=i; j>=1; j--){
                System.out.print(j);
            }
            System.out.println();
            initial_space -= 2;
        }
    }
}

//OUTPUT
/*
Enter the value of N:5
1        1
12      21
123    321
1234  4321
1234554321
*/