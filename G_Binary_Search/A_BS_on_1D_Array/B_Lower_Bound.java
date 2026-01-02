//Lower Bound - smallest index, ind, where arr[ind] >= x. But if any such index is not found, the lower bound algorithm returns n i.e. size of the given array.
package G_Binary_Search.A_BS_on_1D_Array;

import java.util.*;
public class B_Lower_Bound{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the array size:");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the sorted array elements:");
        for(int i=0; i<n; i++){
            arr[i] = input.nextInt();
        }
        System.out.print("Enter the target element:");
        int target = input.nextInt();

        int index = lowerBound(arr,n,target);
        System.out.println(" Lower Bound index : "+ index);
    }
    public static int lowerBound(int[] arr , int n , int target){
        int low = 0 , high = n-1, ans = n;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] >= target){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
}

//OUTPUT
/*
Enter the array size:6
Enter the sorted array elements:
2 4 6 8 10 10
Enter the target element:10
Lower Bound index : 4
*/
//--------------------------------------------------------------------------------------------------------------------
/*
Time Complexity : O(log2 N)
Space Complexity : O(1)
*/