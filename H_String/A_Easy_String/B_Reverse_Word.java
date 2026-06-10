//Reverse Words in a String
package H_String.A_Easy_String;

import java.util.*;
public class B_Reverse_Word {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the sentence:");
        String word = input.nextLine();

        //String rev = brute(word);
        String rev = optimal(word);
        
        System.out.println("Reverse:"+rev);
    }
    //Brute
    public static String brute(String word){
        /*
        String[] words = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i > 0) {
                sb.append(" ");
            }
        }

        return sb.toString();
        
        */

        List<String> list = new ArrayList<>();
        StringBuilder str = new StringBuilder();

        for(int i=0; i<word.length(); i++){
            if(word.charAt(i) != ' '){
                str.append(word.charAt(i));
            }
            else if(str.length() > 0){
                list.add(str.toString());
                str.setLength(0);
            }
        }
        if(str.length() > 0){
            list.add(str.toString());
        }
        Collections.reverse(list);

        return String.join(" ",list);
    }
    //Optimal
    public static String optimal(String str){
        StringBuilder res = new StringBuilder();
        int i=str.length()-1;

        while(i >= 0){
            while(i>=0 && str.charAt(i) == ' '){
                //Reduce leading space
                i--;
            }
            int j = i;

            while(i >= 0 && str.charAt(i) != ' '){
                i--;
            }
            if(j >= 0){
                res.append(str.substring(i+1, j+1)).append(" ");
            }
        }
        return res.toString();
    }
}
//OUTPUT
/*
Enter the sentence:the sky is blue
Reverse:blue is sky the
*/

//--------------------------------------------------------------------------------------------------------------------------------
/*
Brute:
TC:- O(N)
SC:- O(N)

Optimal:
TC:- O(N)
SC:- O(1)
*/