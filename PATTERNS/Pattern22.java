//Pattern - 22: The Number Pattern
package PATTERNS;

import java.util.*;
public class Pattern22 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the n:");
        int n = input.nextInt();
        print_pattern22(n);
    }
    public static void print_pattern22(int n){
        for(int i=0; i<2*n-1; i++){
            for(int j=0; j<2*n-1; j++){
                int top = i;
                int bottom = (2 * n - 2) - i;
                int  left = j;
                int right = (2 * n - 2) - j;
                int minDist = Math.min(Math.min(top,bottom) , Math.min(left,right));

                System.out.print(n- minDist + " ");
            }
            System.out.println();
        }
    }
}

//OUTPUT
/*
Enter the n:4
4 4 4 4 4 4 4 
4 3 3 3 3 3 4
4 3 2 2 2 3 4
4 3 2 1 2 3 4 
4 3 2 2 2 3 4
4 3 3 3 3 3 4
4 4 4 4 4 4 4
*/