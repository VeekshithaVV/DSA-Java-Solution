//Count the number of subarrays with given xor K
package F_Array.C_Hard_Array;

import java.util.*;
public class F_Count_Subarrays_with_XOR_K {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the array size:");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for(int i=0; i<n; i++){
            arr[i] = input.nextInt();
        }
        System.out.print("Enter the value of K:");
        int k = input.nextInt();

        //int count = brute(arr , n , k);
        int count = optimal(arr,n,k);
        System.out.println("Count of subarrays with XOR k:"+count);
    }
    //Brute
    public static int brute(int[] arr , int n , int k){
        int count = 0;
        for(int i=0; i<n; i++){
            int xor = 0;
            for(int j=i; j<n; j++){
                xor ^= arr[j];
                if(xor == k){
                    count++;
                }
            }
        }
        return count;
    }
    //Optimal
    public static int optimal(int[] arr , int n , int k){
        HashMap<Integer,Integer> freq = new HashMap<>();
        int prefixXor = 0;
        int count = 0;
        freq.put(0,1);
        for(int num : arr){
            prefixXor ^= num;
            int target = prefixXor ^ k;
            if(freq.containsKey(target)){
                count += freq.get(target);
            }
            freq.put(prefixXor , freq.getOrDefault(prefixXor,0)+1);
        }
        return count;
    }
}
//OUTPUT
/*
Enter the array size:6
Enter the array elements:
4 2 2 6 4 1
Enter the value of K:6
Count of subarrays with XOR k:4
*/
//----------------------------------------------------------------------------------------------------------------------
/*
Brute:
Time Complexity : O(N^2)
Space Complexity : O(1)

Optimal:
Time Complexity : O(N)
Space Complexity : O(N)
*/