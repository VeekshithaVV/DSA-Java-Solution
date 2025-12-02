//SELECTION SORT
package E_Sorting;

import java.util.*;
public class A_Selection_Sort {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the array size:");
        int size = input.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter the array elements:");
        for(int i=0; i<size; i++){
            arr[i] = input.nextInt();
        }
        selection_sort(arr,size);
        System.out.println("After Sort:");
        for(int num : arr){
            System.out.print(num+" ");
        }
    }
    public static void selection_sort(int[] arr , int n){
        for(int i=0; i<n-1; i++){
            int mini = i;
            for(int j=i + 1; j<n; j++){
                if(arr[j] < arr[mini]){
                    mini = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[mini];
            arr[mini] = temp;
        }
    }
}

//OUTPUT
/*
Enter the array size:5
Enter the array elements:
100 24 1 6 23
After Sort:
1 6 23 24 100
*/
//-----------------------------------------------------------------------------------------------------

/*
Time Complexity : O(N^2)
Space Complexity : O(1)
*/