//Print 1 to N using Recursion
package C_Basic_Recursion_03;

import java.util.*;
public class B_Print_1toN {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the n:");
        int n = input.nextInt();
        print_number(1,n);
    }
    //Forword Recursive
    public static void print_number(int i, int num){
        if(i > num){
            return;
        }
        System.out.print(i+" ");
        print_number(i+1, num);
    }
}

//OUTPUT
/*
Enter the n:5
1 2 3 4 5 
*/
//--------------------------------------------------------------------------------------------------------
/*

Time Complexity : O(N)
Space Complexity : O(N)

*/