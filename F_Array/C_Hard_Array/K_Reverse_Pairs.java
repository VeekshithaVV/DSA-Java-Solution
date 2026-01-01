//Reverse Pair - Pairs are those pairs where i<j and arr[i]>2*arr[j].
package F_Array.C_Hard_Array;

import java.util.*;
public class K_Reverse_Pairs {
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
        for(int i=0; i<n-1; i++){
            int val1 = arr[i];
            for(int j=i+1; j<n; j++){
                int val2 = arr[j] * 2;
                if(val1 > val2){
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
        count += countPairs(arr , low , mid , high);
        merge(arr , low , mid , high);
        return count;
    }
    public static void merge(int[] arr , int low , int mid , int high){
        int[] temp = new int[high - low + 1];
        int left = low , right = mid + 1 , index = 0;
        while (left <= mid && right <= high) {
            if(arr[left] <= arr[right]){
                temp[index++] = arr[left++];
            }
            else{
                temp[index++] = arr[right++];
            }
        }
        while(left <= mid){
            temp[index++] = arr[left++];
        }
        while(right <= high){
            temp[index++] = arr[right++];
        }
        for(int i=low; i<=high; i++){
            arr[i] =  temp[i-low];
        }
    }
    public static int countPairs(int[] arr , int low , int mid , int high){
        int count = 0;
        int right = mid + 1;
        for(int i=low; i<=mid; i++){
            while(right <= high && arr[i] > (2*arr[right])){
                right++;
            }
            count += (right - (mid + 1));
        }
        return count;
    }
}

//OUTPUT
/*
Enter the array size :7
Enter the array elements:
40 25 19 12 9 6 2
Count:15
*/
//------------------------------------------------------------------------------------------------------------------
/*
Brute:
Time Complexity : O(N^2)
Space Complexity : O(1)

Optimal:
Time Complexity : O(2*N log N)
Space Complexity : O(N)
*/