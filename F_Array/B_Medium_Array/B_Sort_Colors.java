//Sort an array of 0s, 1s and 2s
package F_Array.B_Medium_Array;

import java.util.*;
public class B_Sort_Colors {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the array size:");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for(int i=0; i<n; i++){
            arr[i] = input.nextInt();
        }
        //brute(arr,n);
        //better(arr,n);
        optimal(arr,n);
        System.out.println("After Sort:");
        for(int num : arr){
            System.out.print(num+" ");
        }
    }
    //Brute
    public static void brute(int[] arr , int n){
        Arrays.sort(arr);
    }
    //Better
    public static void better(int[] arr, int n){
        int count_0 = 0;
        int count_1 = 0;
        int count_2 = 0;
        for(int num : arr){
            if(num == 0){
                count_0++;
            }
            else if(num == 1){
                count_1++;
            }
            else{
                count_2++;
            }
        }
        for(int i=0; i<count_0; i++){
            arr[i] = 0;
        }
        for(int i=count_0; i< count_0 + count_1; i++){
            arr[i] = 1;
        }
        for(int i=count_0 + count_1; i<n; i++){
            arr[i] = 2;
        }
    }
    //Optimal
    //Dutch National Flag Algorithm
    public static void optimal(int[] arr , int n){
        int low = 0;
        int high = n-1;
        int mid = 0;
        while(mid <= high){
            if(arr[mid] == 0){
                int temp = arr[mid];
                arr[mid] = arr[low];
                arr[low] = temp;
                low++;
                mid++;
            }
            else if(arr[mid] == 1){
                mid++;
            }
            else{
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
        }
    }
}

//OUTPUT
/*
Enter the array size:10
Enter the array elements:
0 1 1 0 1 2 1 2 0 0 0
After Sort:
0 0 0 0 1 1 1 1 2 2 
*/
//-------------------------------------------------------------------------------------------------------------------------------
/*
Brute:
Time Complexity : O(N log N)
Space Complexity : O(1)

Better:
Time Complexity : O(2N)
Space Complexity : O(1)

Optimal:
Time Complexity : O(N)
Spaec Complexity : O(1)
*/