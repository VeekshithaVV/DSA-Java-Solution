//Count Inversions - for all i & j < size of array, if i < j then you have to find pair (A[i],A[j]) such that A[j] < A[i].

package F_Array.C_Hard_Array;

import java.util.*;
public class J_Count_Inversions {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the array size :");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for(int i=0; i<n; i++){
            arr[i] = input.nextInt();
        }

        //int result = brute(arr , n);
        int result = optimal(arr,n);

        System.out.println("Count:"+result);
    }
    //Brute
    public static int brute(int[] arr , int n){
        int count = 0;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(arr[i] > arr[j]){
                    count++;
                }
            }
        }
        return count;
    }
    //Optimal
    public static int optimal(int[] arr , int n){
        return mergeSort(arr,0,n-1);
    }
    public static int mergeSort(int[] arr , int low , int high){
        int count = 0;
        if(low >= high){
            return count;
        }
        int mid = (low + high)/2;
        count += mergeSort(arr, low, mid);
        count += mergeSort(arr, mid+1, high);
        count += merge(arr , low , mid , high);
        return count;
    }
    public static int merge(int[] arr , int low , int mid , int high){
        int[] temp = new int[high - low + 1];
        int left = low , right = mid + 1 , index = 0 , count = 0;
        while(left <= mid && right <= high){
            if(arr[left] <= arr[right]){
                temp[index++] = arr[left++];
            }
            else{
                temp[index++] = arr[right++];
                count += (mid - left + 1);
            }
        }
        while(left <= mid){
            temp[index++] = arr[left++];
        }
        while(right <= high){
            temp[index++] = arr[right++];
        }
        for(int i=low; i<= high ; i++){
            arr[i] = temp[i-low];
        }
        return count;
    }
}

//OUTPUT
/*
Enter the array size :5
Enter the array elements:
5 3 2 4 1
Count:8
*/
//--------------------------------------------------------------------------------------------------------------------------
/*
Brute:
Time Complexity : O(N^2)
Spaec Complexity : O(1)

Optimal:
Time Complexity : O(N log N)
Space Complexity : O(N)
*/