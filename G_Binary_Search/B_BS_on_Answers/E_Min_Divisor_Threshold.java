//Find the Smallest Divisor Given a Threshold

package G_Binary_Search.B_BS_on_Answers;

import java.util.*;
public class E_Min_Divisor_Threshold {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the array size:");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for(int i=0; i<n; i++){
            arr[i] = input.nextInt();
        }
        System.out.print("Enter the threshold value:");
        int threshold = input.nextInt();
        input.close();

        //int res = brute(arr,threshold,n);
        int res = optimal(arr,threshold,n);

        System.out.println("Resilt:"+res);
      
    }
    //Brute
    public static int brute(int[] arr , int threshold , int n){
        int high = Integer.MIN_VALUE;
        for(int num : arr){
            high = Math.max(high,num);
        }

        for(int d=1; d<=high; d++){
            int sum = 0;
            for(int i=0; i<n; i++){
                sum += (int) Math.ceil((double) arr[i]/d);
            }
            if(sum <= threshold){
                return d;
            }
        }
        return -1;
    }
    //Optimal
    public static int optimal(int[] arr, int threshold , int n){
        if(n > threshold){
            return -1;
        }
        int low = 1;
        int high = Arrays.stream(arr).max().getAsInt();

        int ans = -1;
        while(low <= high){
            int mid = (low + high)/2;
            if(sumByDiv(arr,mid) <= threshold){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
    public static int sumByDiv(int[] arr , int div){
        int sum = 0;
        for(int num : arr){
            sum += Math.ceil((double) num /div);
        }
        return sum;
    }
}

//OUTPUT
/*
Enter the array size:4
Enter the array elements:
1 2 5 9
Enter the threshold value:6
Resilt:5
*/

//------------------------------------------------------------------------------------------------------------------------------

/*
Brute:
Time Complexity : O(max) * O(n)
Space Complexity : O(1)

Optimal:
Time Complexity : O(log2(max*O(n)))
Space Compleity : O(1)
*/


