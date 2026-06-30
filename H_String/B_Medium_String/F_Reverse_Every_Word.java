//Reverse Words in a String
package H_String.B_Medium_String;

import java.util.*;
public class F_Reverse_Every_Word {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the statement:");
        String statement = input.nextLine();
        input.close();

        //String res = brute(statement);
        String res = optimal(statement);

        System.out.println("Reversed:"+res);
    }
    //Brute
    public static String brute(String str){
        // \\s ->space,tab,new line etc ,+ one or more occurence
        String[] arr = str.trim().split(" \\s+");
        StringBuilder res = new StringBuilder();
        for(int i=arr.length-1; i>=0; i--){
            res.append(arr[i]);
            if(i != 0){
                res.append(" ");
            }
        }
        return res.toString();
    }
    //Optimal
    public static String optimal(String str){
        StringBuilder res = new StringBuilder();
        int i = str.length()-1;

        while(i >= 0){
            while(i>=0 && str.charAt(i) == ' '){
                i--;
            }
            int j = i;
            while(i>=0 && str.charAt(i) != ' '){
                i--;
            }
            if(j >= 0){
                res.append(str.substring(i+1,j+1)).append(" ");
            }
        }
        return res.toString().trim();
    }
}


//OUTPUT
/*
Enter the statement:  hello world
Reversed:hello world
*/

//-------------------------------------------------------------------------------------------------------------------------------

/*
Brute:
TC:- O(N)
SC:- O(N)

Optimal:
TC:-
SC:-
*/