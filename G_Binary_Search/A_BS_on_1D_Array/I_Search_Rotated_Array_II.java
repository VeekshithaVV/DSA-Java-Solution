//Search Element in a Rotated Sorted Array - Duplicates
package G_Binary_Search.A_BS_on_1D_Array;

import java.util.*;
public class I_Search_Rotated_Array_II {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the arra size:");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for(int i=0; i<n; i++){
            arr[i] = input.nextInt();
        }
        System.out.print("Enter the target :");
        int target = input.nextInt();

        //boolean res = brute(arr,n, target);
        boolean res = optimal(arr,n,target);

        System.out.println("Result :"+res);
    }
    //Brute
    public static boolean brute(int[] arr , int n , int target) {
        for(int i=0; i<n; i++){
            if(arr[i] == target){
                return true;
            }
        }
        return false;
    }
    //Optimal
    public static boolean optimal(int[] arr , int n , int target){
        int low = 0,high = n-1;
        while(low <= high){
            int mid = low + (high - low )/2;
            if(arr[mid] == target){
                return true;
            }
            if(arr[mid] == arr[low] && arr[low] == arr[high]){
                low = low + 1;
                high = high - 1;
                continue;
            }
            if(arr[low] <= arr[mid]){
                if(arr[low] <= target && target <= arr[mid]){
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }
            else{
                if(arr[mid] <= target && target <= arr[high]){
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }
        }
        return false;
    }
}

//OUTPUT
/*
Enter the array elements:
3 1 2 3 3 3 
Enter the target :2
Result :true
*/
//-----------------------------------------------------------------------------------------------------------------------------
/*
Brute:
Time Complexity : O(N)
Space Complexity : O(1)

Optimal:
Time Complexity : O(N log n)
SPace Complexity : O(1)
*/