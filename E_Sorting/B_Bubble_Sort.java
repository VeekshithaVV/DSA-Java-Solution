//BUBBLESORT
package E_Sorting;

import java.util.*;
public class B_Bubble_Sort {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the array size:");
        int size = input.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter the array elements:");
        for(int i=0; i<size; i++){
            arr[i] = input.nextInt();
        }
        bubble_sort(arr,size);
        System.out.println("After Sort:");
        for(int num : arr){
            System.out.print(num+" ");
        }
    }
    public static void bubble_sort(int[] arr , int n){
        for(int i=n-1; i>=0; i--){
            int swapDid = 0;
            for(int j=0; j<i; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapDid = 1;
                }
            }
            if(swapDid == 0){
                break;
            }
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
Time Complexity : O(N^2) worst and avergae
                  O(N) best
Space Complexity : O(1)
*/
