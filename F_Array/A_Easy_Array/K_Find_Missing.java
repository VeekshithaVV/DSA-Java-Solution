//Missing Number
package F_Array.A_Easy_Array;

import java.util.Scanner;

public class K_Find_Missing {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the size of array1:");
        int n1 = input.nextInt();
        int[] arr1 = new int[n1];
        //missing number space is replace with 0(leetcode)
        System.out.println("Enter the array 1 elements:");
        for(int i=0; i<n1; i++){
            arr1[i] = input.nextInt();
        }
        //int missing = brute(arr1,n1);
        //int missing = optimalA(arr1,n1);
        int missing = optimalB(arr1, n1);
        System.out.println("Missing number is : "+missing);

    }
    //Brute
    public static int brute(int[] arr , int n){
        for(int i=1; i<=n; i++){
            int flag = 0;
            for(int j=0; j<n; j++){
                if(arr[j] == i){
                    flag = 1;
                    break;
                }
            }
            if(flag == 0){
                return i;
            }
        }
        return -1;
    }
    //Optimal:A (Sum)
    public static int optimalA(int[] arr, int n){
        int sum = (n*(n+1))/2;
        int arraySum = 0;
        for(int num : arr){
            arraySum += num;
        }
        return sum - arraySum;
    }
    //Optimal:B (XOR)
    public static int optimalB(int[] arr, int n){
        int xor = 0;
        for(int i=0; i<n; i++){
            xor ^= i ^ arr[i];
        }
        xor ^= n;
        return xor;
    }
}

//OUTPUT
/*
Enter the size of array1:5
Enter the array 1 elements:
1 2 3 0 4
Missing number is : 5
*/
//---------------------------------------------------------------------------------------------------------
/*
Brute:
Time Complexity : O(N * N) ~ O(N^2)
Space Complexity : O(1)

Optimal:A
Time Complexity : O(N)+O(N) ~ O(2N)
Space Complexity :O(1)

Optimal:B
Time Complexity : O(N)
SPace Complexity : O(1)
*/