//Merege 2 Sorted Array without Extra Space
package F_Array.C_Hard_Array;

import java.util.*;
public class H_Merge_2Sorted_Array {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the arr1 size:");
        int n = input.nextInt();
        int[] arr1 = new int[n];
        System.out.println("Enter the arr1 elements:");
        for(int i=0; i<n; i++){
            arr1[i] = input.nextInt();
        }

        System.out.print("Enter the arr2 size:");
        int m = input.nextInt();
        int[] arr2 = new int[m];
        System.out.println("Enter the arr2 elements:");
        for(int i=0; i<m; i++){
            arr2[i] = input.nextInt();
        }

        //brute(arr1,n,arr2,m);
        //optimal1(arr1,n,arr2,m);
        optimal2(arr1,n,arr2,m);

        System.out.println("After Merge:arr1");
        for(int num : arr1){
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println("After Merge:arr2");
        for(int num : arr2){
            System.out.print(num+" ");
        }
    }
    //Brute
    public static void brute(int[] arr1 , int n , int[] arr2 , int m){
        int[] temp = new int[n + m];
        int left = 0, right = 0, index = 0;
        while(left < n && right < m){
            if(arr1[left] <= arr2[right]){
                temp[index++] = arr1[left++];
            }
            else{
                temp[index++] = arr2[right++];
            }
        }
        while(left < n){
            temp[index++] = arr1[left++];
        }
        while(right < m){
            temp[index++] = arr2[right++];
        }
        for(int i=0; i<temp.length; i++){
            if(i < n){
                arr1[i] = temp[i];
            }
            else{
                arr2[i - n] = temp[i];
            }
        }
    }
    //Optimal1
    public static void optimal1(int[] arr1 , int n , int[] arr2 , int m){
        int left = n - 1;
        int right = 0;
        while(left >= 0 && right < m){
            if(arr1[left] > arr2[right]){
                int temp = arr1[left];
                arr1[left] = arr2[right];
                arr2[right] = temp;
            }
            else{
                break;
            }
            left--;
            right++;
        }
        Arrays.sort(arr1 , left , n);
        Arrays.sort(arr2);
    }
    //Optimal2
    public static void optimal2(int[] arr1 , int n , int[] arr2 , int m){
        int len = (n + m);
        int gap = (len / 2) + (len % n);
        while(gap > 0){
            int left = 0;
            int right = left + gap;
            while(right < len){
                //arr1 and arr2
                if(left < n && right >= n ){
                    swapIfGreater(arr1 , arr2 , left , right - n);
                }
                //arr2 and arr2
                else if(left >= n){
                    swapIfGreater(arr1 , arr2 , left - n , right - n);
                }
                //arr1 and arr1
                else{
                    swapIfGreater(arr1, arr2 , left , right);
                }
                left++;
                right++;
            }
            if(gap == 1){
                break;
            }
            else{
                gap = (gap/2)+(gap%2);
            }
        }
    }
    public static void swapIfGreater(int[] arr1 , int[] arr2 , int i , int j){
        if(arr1[i] > arr2[j]){
            int temp = arr1[i];
            arr1[i] = arr2[j];
            arr2[j] = temp;
        }
    }
}

//OUTPUT
/*
Enter the arr1 size:4
Enter the arr1 elements:
1 2 8 9
Enter the arr2 size:5
Enter the arr2 elements:
3 4 5 6 7
After Merge:arr1
1 2 3 4
After Merge:arr2
5 6 7 8 9
*/
//----------------------------------------------------------------------------------------------------------------------------
/*
Brute:
Time Complexity : O(N + M) + O(N + M)
Space Complexity : O(N + M)

Optimal1:
Time Complexity : O(min(N,M)) + O(N log N) + O(N log M)
Space Complexity : O(1)

Optimal2:
Time Complexity : O(log2 (N+M)) + O(N + M)
Space Complexity : O(1)
*/