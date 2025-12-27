//Largest Subarray with sum 0
package F_Array.C_Hard_Array;

import java.util.*;
public class E_Largest_Subarray_With_0Sum {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the array size:");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for(int i=0; i<n; i++){
            arr[i] = input.nextInt();
        }
        //int result = brute(arr,n);
        int result = optimal(arr,n);
        System.out.println("Longest Subarray length:" + result);
    }
    public static int brute(int[] arr , int n){
        int maxLen = 0;
        for(int i=0; i<n; i++){
            int sum = 0;
            for(int j=i; j<n; j++){
                sum += arr[j];
                if(sum == 0){
                    maxLen = Math.max(maxLen , j - i + 1);
                }
            }
        }
        return maxLen;
    }
    //Optimal
    public static int optimal(int[] arr , int n){
        HashMap<Integer,Integer> map = new HashMap<>();
        int maxLen = 0;
        int sum = 0;
        for(int i=0; i<n; i++){
            sum += arr[i];
            if(sum == 0){
                maxLen = i + 1;
            }
            else{
                if(map.containsKey(sum)){
                    maxLen = Math.max(maxLen,  i - map.get(sum));
                }
                else{
                    map.put(sum , i);
                }
            }
        }
        return maxLen;
    }
}

//OUTPUT
/*
Enter the array size:8
Enter the array elements:
6 -2 2 -8 1 7 4 -10
Longest Subarray length:8
*/
//-------------------------------------------------------------------------------------------------------------
/*
Brute:
Time Complexity : O(N^2)
Space Complexity : O(1)

Optimal:
Time Complexity : O(N)
Space Complexity : O(N)
*/