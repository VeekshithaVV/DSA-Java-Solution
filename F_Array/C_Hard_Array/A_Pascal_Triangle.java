//PASCAL'S TRIANGLE
//1.Print a element at given row and column number
//2.Print all the elements of nth row number
//3.Print pascal's triangle for the given row and col

package F_Array.C_Hard_Array;

import java.util.*;
public class A_Pascal_Triangle {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the row:");
        int row = input.nextInt();
        System.out.print("Enter the col:");
        int col = input.nextInt();

        // //1.
        // int val = pascalEle(row-1,col-1);
        // System.out.println("Pascal Elements at "+row +"th row and "+col+"th col is: "+val);

        // //2.
        // ArrayList<Integer> res = pascalRow(row, new ArrayList<>());
        // System.out.println("Pascal Triangle "+row+"th is:");
        // for(int num : res){
        //     System.out.print(num+" ");
        // }

        //3.
        ArrayList<List<Integer>> res = pascal(row,col, new ArrayList<>());
        System.out.println("PAscal Triangle:");
        for(List<Integer> val : res){
            System.out.print(val);
        }

    }
    //Variety:1
    public static int pascalEle(int row, int col){
        int res = 1;
        for(int i=0; i<col; i++){
            res *= (row - i);
            res /= (i+1);
        }
        return res;
    }
    //Variety:2
    public static ArrayList<Integer> pascalRow(int n ,ArrayList<Integer> res){
        int ans = 1;
        res.add(ans);
        for(int i=1; i<n; i++){
            ans *= (n - i);
            ans /= i;
            res.add(ans);
        }
        return res;
    }
    //Variety:3
    public static ArrayList<List<Integer>> pascal(int row, int col, ArrayList<List<Integer>> res){
        if(row == 0){
            return res;
        }
        pascal(row-1, col, res);

        long result = 1;
        ArrayList<Integer> rowval = new ArrayList<>();
        rowval.add((int)result);

        for(int i=1; i<row; i++){
            result *= (row - i);
            result /= (i);
            rowval.add((int)result);
        }
        res.add(rowval);
        return res;
        
    }
}

//OUTPUT
/*
Enter the row:5
Enter the col:3
Pascal Elements at 5th row and 3th col is: 6

Enter the row:5
Enter the col:0
Pascal Triangle 5th is:
1 4 6 4 1 

Enter the row:5
Enter the col:5
PAscal Triangle:
[1][1, 1][1, 2, 1][1, 3, 3, 1][1, 4, 6, 4, 1]
*/
//-----------------------------------------------------------------------------------------------------------------
/*
1.
Time Complexity : O(col)
SPace Complexity : O(1)

2.
Time Complexity : O(N)
Space Compelxity :O(1)

3.
Time Complexity : O(N)
Space Complexity :O(1)
*/