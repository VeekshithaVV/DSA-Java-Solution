//Print subarray with maximum subarray sum (extended version of above problem)
package F_Array.B_Medium_Array;

import java.util.Arrays;
import java.util.Scanner;
public class E_Print_Subarray_with_Max_Sum {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the array size:");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for(int i=0; i<n; i++){
            arr[i] = input.nextInt();
        }
        int[] res = optimal(arr, n);
        System.out.println("Max Sum Subarray:");
        int sum = 0;
        for(int num : res){
            System.out.print(num +" ");
            sum+= num;
        }
        System.out.println();
        System.out.println("Max Sum: "+sum);
    }
    //Optimal
    public static int[] optimal(int[] arr, int n){
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int start = 0;
        int ansStart = -1;
        int ansEnd = -1;
        for(int i=0; i<n; i++){
            if(currentSum == 0){
                start = i;
            }
            currentSum += arr[i];
            if(currentSum > maxSum){
                maxSum = currentSum;
                ansStart = start;
                ansEnd = i;
            }
            if(currentSum < 0){
                currentSum = 0;
            }
        }
        return Arrays.copyOfRange(arr, ansStart, ansEnd+1);
        //return new int[]{ansStart, ansEnd};

    }
}

//OUTPUT
/*
Enter the array size:6
Enter the array elements:
2 3 5 -2 7 -4
Max Sum Subarray:
2 3 5 -2 7
Max Sum: 15
*/
//-----------------------------------------------------------------------------------------------------------
/*
Time Complexity : O(N)
Space Complexity : O(N)
*/