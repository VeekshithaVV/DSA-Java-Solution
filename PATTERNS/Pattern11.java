//Pattern - 11: Binary Number Triangle Pattern
package PATTERNS;

import java.util.*;
public class Pattern11 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the value of n:");
        int n = input.nextInt();
        print_pattern11(n);
    }
    public static void print_pattern11(int n){
        for(int i=0; i<n; i++){
            int start = 1;
            if(i % 2 == 0){
                start = 1;
            }
            else {
                start = 0;
            }
            for(int j=0; j<=i; j++){
                System.out.print(start+" ");
                start = 1 - start;  //FLIP THE NUMBER
            }
            System.out.println();
        }
        
    }
}

//OUTPUT
/*
Enter the value of n:5
1 
0 1 
1 0 1 
0 1 0 1 
1 0 1 0 1 
*/