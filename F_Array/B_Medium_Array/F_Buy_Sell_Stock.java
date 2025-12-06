//package F_Array.B_Medium_Array;
package F_Array.B_Medium_Array;

import java.util.*;
public class F_Buy_Sell_Stock {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the array size:");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the prices:");
        for(int i=0; i<n; i++){
            arr[i] = input.nextInt();
        }
        int maxProfit = brute(arr,n);
        //int maxProfit = optimal(arr,n);
        System.out.println("Max Profit:"+maxProfit);
    }
    //Brute
    public static int brute(int[] prices , int days){
        int maxProfit = 0;
        for(int i=0; i<days; i++){
            for(int j=i; j<days; j++){
                int profit = prices[j] - prices[i];
                maxProfit = Math.max(maxProfit, profit);
            }
        }
        return maxProfit;
    }
     //Optimal
    public static int optimal(int[] prices , int days){
        int min_price = prices[0];
        int maxProfit = 0;
        for(int i=1; i<days; i++){
            int cost = prices[i] - min_price;
            maxProfit = Math.max(maxProfit , cost);
            min_price = Math.min(min_price , prices[i]);
        }
        return maxProfit;
    }
   
}

//OUTPUT
/*
Enter the array size:6
Enter the prices:
7 1 5 3 6 4
Max Profit:5
*/
//---------------------------------------------------------------------------------------------------------------------
/*
Brute:
Time Complexity : O(N^2)
Space Complexity : O(1)

Optimal:DP
Time Complexity : O(N)
Space Compelxity : O(1)
*/