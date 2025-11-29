//Print N to 1 using Recursion
package C_Basic_Recursion_03;

import java.util.*;

public class C_Print_Nto1 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number:");
        int num = input.nextInt();
        print_number(1,num);
    }
    //BackTracing
    public static void print_number(int i , int n){
        if( i > n){
            return;
        }
        print_number(i+1,n);
        System.out.print(i+" ");
    }
}

//OUTPUT
/*
Enter the number:5
5 4 3 2 1 
*/
//-----------------------------------------------------------------------------------------------------
