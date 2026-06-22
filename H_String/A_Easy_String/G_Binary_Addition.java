package H_String.A_Easy_String;

import java.util.*;
public class G_Binary_Addition {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the string 1:");
        String s1 = input.next();
        System.out.print("Enter the string 2:");
        String s2 = input.next();

        int i = s1.length() - 1;
        int j = s2.length() - 1;
        int carry = 0;
        StringBuilder res = new StringBuilder();

        while(i >= 0 || j >= 0 || carry != 0){
            int sum = carry;
            if(i >= 0){
                sum += s1.charAt(i) - '0';
                i--;
            }
            if(j >= 0){
                sum += s2.charAt(j) - '0';
                j--;
            }

            res.append(sum % 2);
            carry = sum / 2;
        }
        res.reverse();

        int k = 0;
        while(k < res.length()-1 && res.charAt(k)=='0'){
            k++;
        }

        System.out.println("Binary addition:"+ res.substring(k));

    }
}

//OUTPUT
/*
Enter the string 1:00100
Enter the string 2:010
Binary addition:110
*/

//-----------------------------------------------------------------------------------------------------------------------
/*
TC:- O(Max(i,j))
SC:- O(MAX(i,j))
*/