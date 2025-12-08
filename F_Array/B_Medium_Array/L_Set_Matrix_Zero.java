//Set Matrix Zero
package F_Array.B_Medium_Array;

import java.util.*;
public class L_Set_Matrix_Zero {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the row size:");
        int row = input.nextInt();
        System.out.print("Enter the column size:");
        int col = input.nextInt();
        int[][] arr = new int[row][col];
        System.out.println("Enter the matrix elements:");
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                arr[i][j] = input.nextInt();
            }
        }
        //brute(arr,row,col);
        //better(arr,row,col);
        optimal(arr,row,col);
        System.out.println("Result Matrix:");
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    //Brute
    public static void brute(int[][] matrix , int row , int col){
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(matrix[i][j] == 0){
                    markRow(i,matrix);
                    markCol(j,matrix);
                }
            }
        }
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(matrix[i][j] == -1){
                    matrix[i][j] = 0;
                }
            }
        }
        
    }
    public static void markRow(int row, int[][] matrix){
        int col = matrix[0].length;
        for(int j=0; j<col; j++){
            if(matrix[row][j] != 0){
                matrix[row][j] = -1;
            }
        }
    }
    public static void markCol(int col,int[][] matrix){
        int row = matrix.length;
        for(int i=0; i<row; i++){
            if(matrix[i][col] != 0){
                matrix[i][col] = -1;
            }
        }
    }
    //Better
    public static void better(int[][] matrix , int row , int col){
        boolean[] rowArray = new boolean[row];
        boolean[] colArray = new boolean[col];

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(matrix[i][j] == 0){
                    rowArray[i] = true;
                    colArray[j] = true;
                }
            }
        }
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(rowArray[i] || colArray[j]){
                    matrix[i][j] = 0;
                }
            }
        }
    }
    //Optimal
    public static void optimal(int[][] matrix , int row, int col){
        int col0 = 1;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    if(j != 0){
                        matrix[0][j] = 0;
                    }
                    else{
                        col0 = 0;
                    }
                }
            }
        }
        for(int i=1; i<row; i++){
            for(int j=1; j<col; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        if(matrix[0][0] == 0){
            for(int j=0; j<col; j++){
                matrix[0][j] = 0;
            }
        }
        if(col0 == 0){
            for(int i=0; i<row; i++){
                matrix[i][0] = 0;
            }
        }
    }
}

//OUTPUT
/*
Enter the row size:3
Enter the column size:4
Enter the matrix elements:
1 1 1 1 1 0 0 1 1 1 0 1
Result Matrix:
1 0 0 1
0 0 0 0
0 0 0 0
*/
//-------------------------------------------------------------------------------------------------------
/*
Brute:
Time Complexity : O(N * M) + O(N + M) + O(N * M)
Space Complexity : O(N * M)

Better:
Time Complexity : O(N * M) + O(N * M)
Space Complexity :O(N + M)

Optimal:
Time Complexity : O(N * M) + O(N * M)
Space Complexity: O(1)
*/