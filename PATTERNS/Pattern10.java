//Pattern - 10: Half Diamond Star Pattern
package PATTERNS;

import java.util.*;
public class Pattern10 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the n:");
        int n = input.nextInt();
        print_pattern10(n);
    }
    public static void print_pattern10(int n){
        for(int i=1; i<=2*n-1; i++){
            int star = i;
            if(star > n){
                star = 2 * n - i;
            }
            for(int j=0; j<star; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}

//OUTPUT
/*
Enter the n:5
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