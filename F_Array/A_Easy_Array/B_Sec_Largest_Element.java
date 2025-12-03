//Largest Element in an Array
package F_Array.A_Easy_Array;

import java.util.*;
public class B_Sec_Largest_Element {
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
        //int largest = better(arr,n);
        int largest = optimal(arr,n);
        System.out.println("Second Largest Element is : "+largest);
    }
    //Brute
    public static int brute(int[] arr , int n){
        Arrays.sort(arr);
        int largest = arr[n-1];
        int sec_larg = -1;
        for(int i = n-2; i>=0; i--){
            if(arr[i] != largest){
                sec_larg = arr[i];
                break;
            }
        }
        return sec_larg;
    }
    //Better
    public static int better(int[] arr , int n){
        int largest = arr[0];
        for(int num : arr){
            if(num > largest){
                largest = num;
            }
        }
        int sec_larg = -1;
        for(int num : arr){
            if(num != largest && num > sec_larg){
                sec_larg = num;
            }
        }
        return sec_larg;
    }
    //Optimal
    public static int optimal(int[] arr , int n){
        int largest = arr[0];
        int sec_larg = Integer.MIN_VALUE;
        for(int i=1; i<n; i++){
            if(arr[i] > largest){
                sec_larg = largest;
                largest = arr[i];
            }
            else if (arr[i] != largest && arr[i] > sec_larg){
                sec_larg = arr[i];
            }
        }
        return sec_larg;
    }
}

//OUTPUT
/*
Enter the size of array:6
Enter the array elements:
3 5 2 7 1 4
Second Largest Element is : 5
*/
//----------------------------------------------------------------------------------------------------------------
/*
Brute:
Time Complexity : O(N log N)
Space Complexity : O(1)

Better:
Time Complexity :O(2N)
Space Complexity : O(1)

Optimal:
Time Complexity : O(N)
Space Complexity : O(1)
*/