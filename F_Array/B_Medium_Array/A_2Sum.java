//2 sum 
// return bollean / indexs
package F_Array.B_Medium_Array;

import java.util.*;
public class A_2Sum {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the array size:");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for(int i=0; i<n; i++){
            arr[i] = input.nextInt();
        }
        System.out.print("Enter the target sum:");
        int target = input.nextInt();

        //int[] temp = brute(arr,n,target,new int[2]);
        // String res = better(arr,n,target);
        // System.out.println("Sum of 2 values equal to target is preset:"+res);
        int[] temp = optimal(arr,n,target,new int[2]);
        System.out.println("Inedx are:");
        for(int num : temp){
            System.out.print(num+" ");
        }
    }
    //Brute
    public static int[] brute(int[] arr , int n, int target ,int[] res){
        res = new int[]{-1,-1};
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(arr[i] + arr[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return res;
    }
    //Better
    public static String better(int[] arr, int n , int target){
        Arrays.sort(arr);
        int left = 0;
        int right = n-1;
        while(left < right){
            int sum = arr[left] + arr[right];
            if(sum == target){
                return "Yes";
            }
            else if(sum < target){
                left++;
            }
            else{
                right--;
            }
        }
        return "No";
    }
    //Optimal
    public static int[] optimal(int[] arr, int n , int target, int[] res){
        HashMap<Integer,Integer> map = new HashMap<>();
        res = new int[]{-1,-1};
        for(int i=0; i<n; i++){
            int complement = target - arr[i];
            if(map.containsKey(complement)){
                res = new int[]{i, map.get(complement)};
                break;
            }
            map.put(arr[i] , i);
        }
        return res;
    }
}

//OUTPUT
/*
Enter the array size:5
Enter the array elements:
1 2 3 4 5
Enter the target sum:5
Inedx are:
0 3 

Enter the array size:5        
Enter the array elements:
1 2 3 4 5
Enter the target sum:4
Sum of 2 values equal to target is preset:Yes
*/
//-------------------------------------------------------------------------------------------------------------------
/*
Brute:
Time Complexity : O(N2)
SPace Complexity : O(1)

Better:
Time Complexity : O(N)+O(N logN)sort
SPace Complexity : O(1)

Optimal:
Time Complexity : O(N)
Space Complexity : O(N)
*/