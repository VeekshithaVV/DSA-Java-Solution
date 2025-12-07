//Leaders in an array
package F_Array.B_Medium_Array;

import java.util.*;
public class J_Superior_Elements {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the array size:");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for(int i=0; i<n; i++){
            arr[i] = input.nextInt();
        }
        //List<Integer> ans = brute(arr,n, new ArrayList<>());
        List<Integer> ans = optimal(arr, n , new ArrayList<>());
        System.out.println("Superior Elements are:");
        for(int num : ans){
            System.out.print(num+" ");
        }
    }
    //Brute
    public static List<Integer> brute(int[] arr , int n, List<Integer> res){
        for(int i=0; i<n; i++){
            boolean leader = true;
            for(int j=i+1; j<n; j++){
                if(arr[j] > arr[i]){
                    leader = false;
                    break;
                }
            }
            if(leader == true){
                res.add(arr[i]);
            }
        }
        return res;
    }
    //Optimal
    public static List<Integer> optimal(int[] arr , int n, List<Integer> res){
        int leader = Integer.MIN_VALUE;
        for(int i=n-1; i>=0; i--){
            if(arr[i] > leader){
                leader = arr[i];
                res.add(leader);
            }
        }
        return res;
    }
}

//OUTPUT
/*
Enter the array size:6
Enter the array elements:
10 22 12 3 0 6
Superior Elements are:
22 12 6 

Enter the array size:6
Enter the array elements:
10 22 12 3 0 6
Superior Elements are:
6 12 22
*/
//---------------------------------------------------------------------------------------------------------------
/*
Brute:
Time Complexity : O(N^2)
Space Complexity : O(N)

Optimal:
Time Complexity : O(N) (O(N log N) sort)
Space Complexity : O(N)
*/