//Longest Subarray with K sum (Positives and Negatives)
package F_Array.A_Easy_Array;

import java.util.*;
import java.util.stream.IntStream.IntMapMultiConsumer;
public class O_Long_Subarray_with_K_Sum_P_N {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the array size:");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for(int i=0; i<n; i++){
            arr[i] = input.nextInt();
        }
        System.out.print("Enter the k sum:");
        int k = input.nextInt();
        //int longest = brute(arr,n,k);
        int longest = optimal(arr,n,k);
        System.out.println("Longest subarray length is:"+longest);
    }
    //Brute
    public static int brute(int[] arr , int n , int k){
        int maxLen = -1;
        for(int i=0; i<n; i++){
            int sum = 0;
            for(int j=i; j<n; j++){
                sum += arr[j];
                if(sum == k){
                    maxLen = Math.max(maxLen,(j-i+1));
                }
            }
        }
        return maxLen;
    }
    public static int optimal(int[] arr , int n , int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        int prefixSum = 0;
        int maxLen = 0;
        for(int i=0; i<n; i++){
            prefixSum += arr[i];
            //Case1:subarray from 0 to i having sum k
            if(prefixSum == k){
                maxLen = i + 1;
            }
            //Case2:subarray between 2 prefixsum
            if(map.containsKey(prefixSum - k)){
                int len = i - map.get(prefixSum - k);
                maxLen = Math.max(maxLen , len);
            }
            map.putIfAbsent(prefixSum,i);
        }
        return maxLen;
    }
}

//OUTPUT
/*
Enter the array size:5
Enter the array elements:
2 1 3 -1 1
Enter the k sum:5
Longest subarray length is:4
*/
//------------------------------------------------------------------------------------------------------------------
/*
Brute:
Time Complexity : O(N^2)
Space Complexity : O(1)

Optimal:
Time Complexity : O(N)
Space Complexity : O(N)
*/