//Maximum Consecutive 1's
package F_Array.A_Easy_Array;

import java.util.Scanner;
public class L_Max_Consecutive_Ones {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the size of array:");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for(int i=0; i<n; i++){
            arr[i] = input.nextInt();
        }
        int count = max_Ones(arr,n);
        System.out.println(" Maximum Consecutive 1's are: "+count);
    }
    public static int max_Ones(int[] arr , int n){
        int max_one = 0;
        int count = 0;
        for(int num : arr){
            if(num == 1){
                count++;
                max_one = Math.max(count , max_one);
            }
            else{
                count = 0;
            }
        }
        return max_one;
    }
}

//OUTPUT
/*
Enter the size of array:6
Enter the array elements:
1 1 0 1 1 1
 Maximum Consecutive 1's are: 3
*/
//-----------------------------------------------------------------------------------------------------------------
/*
Time Compexity : O(N)
Space Compexity : O(1)
*/