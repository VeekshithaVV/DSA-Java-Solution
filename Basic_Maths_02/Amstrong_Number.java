//Check if a number is Armstrong Number or not
package Basic_Maths_02;

import java.util.*;
public class Amstrong_Number {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the Number:");
        int num = input.nextInt();
        if(num < 0){
            System.out.print("Not a Amstrong Number!!");
        }
        else if(num < 10){
            System.out.print("Amstrong Number!!");
        }
        else{
            int count = (int) (Math.log10(num))+1;
            int amstrong = check_Amstrong(num,count);
            if(num == amstrong){
                System.out.println("Amstrong Number!!");
            }
            else{
                System.out.println("Not an Amstrong Number!!");
            }
        }
    }
    public static int check_Amstrong(int num, int count){
        int sum = 0;
        while(num > 0){
            int digit = num % 10;
            int result = (int) Math.pow(digit, count);
            sum += result;
            num /= 10;
        }
        return sum;
    }
}

//OUTPUT
/*
Enter the Number:2
Amstrong Number!!

Enter the Number:153
Amstrong Number!!

Enter the Number:1234
Not an Amstrong Number!!

Enter the Number:-153
Not a Amstrong Number!!
*/