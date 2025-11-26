//Pattern-1: Rectangular Star Pattern
package PATTERNS;

import java.util.*;
public class Pattern1 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the n:");
        int n = input.nextInt();
        print_pattern1(n);
    }
    public static void print_pattern1(int n){
        for(int i=0; i<n; i++){
            for(int j = 0; j<n; j++) {
                System.out.print("* ");
            } 
            System.out.println();    
        }
    }

}

//OUTPUT
/* Enter the n:4
* * * * 
* * * *
* * * *
* * * * */