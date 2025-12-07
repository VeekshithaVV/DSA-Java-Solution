//Next Permutation
package F_Array.B_Medium_Array;

import java.lang.classfile.constantpool.IntegerEntry;
import java.util.*;
public class I_Next_Permutation {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the array size:");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for(int i=0; i<n; i++){
            arr[i] = input.nextInt();
        }
        // List<Integer> ans = brute(arr,n);
        // System.out.println("Nexp permutation :"+ans);
        optimal(arr,n);
        System.out.println("Next Permutation:");
        for(int num : arr){
            System.out.print(num+" ");
        }
    }
    //Brute
    public static List<Integer> brute(int[] arr , int n){
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> currentPerm = new ArrayList<>();
        for(int num : arr){
            currentPerm.add(num);
        }
        nextPermut(0,arr,ans);
        for(int i=0; i<ans.size(); i++){
            if(ans.get(i).equals(currentPerm)){
                if(i == ans.size() - 1){
                    return ans.get(0);
                }
                else{
                    return ans.get(i+1);
                }
            }
        }
        return currentPerm;
    }
    public static void nextPermut(int index , int[] arr , List<List<Integer>> ans){
        if(index == arr.length){
            List<Integer> ds = new ArrayList<>();
            for(int num : arr){
                ds.add(num);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=index; i<arr.length; i++){
            swap(i,index,arr);
            nextPermut( index+1, arr, ans);
            swap(i , index, arr);
        }
    }
    public static void swap(int i , int j , int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    //Optimal
    public static void optimal(int[] arr , int n){
        int index = -1;
        for(int i=n-2; i>=0; i--){
            if(arr[i] < arr[i+1]){
                index = i;
                break;
            }
        }
        if(index == -1){
            reverse(arr,0,n-1);
            return;
        }
        for(int i=n-1; i>index; i--){
            if(arr[i] > arr[index]){
                swap(index, i, arr);
                break;
            }
        }
        reverse(arr,index+1,n-1);
        return;
    }
    public static void reverse(int[] arr , int start , int end){
        while(start < end){
            swap(start, end, arr);
            start++;
            end--;
        }
    }
}

//OUTPUT
/*
Enter the array size:3
Enter the array elements:
1 2 3
Nexp permutation :[1, 3, 2]

Enter the array size:3
Enter the array elements:
3 2 1
Next Permutation:
1 2 3 
*/
//--------------------------------------------------------------------------------------------------------------------
/*
Brute:
Time Complexity : O(N * N!)
Space Complexity : O(N)

Optimal:
Time Complexity : O(N)
Space Complexity : O(1)
*/