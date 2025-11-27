//Pattern - 10: Half Diamond Star Pattern
package Patterns_01;

import java.util.*;
public class Pattern10 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the N:");
        int N = input.nextInt();
        print_pattern10(N);
    }
    public static void print_pattern10(int n){
        for(int i=1; i<= 2*n-1; i++){
            int star = i;
            if(i > n){
                star = 2 * n - i;
            }
            for(int j=1; j<=star; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}

//OUTPUT
/*
Enter the N:5
* 
* * 
* * * 
* * * * 
* * * * * 
* * * *
* * *
* *
*
*/