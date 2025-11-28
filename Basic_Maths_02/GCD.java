//Find GCD/HCF of two numbers
package Basic_Maths_02;

import java.util.*;
public class GCD {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the value of num1 and num2:");
        int num1 = input.nextInt();
        int num2 = input.nextInt();
        //int gcd = brute(num1,num2);
        //int gcd = better(num1,  num2);
        int gcd = optimal(num1,num2);
        System.out.print("GCD of "+num1+" and "+num2+" is "+ gcd);
    }
    //BRUTE
    public static int brute(int num1, int num2){
        int min = Math.min(num1, num1);
        int gcd = 1;
        for(int i=1; i<=min; i++){
            if(num1 % i == 0 && num2 % i == 0){
                gcd = i;
            }
        }
        return gcd;
    }
    //BETTER
    public static int better(int num1 , int num2){
        int min = Math.min(num1, num2);
        for(int i=min; i>=1; i++){
            if(num1 % i == 0 && num2 % i == 0){
                return i;
            }
        }
        return 1;
    }
    //OPTIMAL - Euclidean Algorithm
    public static int optimal(int num1 , int num2){
        while(num1 > 0 && num2 > 0){
            if(num1 > num2){
                num1 = num1 % num2;
            }
            else{
                num2 = num2 % num1;
            }
        }
        if(num1 == 0){
            return num2;
        }
        return num1;
    }

}

//OUTPUT
/*
Enter the value of num1 and num2:
56
20
GCD of 56 and 20 is 1
*/
//-----------------------------------------------------------------------------------------------------------------------

/*
Brute & Better:
Time Complexity : O(log ^(min(num1,num2)))
Space Complexity : O(1)

Optimal:
Time Complexity : O(min(n1,n2))
Space Complexity : O(1)
*/