//Remove Duplicates in-place from Sorted Array
package F_Array.A_Easy_Array;

import java.util.*;
public class D_Remove_Duplicates {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the array size:");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the sorted elements:");
        for(int i=0; i<n; i++){
            arr[i] = input.nextInt();
        }
        //int count = brute(arr,n);
        int count = optimal(arr,n);
        System.out.println("Unique Elements are: "+count);
    }
    //Brute
    public static int brute(int[] arr , int n){
        HashSet<Integer> set = new HashSet<>();
        int index = 0;
        for(int num : arr){
            if(!set.contains(num)){
                set.add(num);
                arr[index] = num;
                index++;
            }
        }
        return index;
    }
    //Optimal
    public static int optimal(int[] arr, int n){
        int index = 0;
        for(int i=1; i<n; i++){
            if(arr[i] != arr[index] ){
                index++;
                arr[index] = arr[i];
            }
        }
        return index+1;
    }
}

//OUTPUT
/*
Enter the array size:6
Enter the sorted elements:
1 1 3 4 4 5 
Unique Elements are: 4
*/
//--------------------------------------------------------------------------------------------------------------------------
/*
Brute:
Time Complexity : O(N)
Space Complexity : O(N)

Optimal:
Time Complexity :O(N)
Space Compexity : O(1)
*/