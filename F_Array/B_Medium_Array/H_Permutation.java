//Permutation

package F_Array.B_Medium_Array;

import java.util.*;
public class H_Permutation {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the array sie:");
        int n = input.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the array elements:");
        for(int i=0; i<n; i++){
            nums[i] = input.nextInt();
        }
        //List<List<Integer>> ans = permute(nums);
        List<List<Integer>> ans = permute_B(nums);
        System.out.println("Permutation:");
        for(List<Integer> per : ans){
            System.out.print(per);
        }
    }
    //A.Using extra space
    public static List<List<Integer>> permute(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        recurPermute(nums , ds , ans , freq);
        return ans;
    }
    public static void recurPermute(int[] nums , List<Integer> ds , List<List<Integer>> ans , boolean[] freq){
        if(ds.size() == nums.length){
            ans.add(new ArrayList<>(ds));
        }
        for(int i=0; i<nums.length; i++){
            if(!freq[i]){
                //Check the number is alredy there,if not
                freq[i] = true; // mark first
                ds.add(nums[i]); //add the number
                recurPermute(nums, ds, ans, freq);//recur for the next number
                ds.remove(ds.size()-1); //befor move to previous ,remove the recently added number
                freq[i] = false; // unmark that number
            }
        }
    }
    //B.
    public static List<List<Integer>> permute_B(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        recurPermute_B(0, nums, ans);
        return ans;
    }
    public static void recurPermute_B(int index , int[] nums, List<List<Integer>> ans){
        if(index == nums.length){
            //copu nums values to ds - to add it to ans
            List<Integer> ds = new ArrayList<>();
            for(int num : nums){
                ds.add(num);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=index; i<nums.length; i++){
            swap(i , index , nums);
            recurPermute_B(index+1, nums, ans);
            swap(i, index, nums);
        }
    }
    public static void swap(int i , int j , int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

//OUTPUT
/*
Enter the array sie:3
Enter the array elements:
1 2 3
Permutation:
[1, 2, 3][1, 3, 2][2, 1, 3][2, 3, 1][3, 1, 2][3, 2, 1]
*/
//------------------------------------------------------------------------------------------------------------------
/*
Brute:A
Time Complexity : O(N! * N)
Spaec Complexity : O(N) + O(N) (freq and ds)
*/