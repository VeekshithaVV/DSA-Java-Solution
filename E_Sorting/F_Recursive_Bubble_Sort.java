//RECURSIVE BUBBLE SORT
package E_Sorting;

import java.util.Scanner;
public class F_Recursive_Bubble_Sort {
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
        if(n == 1){
            return;
        }
        
        int swapDid = 0;
        for(int j=0; j<n-1; j++){
            if(arr[j] > arr[j+1]){
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
                swapDid = 1;
            }
        }
        if(swapDid == 0){
            return;
        }
        bubble_sort(arr, n-1);
    }
}

//OUTPUT
/*
Enter the array size:5
Enter the array elements:
5 4 3 2 1
After Sort:
1 2 3 4 5 
*/