//A peak element is an element that is strictly greater than its neighbors.
package G_Binary_Search.A_BS_on_1D_Array;

import java.util.*;
public class M_Find_Peak_Element {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the array size:");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for(int i=0; i<n; i++){
            arr[i] = input.nextInt();
        }

        //int index = brute(arr,n);
        int index = optimal(arr,n);

        System.out.println("Peak Element found in index:"+index);
    }
    //Brute
    public static int brute(int[] arr , int n){
        for(int i=0; i<n; i++){
            if((i == 0 || arr[i-1] < arr[i]) && (i == n-1 || arr[i] > arr[i+1])){
                return i;
            }
        }
        return -1;
    }
    //Optimal
    public static int optimal(int[] arr , int n){
        if(n == 1){
            return 0;
        }
        if(arr[0] > arr[1]){
            return 0;
        }
        if(arr[n-1] > arr[n-2]){
            return n-1;
        }
        int low = 1, high = n-2;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] > arr[mid+1] && arr[mid] > arr[mid-1]){
                return mid;
            }
            else if(arr[mid] > arr[mid-1]){
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
Enter the array size:10
Enter the array elements:
1 2 3 4 5 6 7 8 5 1
Peak Element found in index:7
*/
//-----------------------------------------------------------------------------------------------------------
/*
Brute:
Time Complexity : O(N)
Space Complexity : O(1)

Optimal:
Time Complexity : O(log2 N)
Space Complexity : O(1)
*/