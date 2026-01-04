//Search Insert Position
package G_Binary_Search.A_BS_on_1D_Array;

import java.util.*;
public class D_Search_Insert_Position {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the array size:");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for(int i=0; i<n; i++){
            arr[i] = input.nextInt();
        }
        System.out.print("Enter the element to find the index:");
        int find = input.nextInt();

        int result = searchPosition(arr,n,find);
        System.out.println("Index:"+result);
    }
    public static int searchPosition(int[] arr , int n , int find){
        int low = 0 , high = n-1;
        int ans = n;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] >= find){
                ans = mid;
                high = mid - 1;
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
Enter the array size:4
Enter the array elements:
1 2 4 7
Enter the element to find the index:6
Index:3
*/