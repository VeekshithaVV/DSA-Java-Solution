//Allocate Books

package G_Binary_Search.B_BS_on_Answers;

import java.util.*;
public class I_Allocate_Books {
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
            if(isAllocatePossible(arr,n,students,mid)){
                res = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return res;
    }
    public static boolean isAllocatePossible(int[] arr , int n , int students , int barrier){
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

//OUTPUT:
/*
Enter the array size:4
Enter the array elements:
12 34  67 90
Enter the number of students:2
 the maximum number of pages assigned to a student is minimum :113

 Enter the array size:4           
Enter the array elements:
12 34  67 90
Enter the number of students:8
 the maximum number of pages assigned to a student is minimum :-1
*/

//------------------------------------------------------------------------------------------------------------------
/*
TC:- O(LOg2) * O(N)
SC:- O(1)
*/