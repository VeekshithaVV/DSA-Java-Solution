//Kadane's Algorithm : Maximum Subarray Sum in an Array
package F_Array.B_Medium_Array;

import java.util.Scanner;
public class D_Max_Subarray_Sum {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the array size:");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for(int i=0; i<n; i++){
            arr[i] = input.nextInt();
        }
        //int maxSum = brute(arr,n);
        int maxSum = optimal(arr,n);
        System.out.println("Maximum sum: "+maxSum);
    }
    //Brute
    public static int brute(int[] arr, int n){
        int maxSum = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            int sum = 0;
            for(int j=i; j<n; j++){
                sum += arr[j];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
    //Optimal
    //Kadane's Algorithm
    public static int optimal(int[] arr, int n){
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int num : arr){
            currentSum += num;
            if(currentSum > maxSum){
                maxSum = currentSum;
            }
            if(currentSum < 0){
                currentSum = 0;
            }
        }
        return maxSum;
    }
}

//OUTPUT
/*
Enter the array size:6
Enter the array elements:
2 3 5 -2 7 -4
Maximum sum: 15
*/
//--------------------------------------------------------------------------------------------------------------
/*
Brute:
Time Complexity : O(N^2)
Space Complexity : O(1)

Optimal:
Time Complexity : O(N)
Space Complexity : O(1)
*/
