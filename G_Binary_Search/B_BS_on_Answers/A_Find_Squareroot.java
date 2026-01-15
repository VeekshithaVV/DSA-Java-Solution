//Find Square Root of an Integer
package G_Binary_Search.B_BS_on_Answers;

import java.util.*;
public class A_Find_Squareroot {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number:");
        int n= input.nextInt();
        
        int val = squrRoot(n);
        System.out.println("Square Root of "+n+" is :"+val);
    }
    public static int squrRoot(int n){
        int ans = 1;
        int low = 1 , high = n;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(mid * mid <= n){
                ans = mid;
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return ans;
        // return high;
    }
}

//OUTPUT
/*
Enter the number:26
Square Root of 26 is :5  //floor val
*/
