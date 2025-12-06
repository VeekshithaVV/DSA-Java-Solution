//Find the Majority Element that occurs more than N/2 times
package F_Array.B_Medium_Array;

import java.util.*;
public class C_Majority_Element {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the array size:");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for(int i=0; i<n; i++){
            arr[i] = input.nextInt();
        }
        //int maj_ele = brute(arr,n);
        //int maj_ele = better(arr,n);
        int maj_ele = optimal(arr,n);
        System.out.println("Majority Element is:"+maj_ele);
    }
    //Brute
    public static int brute(int[] arr, int n){
        for(int i=0; i<n; i++){
            int count = 0;
            for(int j=0; j<n; j++){
                if(arr[i] == arr[j]){
                    count++;
                }
            }
            if(count > n/2){
                return arr[i];
            }
        }
        return -1;
    }
    //Better
    public static int better(int[] arr , int n){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : arr){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() > n/2){
                return entry.getKey();
            }
        }
        return -1;
    }
    //Optimal
    //More's Voting Algorithm
    public static int optimal(int[] arr , int n){
        int candidate = 0;
        int count = 0;
        for(int num : arr){
            if(count == 0){
                candidate = num;
            }
            if(num == candidate){
                count++;
            }
            else{
                count--;
            }
        }
        //verify
        count = 0;
        for(int num : arr){
            if(num == candidate){
                count++;
            }
        }
        if(count > n/2){
            return candidate;
        }
        return -1;
    }
}

//OUTPUT
/*
Enter the array size:9
Enter the array elements:
7 0 0 1 7 7 2 7 7
Majority Element is:7
*/
//-----------------------------------------------------------------------------------------------------------------------------------
/*
Brute:
Time Complexity : O(N^2)
Spaec Complexity : O(1)

Better:
Time Complexity : O(N)
Spaec Compelexity : O(1)

Optimal:
Time Complexity : O(N) (If majaority element not confiremend the verfy so )+O(N)
Spaec Complexity : O(1)
*/