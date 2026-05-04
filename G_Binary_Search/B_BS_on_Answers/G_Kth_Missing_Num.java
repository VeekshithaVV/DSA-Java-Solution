//Kth Missing Positive Number

package G_Binary_Search.B_BS_on_Answers;

import java.util.*;
public class G_Kth_Missing_Num{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the array size:");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for(int i=0; i<n; i++){
            arr[i] = input.nextInt();
        }
        System.out.print("Enter the value of K:");
        int k = input.nextInt();

        //int missingNum = brute(arr,n,k);
        int missingNum = optimal(arr,n,k);

        System.out.println("Missing Number:"+missingNum);
    }
    //Brute
    public static int brute(int[] arr , int n , int k){
        for(int i=0; i<n; i++){
            if(arr[i] <= k){
                k++;
            }
            else{
                break;
            }
        }
        return k;
    }
    //Optimal
    public static int optimal(int[] arr, int n, int k){
        int low = 0, high = n-1;
        while(low <= high){
            int mid = (low + high)/2;
            int missing = arr[mid] - (mid +1);
            if(missing < k){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return (high + 1 + k);
    }
}
//OUTPUT
/*
Enter the array size:5
Enter the array elements:
2 3 4 7 11
Enter the value of K:5
Missing Number:9
*/

//-----------------------------------------------------------------------------------------------------------------------------------
/*
Brute:
TC:- O(N)
SC:- O(1)

Optimal:
TC:- O(log2)
SC:- O(1)
*/