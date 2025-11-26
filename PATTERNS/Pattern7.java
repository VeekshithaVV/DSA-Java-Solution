//Pattern - 7: Star Pyramid
package PATTERNS;

import java.util.*;
public class Pattern7 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the value of N:");
        int n = input.nextInt();
        print_pattern7(n);
    }
    public static void print_pattern7(int n){
        for(int i=0; i<n; i++){
            //SPACE
            for(int j=0; j<n-i-1; j++){
                System.out.print(" ");
            }
            //STAR
            for(int j = 0; j<2*i+1; j++){
                System.out.print("*");
            }
            //SPACE
            for(int j=0; j<n-i-1; j++){
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}

//OUTPUT
/*
Enter the value of N:5
    *    
   ***   
  *****  
 ******* 
*********
*/