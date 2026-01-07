//First & Last Occurence Position Element
package G_Binary_Search.A_BS_on_1D_Array;

import java.util.*;
public class F_First_Last_Position_Ele {
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
        //int index[] = find(arr,n,target);
        int index[] = findFirstLast(arr,n,target);
        System.out.println("First Occurence Index:"+index[0]);
        System.out.println("Last Occurence Index:"+index[1]);
        
    }
    //Linear
    public static int[] find(int[] arr , int n , int target){
        int first = -1, last = -1;
        for(int i=0; i<n; i++){
            if(arr[i] == target){
                if(first == -1){
                    first = i;
                }
                last = i;
            }
        }
        return new int[] {first,last};
    }
    //Binary
    public static int[] findFirstLast(int[] arr,int n,int target){
        int first = findBound(arr, target, true);
        if (first == -1) return new int[] {-1, -1}; // target not found
        int last = findBound(arr, target, false);
        return new int[] {first, last};
    }
    private static int findBound(int[] arr, int target, boolean isFirst) {
        int left = 0, right = arr.length - 1;
        int bound = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                bound = mid;
                if (isFirst) {
                    right = mid - 1; // look left
                } else {
                    left = mid + 1;  // look right
                }
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return bound;
    }
}

//OUTPUT
/*
Enter the array size:6
Enter the sorted array elements:
1 2 3 4 4 4
Enter the target element:4
First Occurence Index:3
Last Occurence Index:5
*/
//---------------------------------------------------------------------------------------------------------
