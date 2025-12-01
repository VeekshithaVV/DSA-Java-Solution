//Find the highest/lowest frequency element
package D_Basic_Hash;

import java.util.*;
public class B_High_Low_Freq {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the array size:");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for(int i=0; i<n; i++){
            arr[i] = input.nextInt();
        }
        high_and_low_freq(n,arr);
    }
    public static void high_and_low_freq(int n , int[] arr){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : arr){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        int lowest_key = Integer.MAX_VALUE;
        int lowest_freq = Integer.MAX_VALUE;

        int highest_key = Integer.MIN_VALUE;
        int highest_freq = Integer.MIN_VALUE;

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();

            if(value < lowest_freq || (value == lowest_freq && key < lowest_key)){
                lowest_freq = value;
                lowest_key = key;
            }

            if(value > highest_freq || (value == highest_freq && key > highest_key)){
                highest_freq = value;
                highest_key = key;
            }
        }
        System.out.println("Lowest frequency key is:"+lowest_key);
        System.out.println("Highest frequency key is:"+highest_key);
    }
}

//OUTPUT
/*
Enter the array size:6
Enter the array elements:
10
5
10
15
10
5
Lowest frequency key is:15
Highest frequency key is:10
*/
//--------------------------------------------------------------------------------------------------------------------

/*
Time Complexity : O(N)
Space Complexity : O(N)
*/