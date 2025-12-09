//Count Subarray sum equals K
package F_Array.B_Medium_Array;

import java.util.*;
public class O_Subarray_Sum_Equals_K {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the array size:");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for(int i=0; i<n; i++){
            arr[i] = input.nextInt();
        }
        System.out.print("Enter the k :");
        int k = input.nextInt();

        //int count = brute(arr,n,k);
        int count = optimal(arr,n,k);
        System.out.println("Total Count: "+count);
    }
    //Brute
    public static int brute(int[] arr , int n , int k){
        int count = 0;
        for(int i=0; i<n; i++){
            int sum = 0;
            for(int j=i; j<n; j++){
                sum += arr[j];
                if(sum == k){
                    count++;
                }
            }
        }
        return count;
    }
    //Optimal
    public static int optimal(int[] arr , int n, int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        int preSum = 0;
        int count = 0;
        map.put(0,1);
        for(int num : arr){
            preSum += num;
            int remain = preSum - k; //Not K - presum
            if(map.containsKey(remain)){
                count += map.get(remain);
            }
            map.put(preSum, map.getOrDefault(preSum, 0)+1);
        }
        return count;
    }
}


//OUTPUT
/*
Enter the array size:10
Enter the array elements:
1 2 3 -3 1 1 1 4 2 -3
Enter the k :3
Total Count: 8
*/
//-------------------------------------------------------------------------------------------------------------------
/*
Brute:
Time Complexity : O(N^2)
Space Complexity : O(1)

Optimal:
Time Complexity : O(N) + O(N)
Space Complexity : O(N)
*/