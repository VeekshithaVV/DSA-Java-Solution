//Maximum Product Subarray
package F_Array.C_Hard_Array;

import java.util.*;
public class L_Max_Producr_Subarray {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the array size:");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for(int i=0; i<n; i++){
            arr[i] = input.nextInt();
        }
        //int count = brute(arr , n );
        int count = optimal(arr,n);
        System.out.println("Maximum Product:"+count);
    }
    //Brute
    public static int brute(int[] arr , int n){
        int ans = Integer.MIN_VALUE;
        for(int i=0; i<n-1; i++){
            int product = 1;
            for(int j=i; j<n;j++){
                product *= arr[j];
                ans = Math.max(ans , product);
            }
        }
        return ans;
    }
    //Optimal
    public static int optimal(int[] arr , int n){
        int prefix = 1 , sufix = 1;
        int ans = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            if(prefix == 0){
                prefix = 1;
            }
            if(sufix == 0){
                sufix = 1;
            }
            prefix *= arr[i];
            sufix *= arr[n - i - 1];
            ans = Math.max(ans , Math.max(prefix,sufix));
        }
        return ans;
    }
}

//OUTPUT
/*
Enter the array size:4
Enter the array elements:
2 3 -2 4
Maximum Product:6
*/
//----------------------------------------------------------------------------------------------------------------
/*
Brute :
Time Complexity : O(N^2)
Space Complexity : O(1)

Optimal:
Time Complexity : O(N)
Space Complexity : O(1)
*/