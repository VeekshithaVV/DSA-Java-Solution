//Nth Root of a Number 
package G_Binary_Search.B_BS_on_Answers;

import java.util.*;
public class B_Find_Nth_Root_Of_M {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the N:");
        int n = input.nextInt();
        System.out.print("Enter the M:");
        int m = input.nextInt();

        //int val = brute(n,m);
        int val = optimal(n,m);

        System.out.println(n+" root of "+m+" :"+val);
    }
    //Brute
    public static int brute(int n , int m){
        for(int i=1; i<=m; i++){
            int val = check(i,n);
            if(val == m){
                return i;
            }
            else if(val > m){
                break;
            }
        }
        return -1;
    }
    public static int check(int val , int times){
        int result = 1;
        for(int i=1; i<= times; i++){
            result*=val;
        }
        return result;
    }
    //Optimal
    public static int optimal(int n , int m){
        int low = 1, high = m;
        while(low <= high){
            int mid = low + (high - low)/2;
            int val = checkPow(mid,n,m);
            if(val == 1){
                return mid;
            }
            else if(val == 0){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }
    public static int checkPow(int i,int n,int m){
        int val = (int) Math.pow(i,n);
        if(val == m ){
            return 1;
        }
        else if(val < m){
            return 0;
        }
        else{
            return 2;
        }
    }
}

//OUTPUT
/*
Enter the N:3 
Enter the M:27
3 root of 27 :3
*/
//-------------------------------------------------------------------------------------------------------------------
/*
Brute:
Time Complexity:O(M * N)
Space Complexity : O(1)

Optimal:
Time Complexity : O(N * log M)
Space Compelxity : O(1)

*/