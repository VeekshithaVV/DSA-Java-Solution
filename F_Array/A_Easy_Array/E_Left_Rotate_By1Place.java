//Left Rotate the Array by One
package F_Array.A_Easy_Array;

import java.util.*;
public class E_Left_Rotate_By1Place {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the array size:");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for(int i=0; i<n; i++){
            arr[i] = input.nextInt();
        }
        left_rotate(arr,n);
        System.out.println("Left Rotated Array by 1 place:");
        for(int num : arr){
            System.out.print(num+" ");
        }
    }
    public static void left_rotate(int[] arr, int n){
        int temp = arr[0];
        for(int i=1; i<n; i++){
            arr[i-1] = arr[i];
        }
        arr[n-1] = temp;
    }
}

//OUTPUT
/*
Enter the array size:5
Enter the array elements:
1 2 3 4 5
Left Rotated Array by 1 place:
2 3 4 5 1 
*/
//------------------------------------------------------------------------------------------------------------------
/*
Time Compexity : O(N)
Space Complexity : O(1)
*/