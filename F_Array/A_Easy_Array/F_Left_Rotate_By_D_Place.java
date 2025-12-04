//Rotate an array by left 
package F_Array.A_Easy_Array;

import java.util.*;
public class F_Left_Rotate_By_D_Place {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the array size:");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for(int i=0; i<n; i++){
            arr[i] = input.nextInt();
        }
        System.out.print("Enter the rotation count:");
        int d = input.nextInt();
        //brute(arr,n,d);
        optimal(arr,n,d);
        System.out.println("Left Rotated Array by "+d+" places " );
        for(int num : arr){
            System.out.print(num+" ");
        }
    }
    //Brute
    public static void brute(int[] arr , int n,int d){
        d = d % n;
        int[] temp = new int[d];
        for(int i=0; i<d; i++){
            temp[i] = arr[i];
        }
        //move leftwards elements
        for(int i=d; i<n; i++){
            arr[i-d] = arr[i];
        }
        for(int i=n-d; i<n; i++){
            arr[i] = temp[i-(n-d)];
        }
    }
    //Optimal
    public static void optimal(int[] arr , int n , int d){
        d = d % n;
        reverse(arr,0,d-1);
        reverse(arr,d,n-1);
        reverse(arr,0,n-1);
    }
    public static void reverse(int[] arr, int start , int end){
        while(start <= end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}

//OUTPUT
/*
Enter the array size:5
Enter the array elements:
1 2 3 4 5
Enter the rotation count:3
Left Rotated Array by 3 places 
4 5 1 2 3 
*/
//---------------------------------------------------------------------------------------------------------------------
/*
Brute:
Time Complexity : O(D) + O(N_D) + O(D) ~ O(N + D)
Space Complexity : O(D)

Optimal:
Time Complexity : O(D) + O(N-D) + O(N) ~ O(2N)
Space Complexity :O(1)
*/