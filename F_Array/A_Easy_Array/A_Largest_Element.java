//Largest Element in an Array
package F_Array.A_Easy_Array;

import java.util.*;
public class A_Largest_Element {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the size of array:");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for(int i=0; i<n; i++){
            arr[i] = input.nextInt();
        }
        //int largest = brute(arr,n);
        int largest = optimal(arr,n);
        System.out.println("Largest Element is : "+largest);
    }
    //Brute
    public static int brute(int[] arr , int n){
        Arrays.sort(arr);
        return arr[n-1];
    }
    //Optimal
    public static int optimal(int[] arr , int n){
        int largest = arr[0];
        for(int i=1; i<n; i++){
            if(arr[i] > largest){
                largest = arr[i];
            }
        }
        return largest;
    }
}

//OUTPUT
/*
Enter the size of array:7
Enter the array elements:
3 2 5 8 10 2 1
Largest Element is : 10
*/
//----------------------------------------------------------------------------------------------------------------
/*
Brute:
Time Complexity : O(N log N)
Space Complexity : O(1)

Optimal:
Time Complexity : O(N)
Space Complexity : O(1)
*/