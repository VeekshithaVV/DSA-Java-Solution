//Find out how many times the array has been rotated
package G_Binary_Search.A_BS_on_1D_Array;

import java.util.Scanner;
public class K_Find_Times_Of_Rotation {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the arra size:");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for(int i=0; i<n; i++){
            arr[i] = input.nextInt();
        }
        
        //int count = unique(arr,n);
        int count = duplicates(arr,n);

        System.out.println("Count of Rotation :"+count);
    }
    public static int unique(int[] arr , int n){
        int low = 0 , high = n-1, ans = Integer.MAX_VALUE, index = -1;
        while(low <= high){
            int mid = low + (high-low)/2;

            if(arr[low] <= arr[high]){
                if(arr[low] < ans){
                    index = low;
                    ans = arr[low];
                }
                break;
            }
            if(arr[low] <= arr[mid]){
                if(arr[low] < ans){
                    index = low;
                    ans = arr[low];
                }
                low = mid + 1;
            }
            else{
                if(arr[mid] < ans){
                    index = mid ;
                    ans = arr[mid];
                }
                high = mid - 1;
            }
        }
        return index;
    }
    //Array may contains Duplicates
    public static int duplicates(int[] arr,int n){
        int low = 0, high = n - 1;
        int ans = Integer.MAX_VALUE;
        int index = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // 🔑 Case 1: duplicates — cannot decide
            if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
                if (arr[low] < ans) {
                    ans = arr[low];
                    index = low;
                }
                low++;
                high--;
                continue;
            }

            // Left half sorted
            if (arr[low] <= arr[mid]) {
                if (arr[low] < ans) {
                    ans = arr[low];
                    index = low;
                }
                low = mid + 1;
            }
            // Right half sorted
            else {
                if (arr[mid] < ans) {
                    ans = arr[mid];
                    index = mid;
                }
                high = mid - 1;
            }
        }
        return index;
    }
}

//OUTPUT
/*
Enter the arra size:5        
Enter the array elements:
3 4 5 1 2
Count of Rotation :3
*/
