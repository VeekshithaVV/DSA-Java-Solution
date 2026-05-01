//Minimum days to make M bouquets

package G_Binary_Search.B_BS_on_Answers;

import java.util.*;

public class D_Min_Days_toMake_M_Bouquets{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the array size:");
        int n = input.nextInt();
        int[] days = new int[n];
        System.out.println("Enter the array elements:");
        for(int i=0; i<n; i++){
            days[i] = input.nextInt();
        }

        System.out.print("Number of Bouquets required:");
        int m = input.nextInt();
        System.out.print("Number of adjucent bloomed flowers:");
        int k = input.nextInt();

        //int minDay = brute(days,m,k,n);
        int minDay = optimal(days,m,k,n);

        System.out.println("Minimum Days:"+minDay);
    }
    public static boolean isPossible(int[] days , int day, int m , int k){
        int count = 0;
        int noOfBouq = 0;

        for(int bloom : days){
            if(bloom <= day){
                count++;
            }
            else{
                noOfBouq += (count / k);
                count = 0;
            }
        }
        noOfBouq += (count / k);
        if(noOfBouq >= m){
            return true;
        }
        return false;
    }
    //Brute
    public static int brute(int[] days , int m , int k , int n){
        long totalFlowers = (long) m * k;
        if (totalFlowers > n) {
            return -1;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int day : days){
            min = Math.min(min,day);
            max = Math.max(max,day);
        }

        for(int i=min; i<=max; i++){
            if(isPossible(days,i,m,k)){
                return i;
            }
        }
        return -1;
    }

    //Optimal
    public static int optimal(int[] days, int m , int k , int n){
        long totalFlowers = (long) m * k;
        if(totalFlowers > n){
            return -1;
        }
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for(int day : days){
            low = Math.min(low,day);
            high = Math.max(high,day);
        }

        int ans = -1;
        while(low <= high){
            int mid = (low + high)/2;
            if(isPossible(days, mid, m, k)){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
}
//------------------------------------------------------------------------------------------------------------------------------------------------------

//OUTPUT
/*
Enter the array size:5
Enter the array elements:
1 10 3 10 2
Number of Bouquets required:3
Number of adjucent bloomed flowers:2
Minimum Days:-1

Enter the array size:8
Enter the array elements:
7 7 7 7 13 11 12 7
Number of Bouquets required:2
Number of adjucent bloomed flowers:3
Minimum Days:12
*/