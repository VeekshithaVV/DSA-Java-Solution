//Linear Search
package F_Array.A_Easy_Array;

import java.util.Scanner;
public class I_Linear_Search {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the size of array:");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for(int i=0; i<n; i++){
            arr[i] = input.nextInt();
        }
        System.out.print("Enter the search element:");
        int search = input.nextInt();
        int index = linear_Search(arr,n,search);
        System.out.println(search+" found in index number "+index);
    }
    public static int linear_Search(int[] arr , int n, int search){
        for(int i=0; i<n; i++){
            if(arr[i] == search){
                return i;
            }
        }
        return -1;
    }
}

//OUTPUT
/*
Enter the size of array:5
Enter the array elements:
1 3 5 6 8
Enter the search element:5
5 found in index number 2
*/
//-----------------------------------------------------------------------------------------------------------------
/*
Time Compexity : O(N)
Space Compexity : O(1)
*/