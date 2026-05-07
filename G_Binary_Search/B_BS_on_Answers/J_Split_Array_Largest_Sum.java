// Painter's Partition / Split Array Largest Sum
//
// Given an array and k partitions/painters,
// divide the array into k contiguous parts
// such that the maximum partition sum is minimum.
//
// Each partition must contain continuous elements only.
//
// Return the minimum possible largest partition sum.

package G_Binary_Search.B_BS_on_Answers;

import java.util.*;
public class J_Split_Array_Largest_Sum {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the array size:");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for(int i=0; i<n; i++){
            arr[i] = input.nextInt();
        }
        System.out.print("Enter the number of students:");
        int students = input.nextInt();

        int maximumPages = optimal(arr, n , students);

        System.out.println(" the maximum number of pages assigned to a student is minimum :"+maximumPages);
    }
    public static int optimal(int[] arr , int n , int students){
        int low = Integer.MIN_VALUE;
        int high = 0;
        for(int num : arr){
            high += num;
            low = Math.max(num , low);
            
        }
        if(n < students){
            return -1;
        }
        int res = -1;
        while(low <= high){
            int mid = (low + high)/2;
            if(isPossible(arr,n,students,mid)){
                res = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return res;
    }
    public static boolean isPossible(int[] arr , int n , int students , int barrier){
        int allocatedStudents = 1 , pages = 0;
        for(int num : arr){
            if(num > barrier){
                return false;
            }
            else if(num + pages > barrier){
                allocatedStudents++;
                pages = num;
            }
            else{
                pages += num;
            }
        }
        if(allocatedStudents > students){
            return false;
        }
        else{
            return true;
        }
    }
}
