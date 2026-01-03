package G_Binary_Search.A_BS_on_1D_Array;

import java.util.Scanner;
public class C_Upper_Bound {
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

        int index = uperrBound(arr,n,target);
        System.out.println(" Upper Bound index : "+ index);
    }
    public static int uperrBound(int[] arr , int n , int target){
        int low = 0 , high = n-1, ans = n;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] > target){
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
1 3 5 7 9 10
Enter the target element:9
Upper Bound index : 5
*/
//--------------------------------------------------------------------------------------------------------------------
/*
Time Complexity : O(log2 N)
Space Complexity : O(1)
*/

