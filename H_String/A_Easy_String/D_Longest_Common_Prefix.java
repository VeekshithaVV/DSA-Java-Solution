//Longest Common Prefix
package H_String.A_Easy_String;

import java.util.*;
public class D_Longest_Common_Prefix {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the array size:");
        int n = input.nextInt();
        String[] str = new String[n];
        System.out.println("Enter the strings:");
        for(int i=0; i<n; i++){
            str[i] = input.next();
        }
        input.close();

        //String prefix = brute(n,str);

        String prefix = optimal(n,str);
        System.out.println("Longest Prefix:"+prefix);
    }
    //Brute
    public static String brute(int n , String[] str){
        StringBuilder ans = new StringBuilder();
        Arrays.sort(str);

        String first = str[0];
        String last = str[n-1];

        for(int i=0; i<Math.min(first.length(),last.length()); i++){
            if(first.charAt(i) != last.charAt(i)){
                return ans.toString();
            }
            ans.append(first.charAt(i));
        }
        return ans.toString();
    }
    //Optimal
    public static String optimal(int n , String[] strs){
        if (strs == null || strs.length == 0) {
            return "";
        }

        for (int i = 0; i < strs[0].length(); i++) {
            char ch = strs[0].charAt(i);

            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != ch) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0];
    }
}

//OUTPUT
/*
Enter the array size:4   
Enter the strings:
flower
flow
flight
flag
Longest Prefix:fl
*/

//-----------------------------------------------------------------------------------------------------------------
/*
BRUTE:
TC:- O(N * log N + M)
SC:- O(M)

Optimal:
TC:- O(M * N)
SC:- O(1)
*/
