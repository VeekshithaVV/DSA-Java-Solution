//Pattern - 6: Inverted Numbered Right Pyramid
package PATTERNS;

import java.util.*;
public class Pattern6 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the n:");
        int n = input.nextInt();
        print_pattern6(n);
    }
    public static void print_pattern6(int n){
        for(int i=n; i>0; i--){
            for(int j=1; j<=i; j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}

//OUTPUT
/*
Enter the n:5
1 2 3 4 5 
1 2 3 4 
1 2 3 
1 2 
1 
 */