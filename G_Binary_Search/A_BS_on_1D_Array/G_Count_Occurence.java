//Count Occurrences in Sorted Array
package G_Binary_Search.A_BS_on_1D_Array;

import java.util.*;
public class G_Count_Occurence {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the array size:");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the sorted array elements:");
        for(int i=0; i<n; i++){
            arr[i] = input.nextInt();
        }
        System.out.print("Enter the target element:");
        int target = input.nextInt();

        //int count = find(arr,n,target);
        int count = findOccurence(arr,n,target);
        System.out.println("Total Number of  Occurence:"+count);     
    }
    //Brute
    public static int find(int[] arr , int n , int target){
        int count = 0;
        for(int num : arr){
            if(num == target){
                count++;
            }
        }
        return count;
    }
    //Optimal
    public static int findOccurence(int[] arr,int n, int target){
        int first = findFirstLast(arr,n,target,true);
        if(first == -1){
            return 0;
        }
        int last = findFirstLast(arr,n,target,false);
        return last - first + 1;
    }
    public static int findFirstLast(int[] arr , int n ,int target , boolean isFirst){
        int index = -1;
        int low = 0 , high = n-1;
        while(low <= high){
            int mid = low + (high - low )/2;
            if(arr[mid] == target){
                index = mid;
                if(isFirst){
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }
            else if(arr[mid] < target){
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return index;
    }
}

//OUTPUT
/*
Enter the array size:6
Enter the sorted array elements:
1 2 3 3 3 3
Enter the target element:3
Total Number of  Occurence:4
*/
//-------------------------------------------------------------------------------------------------------------------------------
/*
Brute:
Time Complexity : O(N)
Space Complexity : O(1)

Optimal:
Time Complexity : O(N log n)
Space Complexity : O(1)
*/
