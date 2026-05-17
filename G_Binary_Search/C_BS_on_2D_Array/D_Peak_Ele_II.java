//Peak Element 
//A peak element in a 2D grid is an element that is strictly greater than all of its adjacent 
// neighbors to the left, right, top, and bottom.

package G_Binary_Search.C_BS_on_2D_Array;

import java.util.*;
public class D_Peak_Ele_II {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the n:");
        int n = input.nextInt();
        System.out.print("Enter the m:");
        int m = input.nextInt();

        int[][] mat = new int[n][m];
        System.out.println("Enter the elements of matrix:");
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                mat[i][j] = input.nextInt();
            }
        }

        int[] res = findPeak(mat,n,m);

        System.out.println("Row:"+res[0]+"  Col:"+res[1]);

    }
    public static int[] findPeak(int[][] mat, int n , int m){
        int low = 0, high = n - 1;
        while(low <= high){
            int mid = (low + high)/2;
            int row = maxElement(mat,n,m,mid);

            int left = mid - 1 >= 0 ? mat[row][mid-1] : -1;
            int right = mid + 1 < mid ? mat[row][mid+1] : -1;

            if(mat[row][mid] > left  && mat[row][mid] > right){
                return new int[]{row,mid};
            }
            else if(left > mat[row][mid]){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return new int[] {-1,-1};
    }
    public static int maxElement(int[][]mat, int n , int m , int col){
        int max = -1, index = -1;
        for(int i=0; i<n; i++){
            if(mat[i][col] > max){
                max = mat[i][col];
                index = i;
            }
        }
        return index;
    }
}

//OUTPUT
/*
Enter the n:3
Enter the m:3
Enter the elements of matrix:
10 20 15
21 30 14
7 16 32
1 1
*/
//-------------------------------------------------------------------------------------------------------------------------
/*
TC: O(log2 M * N);
SC: O(1)
*/