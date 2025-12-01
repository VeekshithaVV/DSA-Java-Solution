//Reverse a given Array
package C_Basic_Recursion_03;

import java.util.*;
public class F_Reverse_Array {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the array size:");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter the array elements:");
        for(int i=0; i<n; i++){
            arr[i] = input.nextInt();
        }
        reverse_Array(0,n,arr);
        System.out.println("After reverse:");
        for(int num : arr){
            System.out.print(num+" ");
        }
    }
    public static void reverse_Array(int i, int num, int[] arr){
        if(i >= num/2){
            return;
        }
        swap(i,num-i-1,arr);
        reverse_Array(i+1, num, arr);
    }
    public static void swap(int a, int b, int[] arr){
        int temp = arr[a];
        arr[a] = arr[b]; 
        arr[b] = temp;
    }
}

//OUTPUT
/*
Enter the array size:5
Enter the array elements:1 2 3 4 5
After reverse:
5 4 3 2 1
*/
//----------------------------------------------------------------------------------------------------------------
/*
Time Complexity : O(n)
Space Complexity : O(n)
*/