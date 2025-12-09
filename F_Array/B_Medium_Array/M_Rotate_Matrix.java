//Rotate Image by 90 degree

package F_Array.B_Medium_Array;

import java.util.*;
public class M_Rotate_Matrix {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the row size:");
        int row = input.nextInt();
        System.out.print("Enter the col size:");
        int col = input.nextInt();
        int[][] arr = new int[row][col];
        System.out.println("Enter the elements of 2D array:");
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                arr[i][j] = input.nextInt();
            }
        }
        //arr = brute(arr, row, col);
        optimal(arr,row,col);
        System.out.println("Rotated array:");
        for(int i = 0; i<row; i++){
            for(int j=0; j<col; j++){
                System.out.print(arr[i][j]+ " ");
            }
            System.out.println();
        }
    }
    //Brute
    public static int[][] brute(int[][] arr , int row, int col){
        int[][] ans = new int[row][col];
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                ans[j][row-i-1] = arr[i][j];
            }
        }
        return ans;
    }
    //Optimal
    public static void optimal(int[][] arr , int row, int col){
        //Traverse
        for(int i=0; i<row; i++){
            for(int j=i+1; j<row; j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        //Reverse row
        for(int i=0; i<row; i++){
            int left = 0;
            int right = row - 1;
            while(left < right){
                int temp = arr[i][left];
                arr[i][left] = arr[i][right];
                arr[i][right] = temp;
                left++;
                right--;
            }
        }
    }
}

//OUTPUT
/*
Enter the row size:4          
Enter the col size:4
Enter the elements of 2D array:
1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16
Rotated array:
13 9 5 1
14 10 6 2
15 11 7 3
16 12 8 4
*/
//------------------------------------------------------------------------------------------------------------------
/*
Brute:
Time Complexity : O(N*M)
Space Complexity : O(N * M)

Optimal:
Time Complexity : O(N^2)
Space Complexity : O(1)
*/