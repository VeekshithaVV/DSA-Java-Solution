//Median of Two Sorted Arrays

package G_Binary_Search.B_BS_on_Answers;

import java.util.*;
public class L_Median_2Sorted_Array{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the arr1 size:");
        int n1 = input.nextInt();
        int[] arr1 = new int[n1];
        System.out.println("Enter the array1 elemenst:");
        for(int i=0; i<n1; i++){
            arr1[i] = input.nextInt();
        }

        System.out.print("Enter the arr2 size:");
        int n2 = input.nextInt();
        int[] arr2 = new int[n1];
        System.out.println("Enter the array2 elemenst:");
        for(int i=0; i<n2; i++){
            arr1[i] = input.nextInt();
        }

        //double median = brute(arr1,n1,arr2,n2);
        double median = optimal(arr1,arr2);

        System.out.println("Median of 2 Sorted Array:"+median);
    }
    //Brute
    public static double brute(int[] nums1, int n1 , int[] nums2, int n2){
         int[] merged = new int[n1 + n2];

        int i = 0, j = 0, k = 0;

        while(i < n1 && j < n2){
            if(nums1[i] <= nums2[j]){
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }

        while(i < n1){
            merged[k++] = nums1[i++];
        }

        while(j < n2){
            merged[k++] = nums2[j++];
        }

        int n = n1 + n2;

        if(n % 2 == 1){
            return merged[n / 2];
        }

        return (merged[n / 2] + merged[(n / 2) - 1]) / 2.0;
    }
    //Optimal
    public static double optimal(int[] nums1, int[] nums2){
        if(nums1.length > nums2.length){
            return optimal(nums2, nums1);
        }

        int n1 = nums1.length;
        int n2 = nums2.length;

        int low = 0;
        int high = n1;

        while(low <= high){

            int cut1 = (low + high) / 2;
            int cut2 = (n1 + n2 + 1) / 2 - cut1;

            int l1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int l2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];

            int r1 = (cut1 == n1) ? Integer.MAX_VALUE : nums1[cut1];
            int r2 = (cut2 == n2) ? Integer.MAX_VALUE : nums2[cut2];

            if(l1 <= r2 && l2 <= r1){

                if((n1 + n2) % 2 == 0){
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                }

                return Math.max(l1, l2);
            }

            else if(l1 > r2){
                high = cut1 - 1;
            }

            else{
                low = cut1 + 1;
            }
        }

        return 0.0;
    }

}
//OUTPUT
/*
Enter the array1 elemenst:
1 2 3 4
Enter the arr2 size:4      
Enter the array2 elemenst:
4 5 6 7
Median of 2 Sorted Array:2.0
*/
//------------------------------------------------------------------------------------------------------------
/*
Brute:
TC:- O(n1+ n2)
SC:- O(n1+ n2)

Optimal:
TC:- O(log2(min(n1,n2))
SC:- O(1)
*/