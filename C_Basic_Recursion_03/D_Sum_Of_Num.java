//Sum of first N Natural Numbers
package C_Basic_Recursion_03;

import java.util.*;
public class D_Sum_Of_Num {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number:");
        int n =input.nextInt();
        int sum = 0;
        //sum = brute(n);
        //sum = better(n);
        //sum = sum_of_num(n,sum);
        sum = sumOfNum(n);
        System.out.println("Sum of "+n+" natural number is: "+sum);
    }
    //BRUTE
    public static int brute(int num){
        int sum = 0;
        for(int i=1; i<=num; i++){
            sum += i;
        }
        return sum;
    }
    //BETTER (Formula)
    public static int better(int n){
        return n*(n+1)/2;
    }
    //OPTIMAL (Recursive)
    //Parameterised
    public static int sum_of_num(int num,int sum){
        if( num < 1 ){
            return sum;
        }
        return sum_of_num(num - 1, sum + num);
    }
    //Functional
    public static int sumOfNum(int num){
        if(num == 0){
            return 0;
        }
        return num + sumOfNum( num - 1);
    }
}

//OUTPUT
/*
Enter the number:5
Sum of 5 natural number is: 15
*/
//--------------------------------------------------------------------------------------------------------

/*
Brute:
Time Complexity : O(n)
Space Complexity : O(1)

Better
Time Complexity : O(1)
Space Complexity : O(1)

Optimal:
Time Complexity : O(n)
Space Complexity : O(n)
*/