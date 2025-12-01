//Print Fibonacci Series up to Nth term
package C_Basic_Recursion_03;

import java.util.*;
public class H_Fibonnaci_Number {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number:");
        int n = input.nextInt();
        //int res = brute(n);
        int res = fib(n);
        System.out.println("Fibonacci of "+n+" is "+res);
    }
    //Brute
    public static int brute(int n){
        if(n <= 1){
            return n;
        }
        int last = 1;
        int secLast = 0;
        for(int i=2; i<=n; i++){
            int cur = last + secLast;
            secLast = last;
            last = cur;
        }
        return last;
    }
    //Recursive
    public static int fib(int n){
        if(n<= 1){
            return n;
        }
        return fib(n-1) + fib(n-2);
    }
}

//OUTPUT
/*
Enter the number:4
Fibonacci of 4 is 3
*/
//----------------------------------------------------------------------------------------------------------

/*
Brute:
Time Complexity : O(N)
Space Complexity : O(1)

Recursive:
Time Complexity : O(2^n)
Space Compexity : O(N)
*/