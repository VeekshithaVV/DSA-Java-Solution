//Search a 2D Matrix II

package G_Binary_Search.C_BS_on_2D_Array;

import java.util.Scanner;

public class C_Search_in_2DMatrix_II {
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

        int[] res = optimal(mat,n,m,target);

        System.out.println("Row :"+res[0]);
        System.out.println("Column :"+res[1]);

    }
    public static int[] optimal(int[][] mat , int n, int m,int target){
        int row = 0, col = m-1;
        while(row < n && col >=0){
            int val = mat[row][col];
            if(val == target){
                return new int[]{row,col};
            }
            else if(val > target){
                col--;
            }
            else{
                row++;
            }
        }
        return new int[]{-1,-1};
    }
}
//OUTPUT
/*
Enter the n:5
Enter the m:5
Enter the array elements:
1 4 7 11 15
2 5 8 12 19
3 6 9 16 22
10 13 14 17 24
18 21 23 26 30
Enter the target:20
Row :-1
Column :-1
*/