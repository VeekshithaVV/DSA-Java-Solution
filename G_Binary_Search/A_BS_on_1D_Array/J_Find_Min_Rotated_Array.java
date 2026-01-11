//Find the Minimum if Rotated Sorted Array
package G_Binary_Search.A_BS_on_1D_Array;

import java.util.Scanner;
public class J_Find_Min_Rotated_Array {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the arra size:");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for(int i=0; i<n; i++){
            arr[i] = input.nextInt();
        }
        
        //int mini = brute(arr,n);
        int mini = optimal(arr,n);

        System.out.println("Minimum Value :"+mini);
    }
    //Brute
    public static int brute(int[] arr , int n ) {
        int mini = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            if(arr[i] < mini){
                mini = arr[i];
            }
        }
        return mini;
    }
    //Optimal
    public static int optimal(int[] arr , int n){
        int low = 0 , high = n-1, ans = Integer.MAX_VALUE;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[low] <= arr[high]){
                ans = Math.min(ans,arr[low]);
                break;
            }
            else if(arr[low] <= arr[mid]){
                ans = Math.min(ans, arr[low]);
                low = mid + 1;
            }
            else{
                ans = Math.min(ans, arr[mid]);
                high = mid - 1;
            }
        }
        return ans;
    }
}

//OUTPUT
/*
Enter the arra size:6
Enter the array elements:
5 6 1 2 3 4 5
Minimum Value :1
*/
//---------------------------------------------------------------------------------------------------------------------
/*
Brute:
Time Complexity : O(N)
Space Complexity : O(1)

Optimal:
Time Complexity : O(N log n)
Space Compexity : O(1)
*/