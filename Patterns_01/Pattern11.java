//Pattern - 11: Binary Number Triangle Pattern
package Patterns_01;

import java.util.*;
public class Pattern11 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the N:");
        int N = input.nextInt();
        print_pattern11(N);
    }
    public static void print_pattern11(int n){
        int start = 0;
        for(int i=0; i<n; i++){
            if(i % 2 == 0){
                start = 1;
            }
            else{
                start = 0;
            }
            for(int j=0; j<=i; j++){
                System.out.print(start+" ");
                start = 1 - start;
            }
            System.out.println();
        }
    }
}

//OUTPUT
/*
Enter the N:5
1 
0 1
1 0 1
0 1 0 1
1 0 1 0 1
*/