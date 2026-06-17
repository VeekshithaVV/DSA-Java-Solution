//Rotate String
package H_String.A_Easy_String;

import java.util.*;
public class F_Rotate_String {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the string:");
        String s = input.next();
        System.out.print("Enter the goal string:");
        String goal = input.next();
        input.close();

        //boolean val = brute(s,goal);
        boolean val = optimal(s,goal);

        System.out.println(val);
    }
    //Brute
    public static boolean brute(String s , String goal){
        if(s.length() != goal.length()){
            return false;
        }

        for(int i=0; i<s.length();i++){
            //String.substring(start index, end index) -> if only start index/1 index then end indx will be last index
            String rotated = s.substring(i) + s.substring(0,i);
            if(rotated.equals(goal)){
                return true;
            }
        }
        return false;
    }
    //Optimal
    public static boolean optimal(String s , String goal){
        if(s.length() != goal.length()){
            return false;
        }
        String doubleString = s + s;
        return doubleString.contains(goal);
    }
}

//OUTPUT
/*
Enter the string:abcde
Enter the goal string:cdeab
true
*/

//----------------------------------------------------------------------------------------------------------------------------------
/*
Brute:
TC:- O(N^2)
SC:- O(N)

Optimal:
TC:- O(N)
SC:- O(N)
*/
