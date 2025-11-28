//Check if a number is Palindrome or Not
package Basic_Maths_02;

import java.util.*;
public class Palindrome {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number:");
        int N = input.nextInt();
        if(N < 10){
            System.out.println("Not a Palindrome Number!!");
        }
        else{
            int rev = reverseDigit(N);
            if(N == rev){
                System.out.println("Palindrome Number!!");
            }
            else{
                System.out.println("Not a Palindrome Number");
            }
        }
        
    }
    public static int reverseDigit(int num){
        int rev = 0;
        
        while(num > 0){
            int last_digit = num % 10;
            rev = (rev * 10) + last_digit;
            num /= 10;
        }
        return rev;
    }
}

//OUTPUT
/*
Enter the number:-45
Not a Palindrome Number!!

Enter the number:121
Palindrome Number!!

Enter the number:12345
Not a Palindrome Number
*/
//---------------------------------------------------------------------------------------------------------------------------

/*
Time Complexity : O(log10(N))
Space Complexity : O(1)
*/