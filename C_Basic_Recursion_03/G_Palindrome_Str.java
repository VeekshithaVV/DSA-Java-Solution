//Check if the given String is Palindrome or not
package C_Basic_Recursion_03;

import java.util.*;
public class G_Palindrome_Str {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the string:");
        String word = input.nextLine();
        check_Palindrome(0,word);    
    }
    public static void check_Palindrome(int i , String word){
        if(i >= word.length()/2){
            System.out.println(word+" is palindrome!!");
            return;
        }
        if(word.charAt(i) != word.charAt(word.length()-i-1)){
            System.out.println(word+" is not a palindrome!!");
            return;
        }
        check_Palindrome(i+1, word);
        return;
    }
}

//OUTPUT
/*
Enter the string:malayam
malayam is not a palindrome!!

Enter the string:madam
madam is palindrome!!
*/
//--------------------------------------------------------------------------------------------------------------------
/*
Time Complexity : O(N/2)
Space Comeplexity : O(N/2)
*/