//K-th Element of two sorted arrays
package G_Binary_Search.B_BS_on_Answers;

import java.util.*;
public class Kth_Ele_2Sorted_Array{
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
            arr2[i] = input.nextInt();
        }

        System.out.print("Enter the K:");
        int k = input.nextInt();

        int kthEle = optimal(arr1,arr2,k);

        System.out.println("Kth Element is :"+kthEle);
    }
    public static int optimal(int[] a, int[] b, int k) {
        int m = a.length;
        int n = b.length;

        // Ensure 'a' is the smaller array for optimization
        if (m > n) {
            return optimal(b, a, k);
        }

        int left = k; // Number of elements in the left partition
        int low = Math.max(0, k - n), high = Math.min(k, m);

        while (low <= high) {
            int mid1 = (low + high) >> 1;
            int mid2 = left - mid1;

            int l1 = (mid1 > 0) ? a[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? b[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 < m) ? a[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < n) ? b[mid2] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            } else if (l1 > r2) {
                high = mid1 - 1; // Move left
            } else {
                low = mid1 + 1; // Move right
            }
        }

        return -1; // Should never reach here if inputs are valid
    }
}
//OUTPUT
/*
Enter the arr1 size:5        
Enter the array1 elemenst:
2 3 6 7 9
Enter the arr2 size:4
Enter the array2 elemenst:
1 4 8 10 
Enter the K:5
Kth Element is :6
*/