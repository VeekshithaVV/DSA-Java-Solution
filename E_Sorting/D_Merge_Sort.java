//MERGE SORT
package E_Sorting;

import java.util.*;
public class D_Merge_Sort {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the array size:");
        int size = input.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter the array elements:");
        for(int i=0; i<size; i++){
            arr[i] = input.nextInt();
        }
        merge_sort(arr,0,size-1);
        System.out.println("After Sort:");
        for(int num : arr){
            System.out.print(num+" ");
        }
    }
    public static void merge_sort(int[] arr, int low, int high){
        if( low >= high){
            return;
        }
        int mid = (low + high) / 2;
        merge_sort(arr, low, mid);
        merge_sort(arr, mid+1, high);
        merge(arr,low,mid,high);
    }
    public static void merge(int[] arr, int low , int mid , int high){
        int[] temp = new int[high - low + 1];
        int index = 0;
        int left = low;
        int right = mid+1;
        while(left <= mid && right <= high){
            if(arr[left] <= arr[right]){
                temp[index++] = arr[left++];
            }
            else{
                temp[index++] = arr[right++];
            }
        }
        while(left <= mid){
            temp[index++] = arr[left++];
        }
        while(right <= high){
            temp[index++] = arr[right++];
        }

        for(int i=0; i<temp.length; i++){
            arr[low + i] = temp[i];
        }
    }
}

//OUTPUT
/*
Enter the array size:7
Enter the array elements:
7 2 1 4 6 2 6
After Sort:
1 2 2 4 6 6 7
*/
//---------------------------------------------------------------------------------------------------------
/*
Time Complexity : O(N log2 N)
Space Complexity : O(N)
*/