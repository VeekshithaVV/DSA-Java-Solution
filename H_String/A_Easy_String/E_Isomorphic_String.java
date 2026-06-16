//Isomorphic String
package H_String.A_Easy_String;

import java.util.*;
public class E_Isomorphic_String {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the S:");
        String S = input.next();
        System.out.print("Enter the T:");
        String T = input.next();
        input.close();

        System.out.println(isIsomorphic(S,T));
    }
    public static boolean isIsomorphic(String s, String t){
        int[] mapS = new int[256];
        int[] mapT = new int[256];

        for (int i = 0; i < s.length(); i++) {
            if (mapS[s.charAt(i)] != mapT[t.charAt(i)]){
                 return false;
            }
               
            mapS[s.charAt(i)] = i + 1;
            mapT[t.charAt(i)] = i + 1;
        }

        return true;
    }
}

//OUTPUT
/*
Enter the S:egg
Enter the T:bss
true
*/

//----------------------------------------------------------------------------------------------------------------------------
/*
TC:O(N)
SC:O(1)
*/