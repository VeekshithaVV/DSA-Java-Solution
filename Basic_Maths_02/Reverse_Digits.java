//Reverse Digits of A Number
package Basic_Maths_02;

import java.util.*;
public class Reverse_Digits {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number:");
        int num = input.nextInt();
        int rev = reverse_digit(num);
        System.out.println("Reverse number:"+rev);
    }
    public static int reverse_digit(int num){
        int reverse_number = 0;
        while(num > 0){
            int last_digit = num % 10;
            reverse_number = (reverse_number * 10)+ last_digit;
            num /= 10;
        }
        return reverse_number;
    }
}

//OUTPUT
/*
Enter the number:1234
Reverse number:4321
*/

//----------------------------------------------------------------------------------------------------------
//Time Complexity : O(log10 (N)) 
//Space Complexity : O(1)