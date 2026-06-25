//Maximum Nesting Depth of the Parentheses
package H_String.B_Medium_String;

import java.util.*;
public class B_Max_Parenth_Depth {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the String:");
        String str = input.next();
        input.close();

        int parenth = 0;
        int ans = 0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '('){
                parenth++;
            }
            else if(str.charAt(i) == ')'){
                parenth--;
            }
            ans = Math.max(ans,parenth);
        }
        System.out.println("Max Depth:"+ans);
    }
}

//OUTPUT
/*
Enter the String:(1)+((2))+(((3)))
Max Depth:3
*/

//-----------------------------------------------------------------------------------------------------------
/*
TC:- O(N)
SC:- O(1)
*/