//Binary Search
package G_Binary_Search.A_BS_on_1D_Array;

import java.util.*;
public class A_Binary_Search{
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

        //int index = binarySearch(arr,n,target);
        int index = bs(arr,0,n-1,target);
        if(index > -1){
            System.out.println(target+" Found in Index: "+ index);
        }
        else{
            System.out.println(" Not Found");
        }
    }
    //Interative
    public static int binarySearch(int[] arr , int n , int target){
        int low = 0 , high = n - 1;
        while(low  <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] == target){
                return mid;
            }
            else if(target > arr[mid]){
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1;
    }
    //Recursive
    public static int bs(int[] arr , int low , int high , int target){
        if(low > high){
            return -1;
        }
        int mid = low + (high - low)/2;
        if(arr[mid] == target){
            return mid;
        }
        else if(arr[mid] < target){
            return bs(arr, mid+1, high, target);
        }
        else{
            return bs(arr, low, mid-1, target);
        }
    }
}

//OUTPUT
/*
Enter the array size:8 
Enter the sorted array elements:
1 2 3 4 5 6 7 8
Enter the target element:4
4 Found in Index: 3
*/
//-------------------------------------------------------------------------------------------------------------------
/*
Time Complexity : O(Log2 N)
Space Complexity : O(1)
*/
