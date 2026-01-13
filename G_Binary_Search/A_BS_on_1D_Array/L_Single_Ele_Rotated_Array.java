//Search Single Element in a sorted array
package G_Binary_Search.A_BS_on_1D_Array;

import java.util.Scanner;
public class L_Single_Ele_Rotated_Array {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the arra size:");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for(int i=0; i<n; i++){
            arr[i] = input.nextInt();
        }
        
        //int ele = brute(arr,n);
        int ele = optimal(arr,n);

        System.out.println("Single element is :"+ele);
    }
    //Brute
    public static int brute(int[] arr , int n){
        if (n == 1) {
            return arr[0];
        }
        for(int i=0; i<n; i++){
            if(i == 0){
                if(arr[i] != arr[i+1]){
                    return arr[i];
                }
            }
            else if(i == n-1){
                if(arr[n-1] != arr[n-2]){
                    return arr[i];
                }
            }
            else{
                if(arr[i] != arr[i+1] && arr[i] != arr[i-1]){
                    return arr[i];
                }
            }
        }
        return -1;
    }
    //Optimal
    public static int optimal(int [] arr , int n){
        if(n == 1){
            return arr[0];
        }
        if(arr[0] != arr[1]){
            return arr[0];
        }
        if(arr[n-1] != arr[n-2]){
            return arr[n-1];
        }
        int low = 1, high = n-2;
        while(low <= high){
            int mid = low +(high - low)/2;

            if(arr[mid] != arr[mid+1] && arr[mid] != arr[mid-1]){
                return arr[mid];
            }

            if((mid % 2 == 1 && arr[mid-1] == arr[mid] ) || (mid % 2 == 0 && arr[mid] == arr[mid+1])){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }
}

//OUTPUT
/*
Enter the arra size:11
Enter the array elements:
1 1 2 2 3 3 4 5 5 6 6
Single element is :4
*/
//-----------------------------------------------------------------------------------------------------------
/*
Brute:
Time Complexity : O(N)
SPace Complexity : O(1)

Optimal:
Time Complexity : O(log N)
Space Complexity : O(1)
*/