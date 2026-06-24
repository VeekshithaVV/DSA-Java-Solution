//Sort Characters By Frequency

package H_String.B_Medium_String;

import java.util.*;
public class A_Sort_Char_Freq {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the string:");
        String s = input.next();
        input.close();

        //String res = brute(s);
        //String res = better(s);
        String res = optimal(s);

        System.out.println("Sorted String:"+res);
    }
    //Brute
    public static String brute(String str){
        //128 - (a-z,A-Z,0-9)
        int[] freq = new int[128];
        for(char ch : str.toCharArray()){
            freq[ch]++;
        }
        StringBuilder ans = new StringBuilder();
        while(true){
            int maxFreq = 0;
            int index = -1;
            for(int i=0; i<128; i++){
                if(freq[i] > maxFreq){
                    maxFreq = freq[i];
                    index = i;
                }
            }
            if(maxFreq == 0){
                break;
            }
            for(int i=0; i<maxFreq;i++){
                ans.append((char)index);
            }
            freq[index] = 0;
        }
        return ans.toString();
    }
    //Better
    public static String better(String str){
        HashMap<Character,Integer> map = new HashMap<>();

        //Traverse string and store frequencies.
        for(char ch : str.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }

        //Put all unique characters into a list.
        List<Character> list = new ArrayList<>(map.keySet());

        //Sort characters based on frequency in descending order.
        list.sort((a,b) -> map.get(b) - map.get(a));

        StringBuilder ans = new StringBuilder();
        for(char ch : list){
            int count = map.get(ch);

            while(count > 0){
                ans.append(ch);
                count--;
            }
        }
        return ans.toString();
    }
    //Optimal
    public static String optimal(String str){
        HashMap<Character,Integer> map = new HashMap<>();

        //Traverse string and store frequencies.
        for(char ch : str.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }

        //Create bucket array of size n+1.
        List<Character>[] bucket = new ArrayList[str.length() + 1];

        //Put characters into bucket according to frequency.
        for(char ch : map.keySet()){
            int freq = map.get(ch);

            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(ch);
        }
        StringBuilder res = new StringBuilder();

        //Traverse bucket from high frequency to low.
        for(int freq = bucket.length-1; freq>=1; freq--){
            if(bucket[freq] == null){
                continue;
            }
            //Append characters frequency times.
            for(char ch : bucket[freq]){
                for(int i=0; i<freq; i++){
                    res.append(ch);
                }
            }
        }
        return res.toString();
    }
}

//OUTPUT
/*
Enter the string:tree
Sorted String:eert
*/

//-------------------------------------------------------------------------------------------------------------------------------------------------------
/*
Brute:
TC:- O(N + K^2) ~ O(N)  //k=128
SC:- O(K)

Better:
TC:- O(N + K log K) -> hash map , sort ,ans
SC:- O(K)

Optimal:
TC:-
SC:-
*/