//Sperial Matrix
package F_Array.B_Medium_Array;

import java.util.ArrayList;
import java.util.Scanner;

public class N_Spiral_Matrix {
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
        ArrayList<Integer> ans = spiralMatrix(arr,row,col, new ArrayList<>());
        System.out.println("Sprial Matrix:");
        for(int num : ans){
            System.out.print(num+" ");
        }
    }
    public static ArrayList<Integer> spiralMatrix(int[][] arr , int row, int col , ArrayList<Integer> ans){
        int top = 0; //starting row
        int bottom = row - 1; //ending row

        int left = 0; //staring col
        int right = col - 1; //ending col
        while(top <= bottom  && left <= right) {
            //Traverse Top : left to right and increment top
            for(int i=left; i<=right; i++){
                ans.add(arr[top][i]);
            }
            top++;

            //Traverse Right : top to bottom and decrement right
            for(int i=top; i<=bottom; i++){
                ans.add(arr[i][right]);
            }
            right--;
            if(top <= bottom){//condition checks when arr is 1D
                //Travers Bottom : right to left and decrement bottom
                for(int i=right; i>=left; i--){
                    ans.add(arr[bottom][right]);
                }
                bottom--;
            }
            if(left <= right){
                //Traverse left : bottom to top and incerment left
                for(int i=bottom; i>=top; i--){
                    ans.add(arr[left][i]);
                }
                left++;
            }
        }
        return ans;
    }
}

//OUTPUT
/*
Enter the matrix elements:
1 1 1 1
2 2 2 2
3 3 3 3
4 4 4 4
Sprial Matrix:
1 1 1 1 2 3 4 4 4 4 1 1 2 2 3 3
*/
//-------------------------------------------------------------------------------------------------------------------
/*
Time Complexity : O(N * M)
Space Complexity : O(N * M)-store
*/