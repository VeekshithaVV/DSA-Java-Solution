//Floor and Ceil in Sorted Array
//The floor of x is the largest element in the array which is smaller than or equal to x. 
//The ceiling of x is the smallest element in the array greater than or equal to x
package G_Binary_Search.A_BS_on_1D_Array;

import java.util.*;
public class E_Floor_Ceil {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the array size:");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the array elements in sorted :");
        for(int i=0; i<n; i++){
            arr[i] = input.nextInt();
        }
        System.out.print("Enter the value of X:");
        int x = input.nextInt();

        int[] ans = find(arr,n,x);
        System.out.println("Floor :"+ans[0]);
        System.out.println("Ceil :"+ans[1]);
    }
    public static int[] find(int[] arr , int n , int x){
        int[] ans = new int[2];
        ans[0] = findFloor(arr,n,x);
        ans[1] = findCeil(arr,n,x);

        return ans;
    }
    //Floor
    public static int findFloor(int[] arr , int n , int x){
        int low = 0, high = n-1, ans = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] <= x){
                ans = arr[mid];
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return ans;
    }
    //Ceil
    public static int findCeil(int[] arr , int n , int x){
        int low = 0, high = n-1, ans = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] >= x){
                ans = arr[mid];
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
Enter the array size:5
Enter the array elements in sorted :
10 20 30 40 50
Enter the value of X:25
Floor :20
Ceil :30
*/