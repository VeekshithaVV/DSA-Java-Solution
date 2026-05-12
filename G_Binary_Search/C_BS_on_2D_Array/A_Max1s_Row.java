//Row With Maximum Ones
package G_Binary_Search.C_BS_on_2D_Array;

import java.util.*;
public class A_Max1s_Row {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        //n*m
        System.out.print("Enter the n:");
        int n = input.nextInt();
        System.out.print("Enter the m:");
        int m = input.nextInt();

        int[][] mat = new int[n][m];
        System.out.println("Enter the matrix elements:");
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                mat[i][j] = input.nextInt();
            }
        }

        //int index = brute(mat,n,m);
        int index = optimal(mat,n,m);

        System.out.println("Max 1s Index:"+index);
    }
    //Brute
    public static int brute(int[][] mat , int n , int m){
        int maxCount = -1, index = 1;
        for(int i=0; i<n; i++){
            int countRow = 0;
            for(int j=0; j<m; j++){
                countRow += mat[i][j];
            }
            if(countRow > maxCount){
                maxCount = countRow;
                index = i;
            }
        }
        if(maxCount == 0){
            return -1;
        }
        return index;
    }
    //Optimal
    public static int optimal(int[][] mat , int n , int m){
        int maxCount = 0, index = -1;
        for(int i=0; i<n; i++){
            int countOnes = m - lowerBound(mat[i],m,1);
            if(countOnes > maxCount){
                maxCount = countOnes;
                index = i;
            }
        }       
        return index;
    }
    public static int lowerBound(int[] arr , int n , int x){
        int low = 0 , high = n-1, ans = n;
        while(low <= high){
            int mid = (low + high)/2;
            if(arr[mid] >= x){
                ans = mid;
                high = mid -1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
}

//OUTPUT
/*
Enter the n:2
Enter the m:2
Enter the matrix elements:
0 1
1 0
Max 1s Index:0

Enter the n:3    
Enter the m:3    
Enter the matrix elements:
0 0 0
0 0 0
0 0 0
Max 1s Index:-1

*/

//-----------------------------------------------------------------------------------------------------------------------
/*
Brute
TC:- O(N * M)
SC:- O(1)

Optimal:
TC:- O(N * log2(M))
SC:- O(1) 
*/