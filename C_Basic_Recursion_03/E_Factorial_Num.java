//Factorial of a Number : Iterative and Recursive
package C_Basic_Recursion_03;

import java.util.*;
public class E_Factorial_Num {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the n:");
        int n = input.nextInt();
        //int res = itterative(n);
        int res = fact(n);
        System.out.println("Factorial of "+n+" is "+res);
    }
    public static int itterative(int num){
        int fact = 1;
        for(int i=1; i<=num; i++){
            fact *= i;
        }
        return fact;
    }
    public static int fact(int num){
        if(num == 1){
            return 1;
        }
        return num * fact(num - 1);
    }
}

//OUTPUT
/*
Enter the n:5
Factorial of 5 is 120
*/
//------------------------------------------------------------------------------------------------------------

/*
Iterative
Time Complexity : O(N)
Space Complexity : O(1)

Recursive
Time Complxity : O(N)
Space Complexity : O(N)
*/
