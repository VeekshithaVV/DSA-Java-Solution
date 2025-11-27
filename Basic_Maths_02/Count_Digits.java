//Count digits in a number

package Basic_Maths_02;

import java.util.*;
public class Count_Digits{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number:");
        int num = input.nextInt();
        int count = countDigit(num);
        System.out.println("The number "+num+" has "+count+" digits");
        optimal_count(num);
    }
    public static int countDigit(int num){
        int count = 0;
        if( num < 10){
            return 1;
        }
        while( num > 0){
            int digit = num % 10;
            count++;
            num /= 10;
        }
        return count;
    }
    public static void optimal_count(int num){
        int count = (int) (Math.log10(num))+1;
        System.out.println(count);
    }
}

//OUTPUT
/*
Enter the number:1234
The number 1234 has 4 digits
4
*/
//------------------------------------------------------------------------------------------------

//Time Complexity : O(log10(n))  
//Space Complexity : 0(1);

//Optimal 
//Time Complexity : 0(1)
//Space Complexity : 0(1)