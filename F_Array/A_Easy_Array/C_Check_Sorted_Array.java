//Check if the Array is Sorted(Ascending Order)
package F_Array.A_Easy_Array;

import java.util.Scanner;
public class C_Check_Sorted_Array {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the size of array:");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for(int i=0; i<n; i++){
            arr[i] = input.nextInt();
        }
        if(check(arr)){
            System.out.println("Sorted Array!!");
        }
        else{
            System.out.println("Not Sorted Array!!");
        }
    }
    public static boolean check(int[] arr){
        for(int i=1; i<arr.length; i++){
            if(arr[i] < arr[i-1]){
                return false;
            }
        }
        return true;
    }
}

//OUTPUT
/*
Enter the size of array:5
Enter the array elements:
3 2 1 4 5
Not Sorted Array!!
*/
//------------------------------------------------------------------------------------------------------------
/*
Time Complexity : O(N)
Space Complexity : O(1)
*/