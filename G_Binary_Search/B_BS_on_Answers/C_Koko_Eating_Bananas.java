//Koko Eating Bananas
package G_Binary_Search.B_BS_on_Answers;

import java.util.*;
public class C_Koko_Eating_Bananas {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the array size:");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the piles of bananas:");
        for(int i=0; i<n; i++){
            arr[i] = input.nextInt();
        }
        System.out.print("Enter the Time (in hours) for all the bananas to be eaten:");
        int h = input.nextInt();

        //int min = brute(arr,h);
        int min = optimal(arr,h);

        System.out.println("Minimum number of bananas to eat per hour:"+min);
    }
    //Brute
    public static int brute(int[] arr , int h){
        int maxVal = Arrays.stream(arr).max().getAsInt();
        for(int i=1; i<= maxVal; i++){
            int hours = calculateTotalHours(arr,i);
            if(hours <= h){
                return i;
            }
        }
        return maxVal;
    }
    public static int calculateTotalHours(int[] arr , int hourly){
        int totalHoures = 0;
        for(int piles : arr){
            totalHoures += (int)Math.ceil((double)piles / hourly); 
        }
        return totalHoures;
    }
    //Optimal
    public static int optimal(int[] arr , int h){
        int low = 1, high = Arrays.stream(arr).max().getAsInt();
        while(low <= high){
            int mid = low + (high - low)/2;

            int totalHoures = calculateTotalHours(arr, mid);
            if(totalHoures <= h){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }
}

//OUTPUT
/*
Enter the array size:4
Enter the piles of bananas:
3 6 7 11
Enter the Time (in hours) for all the bananas to be eaten:8
Minimum number of bananas to eat per hour:4
*/
//----------------------------------------------------------------------------------------------------
/*
Brute:
Time Complexity: O(N) + O(MaxVal) * O(N) 
SPace Complexity:O(1)

Optimal:
Time Complexity: O(N) + O(log M) * O(N) ~ O(N log M)
Space Complexity: O(1)
*/