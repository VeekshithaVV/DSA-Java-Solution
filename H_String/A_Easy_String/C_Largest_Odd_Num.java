//Largest Odd Number in String

package H_String.A_Easy_String;

import java.util.*;
public class C_Largest_Odd_Num {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number:");
        String num = input.next();
        input.close();;

        String largeOdd = largestOddNum(num);

        System.out.println("Largest Odd NUmber:"+largeOdd);
    }
    public static String largestOddNum(String num){
        for(int i=num.length()-1; i>=0; i--){
            int digit = num.charAt(i) - '0';

            if(digit % 2 == 1){
                return num.substring(0, i+1);
            }
        }
        return "";
    }
}
//OUTPUT
/*
Enter the number:52
Largest Odd NUmber:5
*/

//--------------------------------------------------------------------------------------------------------------
/*
TC:- O(N)
SC:- O(1)
*/