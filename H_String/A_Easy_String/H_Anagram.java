//Anagram

package H_String.A_Easy_String;

import java.util.*;
public class H_Anagram {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the s1:");
        String s1 = input.next();
        System.out.print("Enter the s2:");
        String s2 = input.next();
        input.close();

        //boolean res = brute(s1,s2);
        boolean res = optimal(s1,s2);

        System.out.println(res);
    }
    //Brute
    public static boolean brute(String s1 , String s2){
        int len1 = s1.length();
        int len2 = s2.length();

        if(len1 != len2){
            return false;
        }

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);

        for(int i=0; i<c1.length; i++){
            if(c1[i] != c2[i]){
                return false;
            }
        }
        return true;
    }

    //Optimal
    public static boolean optimal(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }
        /*
        int[] count = new int[26];
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
            count[t.charAt(i)-'a']--;
        }
        for(int c:count){
            if(c!=0) return false;
        }
        return true;
        */

        HashMap<Character,Integer> map = new HashMap<>();

        for(int i=0; i<s1.length(); i++){
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);

            map.put(ch1,map.getOrDefault(ch1,0)+1);
            map.put(ch2,map.getOrDefault(ch2,0)-1);
        }
        for(int count : map.values()){
            if(count != 0){
                return false;
            }
        }
        return true;
    }
}

//OUTPUT
/*
Enter the s1:anagram
Enter the s2:gramana
true
*/

//--------------------------------------------------------------------------------------------------------------------------

/*
Brute:
TC:- O(N log N)
SC:- O(N)

Optimal:
TC:- O(N)
SC:- O(K) No. of distic char
*/