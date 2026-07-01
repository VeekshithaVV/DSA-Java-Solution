//Sum of Beauty of All Substrings
package H_String.B_Medium_String;

import java.util.*;
public class E_Sum_Of_Beauty_Of_Substring {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the string:");
        String str = input.next();
        input.close();

        System.out.println(beautyString(str));
    }
    public static int beautyString(String str){
        int n = str.length();
        int sum = 0;
        for(int i=0; i<n; i++){
            HashMap<Character,Integer> map = new HashMap<>();
            for(int j=i; j<n; j++){
                map.put(str.charAt(j) , map.getOrDefault(str.charAt(j),0)+1);
                int maxi = Integer.MIN_VALUE;
                int mini = Integer.MAX_VALUE;

                for(int value : map.values()){
                    mini = Math.min(mini,value);
                    maxi = Math.max(maxi,value);
                }

                sum += (maxi-mini);
            }
        }
        return sum;

        /*
        USING FREQ ARRAY
        for(int i=0; i<n; i++){
            int[] freq = new int[26];
            for(int j=i; j<n; j++){
                freq[s.charAt(j) - 'a']++;

                int maxi = Integer.MIN_VALUE;
                int mini = Integer.MAX_VALUE;

                for(int val : freq){
                    if(val > 0){
                        maxi = Math.max(maxi,val);
                        mini = Math.min(mini,val);
                    }
                }
                ans += (maxi - mini);
            }
        }
        return ans;
        */
    }
}


//OUTPUT
/*
Enter the string:aabcb
5
*/

//-----------------------------------------------------------------------------------------------------

/*
TC:- O(N)
SC:- O(26) ~ O(1)
*/