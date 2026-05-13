// Search a 2D Matrix
/*
Leetcode:
You are given an m x n integer matrix matrix with the following two properties:
Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.

GFG:
Given a 2D integer matrix mat[][] of size n x m, 
where every row and column is sorted in increasing order
a number x, the task is to find whether element x is present in the matrix.
*/

package G_Binary_Search.C_BS_on_2D_Array;

import java.util.*;
public class B_Search_in_2DMatrix{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the n:");
        int n = input.nextInt();
        System.out.print("Enter the m:");
        int m = input.nextInt();
        int[][] mat = new int[n][m];
        System.out.println("Enter the array elements:");
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                mat[i][j] = input.nextInt();
            }
        }
        System.out.print("Enter the target:");
        int target = input.nextInt();

        //boolean res = brute(mat,n,m,target);
        //boolean res = better(mat,n,m,target);
        //boolean res = optimalLC(mat,n,m,target);
        boolean res = optimalGFG(mat,n,m,target);

        System.out.println("Result:"+res);
    }
    //Brute
    public static boolean brute(int[][] mat , int n , int m , int target){
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j] == target){
                    return true;
                }
            }
        }
        return false;
    }
    
    //Better
    public static boolean better(int[][] mat , int n , int m , int target){
        for(int i=0; i<n; i++){
            boolean find = binarySerach(mat[i] ,target);
            if(find){
                return true;
            }
        }
        return false;
    }
    public static boolean binarySerach(int[] arr , int target){
        int n = arr.length;
        int low = 0 , high = n-1;
        while(low <= high){
            int mid = (low + high)/2;
            if(arr[mid] == target){
                return true;
            }
            else if(arr[mid] > target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return false;
    }
   
    //Optimal LeetCode
    public static boolean optimalLC(int[][] mat , int n , int m , int target){
        int low = 0 , high = (n * m) - 1;
        while(low <= high){
            int mid = (low + high)/2;
            int val = mat[mid/m][mid%m];
            if(val == target){
                return true;
            }
            else if(val > target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return false;
    }
    
    //Optimal GFG
    public static boolean optimalGFG(int[][] mat, int n , int m , int target){
        int i = 0 , j = m - 1;
        while(i<n && j>=0){
            if(mat[i][j] == target){
                return true;
            }
            else if(mat[i][j] > target){
                j--;
            }
            else{
                i++;
            }
        }
        return false;
    }
}
//OUTPUT
/*
GFG
Enter the m:3
Enter the array elements:
3 30 38
20 52 54
35 60 69
Enter the target:62
Result:false

LC:
Enter the n:3
Enter the m:4
Enter the array elements:
1 3 5 7
10 11 16 20
23 30 34 60
Enter the target:3
Result:true

*/
//----------------------------------------------------------------------------------------------------------------------------------
/*
Brute:
TC:- O(N * M)
SC:- O(1)

Better:
TC:- O(N * log2(M))
SC:- O(1)

OptimalLC:
TC:- O(log2(N * M))
SC:- O(1)

OptimalGFG:
TC:- O(N + M)
SC:- O(1)
*/