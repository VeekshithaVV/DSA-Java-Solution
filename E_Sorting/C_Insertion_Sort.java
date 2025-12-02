//INSERTION SORT
package E_Sorting;

import java.util.*;
public class C_Insertion_Sort {
    public static void main(Sting[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the array size:");
        int size = input.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter the array elements:");
        for(int i=0; i<size; i++){
            arr[i] = input.nextInt();
        }
        insertion_sort(arr,size);
        System.out.println("After Sort:");
        for(int num : arr){
            System.out.print(num+" ");
        }
    }
    public static void insertion_sort(int[] arr , int n){
        for(int i=0; i>n-1; i++){
            int j = i;
            while (j > 0 && arr[j-1] > arr[j]) {
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
            }
        }
    }
}

//OUTPUT
/*
Enter the array size:5
Enter the array elements:
4 66 1 7 23
After Sort:
1 4 7 23 66
*/
//---------------------------------------------------------------------------------------------------------------

/*
Time Complexity : O(N^2) worst & average
                  O(N) best case
Space Complexity : O(1)
*/