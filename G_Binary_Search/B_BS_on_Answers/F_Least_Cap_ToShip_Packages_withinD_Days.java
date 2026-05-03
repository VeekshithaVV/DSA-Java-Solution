//Least Capacity To Ship Packages within D days

package G_Binary_Search.B_BS_on_Answers;

import java.util.*;
public class F_Least_Cap_ToShip_Packages_withinD_Days{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the array size:");
        int n = input.nextInt();
        int[] weights = new int[n];
        System.out.println("Enter the weights:");
        for(int i=0; i<n; i++){
            weights[i] = input.nextInt();
        }
        System.out.print("Enter the days:");
        int days = input.nextInt();
        input.close();

        //int leastCapacity = brute(weights,n, days);
        int leastCapacity = optimal(weights,n, days);

        System.out.println("Least Capacity of Ship :"+leastCapacity);
    }
    //Brute
    public static int brute(int[] weights, int n , int days){
        int max = Arrays.stream(weights).max().getAsInt();
        int sum = 0;
        for(int num : weights){
            sum += num;
        }

        for(int i=max; i<=sum; i++){
            int daysReq = shipCap(weights,i);
            if(daysReq <= days){
                return i;
            }
        }
        return -1;
    }
    public static int shipCap(int[] weights, int cap){
        int day = 1 , load = 0;
        for(int num : weights){
            if(load + num > cap){
                day++;
                load = num;
            }
            else{
                load += num;
            }
        }
        return day;
    }
    //Optimal
    public static int optimal(int[] weights, int n , int days){
        int low = Arrays.stream(weights).max().getAsInt();
        int high = Arrays.stream(weights).sum();

        while(low <= high){
            int mid = (low + high)/2;
            int reqDays = shipCap(weights,mid);
            if(reqDays <= days){
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
Enter the array size:10
Enter the weights:
1 2 3 4 5 6 7 8 9 10
Enter the days:5
Least Capacity of Ship :15
*/
//------------------------------------------------------------------------------------------------------------------------
/*
Brute:
TC:O(sum-max)*O(n)
SC:O(1)

Optimal:
TC:O(log2(sum-max))*O(n)
sc:O(1)
*/