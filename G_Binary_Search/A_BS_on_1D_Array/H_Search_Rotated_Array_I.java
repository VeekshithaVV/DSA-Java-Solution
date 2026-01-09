//Search Element in a Rotated Sorted Array
package G_Binary_Search.A_BS_on_1D_Array;

import java.util.*;
public class H_Search_Rotated_Array_I {
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

        //int index = brute(arr,n, target);
        int index = optimal(arr,n,target);

        System.out.println("Index :"+index);
    }
    //Brute
    public static int brute(int[] arr , int n , int target) {
        int index = -1;
        for(int i=0; i<n; i++){
            if(arr[i] == target){
                index = i;
                break;
            }
        }
        return index;
    }
    //Optimal
    public static int optimal(int[] arr , int n , int target){
        int index = -1;
        int low = 0,high = n-1;
        while(low <= high){
            int mid = low + (high - low )/2;
            if(arr[mid] == target){
                index = mid;
                break;
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
        return index;
    }
}

//OUTPUT
/*
Enter the arra size:9
Enter the array elements:
7 8 9 1 2 3 4 5 6
Enter the target :1
Index :3
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