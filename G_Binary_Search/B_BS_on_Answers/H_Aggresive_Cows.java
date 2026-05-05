//Aggressive Cows

package G_Binary_Search.B_BS_on_Answers;

import java.util.*;
public class H_Aggresive_Cows {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the array length:");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for(int i=0; i<n; i++){
            arr[i] = input.nextInt();
        }
        System.out.print("Enter the cows:");
        int cows = input.nextInt();

        // int distance = brute(arr,n,cows);
        int distance = optimal(arr,n,cows);

        System.out.println("Distance between cows:"+distance);
    }
    //Brute
    public static int brute(int[] arr, int n , int cows){
        Arrays.sort(arr);
        int maxDist = arr[n-1] - arr[0];
        int ans = 0;
        for(int d=1; d<= maxDist; d++){
            if(canPlaceStall(arr,cows,d)){
                ans = d;
            }
        }
        return ans;
    }
    public static boolean canPlaceStall(int[] arr, int cows, int dist){
        int count = 1, lastPos = arr[0];
        for(int i=1; i<arr.length; i++){
            if(arr[i] - lastPos >= dist){
                count++;
                lastPos = arr[i];
            }
            if(count >= cows){
                return true;
            }
        }
        return false;
    }
    //Optimal
    public static int optimal(int[] arr , int n , int cows){
        Arrays.sort(arr);
        int low = 0, high = arr[n-1]- arr[0];
        while(low <= high){
            int mid = (low + high)/2;
            if(canPlaceStall(arr,cows,mid)){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return high;
    }
}

//OUTPUT
/*
Enter the array length:6
Enter the array elements:
0 3 4 7 10 9
Enter the cows:4
Distance between cows:3
*/

//------------------------------------------------------------------------------------------------------------------------------------------
/*
Brute:
TC:- O(max - min) * O(N)
SC:- O(1)

Optimal:
TC:- O(log2n) * O(N)
SC:- O(1)
*/