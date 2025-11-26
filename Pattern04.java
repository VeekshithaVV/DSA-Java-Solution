//Pattern - 4: Right-Angled Number Pyramid - II
package PATTERNS;

import java.util.*;
public class Pattern04 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the n:");
        int n = input.nextInt();
        print_pattern4(n);
    }
    public static void print_pattern4(int n){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}

//OUTPUT
/*
Enter the n:5
1 
2 2 
3 3 3 
4 4 4 4 
5 5 5 5 5 */
