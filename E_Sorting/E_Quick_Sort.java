//QUICK SORT
package E_Sorting;

import java.util.*;
public class E_Quick_Sort {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the array size:");
        int size = input.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter the array elements:");
        for(int i=0; i<size; i++){
            arr[i] = input.nextInt();
        }
        quick_sort(arr,0,size-1);
        System.out.println("After Sort:");
        for(int num : arr){
            System.out.print(num+" ");
        }
    }
    public static void quick_sort(int[] arr, int low , int high){
        if(low < high){
            int partionIndex = partion(arr,low,high);
            quick_sort(arr, low, partionIndex-1);
            quick_sort(arr, partionIndex+1, high);
            return;
        }
    }
    //Pivot : First element of array
    public static int partion(int[] arr , int low , int high){
        int pivot = arr[low];
        int i = low;
        int j = high;
        while(i < j){
            while(arr[i] <= pivot && i <= high - 1){
                i++;
            }
            while (arr[j] > pivot && j >= low + 1) {
                j--;
            }
            if(i < j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;

        return j;
    }
}

//OUTPUT
/*
Enter the array size:7
Enter the array elements:
1 7 3 4 2 1 6
After Sort:
1 1 2 3 4 6 7
*/
//----------------------------------------------------------------------------------------------------------------
/*
Time Complexity : O(N log N)
Space Complexity : O(1)
*/