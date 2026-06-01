//A valid parentheses string that cannot be split into two non-empty valid parentheses strings.
// "(()())"  -> Primitive
// "()()"    -> Not Primitive

package H_String.A_Easy_String;

import java.util.Scanner;
import java.util.Stack;

public class A_Remove_Outermost_Parenthes {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the string:");
        String str = input.next();
        input.close();

        //String ans = brute(str);
        String ans = optimal(str);

        System.out.println("Valid Parentheses String:"+ ans);
    }

    //Brute
    public static String brute(String str){
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();

        for(char ch : str.toCharArray()){
            if(ch == '('){
                if(!st.isEmpty()){
                    ans.append(ch);
                }
                st.push(ch);
            }
            else{
                st.pop();
                if(!st.isEmpty()){
                    ans.append(ch);
                }
            }
        }
        return ans.toString();
        
    }
    //Optimal
    public static String optimal(String str){
        StringBuilder ans = new StringBuilder();
        int counter = 0;

        for(char ch : str.toCharArray()){
            if(ch == '('){
                if(counter > 0){
                    ans.append(ch);
                }
                counter++;
            }
            else{
                counter--;
                if(counter > 0){
                    ans.append(ch);
                }
            }
        }
        return ans.toString();
    }
}

//OUTPUT
/*
Enter the string:(()())(())             
Valid Parentheses String:()()()

Enter the string:(()
Valid Parentheses String:()
*/

//--------------------------------------------------------------------------------------------------------------
/*
Brute:
TC:O(N)
SC:O(N)

Optimal:
TC:O(N)
SC:O(1)
*/

