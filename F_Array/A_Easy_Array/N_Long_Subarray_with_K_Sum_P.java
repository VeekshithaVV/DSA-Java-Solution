//Longest Subarray with sum K(Positive)
package F_Array.A_Easy_Array;

import java.util.*;
public class N_Long_Subarray_with_K_Sum_P {
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
        //int longest = better(arr,n,k);
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
    //Better
    public static int better(int[] arr , int n,int k){
        HashMap<Integer,Integer> map  = new HashMap<>();
        int prefixSum = 0;
        int maxLen = 0;
        for(int i=0; i<n; i++){
            prefixSum += arr[i];
            //case1:subarray from 0 to i has k sum
            if(prefixSum == k){
                maxLen = i+1;
            }
            //case 2: Subarray between 2 prefix sum
            if(map.containsKey(prefixSum - k)){
                int len = i - map.get(prefixSum - k);
                maxLen = Math.max(maxLen,len);
            }
            map.putIfAbsent(prefixSum, i);
        }
        return maxLen;
    }
    //Optimal
    public static int optimal(int[] arr, int n, int k){
        int maxLen = 0;
        int left = 0;
        int right = 0;
        int sum = arr[0];
        while(right < n){
            //sum is exceeds K
            while(left <= right && sum > k){
                sum -= arr[left];
                left++;
            }
            //sum is equal to k
            if(sum == k){
                maxLen = Math.max(maxLen, right - left + 1);
            }
            //sum lessthan k
            right++;
            if(right < n){
                sum += arr[right];
            }
        }
        return maxLen;
    }
}

//OUTPUT
/*
Enter the array size:6
Enter the array elements:
1 1 3 2 1 2
Enter the k sum:5
Longest subarray length is:3

Enter the array size:5
Enter the array elements:
2 1 3 -1 1
Enter the k sum:5
Longest subarray length is:4
*/
//--------------------------------------------------------------------------------------------------------------
/*
Brute:
Time Complexity : O(N2)
Space Complexity : O(1)

Better:
Time Complexity : O(N)
Space Complexity : O(N)

Optimal:
Time Complexity : O(N)
Space Complexity : O(1)
*/