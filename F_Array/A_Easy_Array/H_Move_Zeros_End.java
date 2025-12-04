//Move 0 to end and number orders not change
package F_Array.A_Easy_Array;

import java.util.ArrayList;
import java.util.Scanner;
public class H_Move_Zeros_End {
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
        optimal(arr,n);
        System.out.println("Result array:");
        for(int num : arr){
            System.out.print(num+" ");
        }
    }
    //Brute
    public static void brute(int[] arr, int n){
        ArrayList<Integer> list =  new ArrayList<>();
        for(int num : arr){
            if(num > 0){
                list.add(num);
            }
        }
        for(int i=0; i<list.size();i++){
            arr[i] = list.get(i);
        }
        int zeroIndex = list.size();
        while(zeroIndex < n){
            arr[zeroIndex++] = 0;
        }
    }
    //Optimal
    public static void optimal(int[] arr,int n){
        int index = 0;
        for(int num : arr){
            if(num > 0){
                arr[index++] = num;
            }
        }
        while (index < n) {
            arr[index++] = 0;
        }
    }
}

//OUTPUT
/*
Enter the array size:10
Enter the array elements:
1 0 2 0 0 34 5 0 1 1
Result array:
1 2 34 5 1 1 0 0 0 0
*/
//----------------------------------------------------------------------------------------------------------
/*
Brute:
Time Complexity : O(2N)
Space Complexity : O(N)

Optimal:
Time Complexity : O(N)
Space Complexity : O(1)
*/