//Single Element appear once
package F_Array.A_Easy_Array;

import java.util.Scanner;
public class M_Num_Occus_Ones {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the size of array:");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for(int i=0; i<n; i++){
            arr[i] = input.nextInt();
        }
        //int sigle = brute(arr,n);
        //int sigle = better(arr,n);
        int sigle = optimal(arr, n);
        System.out.println(" Element appear once: "+sigle);
    }
    //Brute
    public static int brute(int[] arr , int n){
        for(int i=0; i<n; i++){
            int num = arr[i];
            int count = 0;
            for(int j=0; j<n; j++){
                if(arr[j] == num){
                    count++;
                }
            }
            if(count == 1){
                return num;
            }
        }
        return -1;
    }
    //Better
    public static int better(int[] arr, int n){
        int max = arr[0];
        for(int num : arr){
            max = Math.max(max, num);
        }
        int[] hash = new int[max+1];
        for(int i=0; i<n; i++){
            hash[arr[i]]++;
        }
        for(int i=0; i<n; i++){
            if(hash[arr[i]] == 1){
                return arr[i];
            }
        }
        return -1;
    }
    //Optimal
    public static int optimal(int[] arr, int n){
        int result = 0;
        for(int num : arr){
            result ^= num;
        }
        return result;
    }
}

//OUTPUT
/*
Enter the size of array:5
Enter the array elements:
1 1 3 4 3
 Element appear once: 4
*/
//-------------------------------------------------------------------------------------------------------
/*
Brute:
Time Complexity : O(N^2)
Space Complexity : O(1)

Better:
Time Complexity :O(3N)
Space Compexity:O(Max Element)

Optimal:
Time Complexity : O(N)
Space Complexity : O(1)
*/