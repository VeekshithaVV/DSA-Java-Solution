//Count Number of Substrings
package H_String.B_Medium_String;

import java.util.Scanner;
public class C_Count_No_Substring {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the string:");
        String str = input.next();
        System.out.print("Enter the K:");
        int k = input.nextInt();
        input.close();

        System.out.println(brute(str,k));
    }
    //Brute
    public static int brute(String str, int k){
        int n = str.length();
        int count = 0;
        for(int i=0; i<n; i++){
            int[] freq = new int[26];
            int distict = 0;
            for(int j=i; j<n; j++){
                if(freq[str.charAt(j)-'a'] == 0){
                    distict++;
                }
                freq[str.charAt(j) - 'a']++;
                if(distict == k){
                    count++;
                }
            }
            
        }
        return count;
    }

}

//OUTPUT
/*
Enter the string:pqpqs
Enter the K:2
7
*/

//-------------------------------------------------------------------------------------------------------------
/*
TC:- O(N^2)
SC:- O(26) ~ O(1)
*/