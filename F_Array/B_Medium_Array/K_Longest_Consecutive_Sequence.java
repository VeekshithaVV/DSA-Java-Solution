//Longest Consecutive Sequence
package F_Array.B_Medium_Array;

import java.util.*;
public class K_Longest_Consecutive_Sequence {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the aize of tha array:");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for(int i=0; i<n; i++){
            arr[i] = input.nextInt();
        }
        //int longest = brute(arr,n);
        //int longest = better(arr,n);
        int longest = optimal(arr,n);
        System.out.println("Longest consecutive sequence is : "+longest);
    }
    //Brute
    public static int brute(int[] arr , int n){
        int longest = 1;
        for(int i=0; i<n; i++){
            int count = 1;
            int num = arr[i];
            while(linearSearch(arr,num+1) == true){
                count += 1;
                num += 1;
            }
            longest = Math.max(longest, count);
        }
        return longest;
    }
    public static boolean linearSearch(int[] arr , int n){
        for(int num: arr){
            if(num == n){
                return true;
            }
        }
        return false;
    }
    //Better
    public static int better(int[] arr , int n){
        Arrays.sort(arr);
        int longest = 1;
        int count = 1;
        int lastSmall = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            if(arr[i]-1 == lastSmall) {
                count += 1;
                lastSmall = arr[i];
            }
            else if(arr[i] != lastSmall){
                count = 1;
                lastSmall = arr[i];
            }
            longest = Math.max(longest , count);
        }
        return longest;
    }
    //Optimal
    public static int optimal(int[] arr , int n){
        if(n == 0){
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        int longest = 1;
        for(int num : arr){
            set.add(num);
        }
        for(int ele : set){
            if(!set.contains(ele - 1)){
                int count = 1;
                int a = ele;
                while(set.contains(a+1)){
                    a = a + 1;
                    count += 1;
                }
                longest = Math.max(longest,count);
            }
        }
        return longest;
    }
}

//OUTPUT
/*
Enter the aize of tha array:9
Enter the array elements:
102 4 100 1 101 3 2 1 1
Longest consecutive sequence is : 4
*/
//-------------------------------------------------------------------------------------------------------------
/*
Brute:
Time Complexity : O(N) * O(N) ~ O(N^2)
Space Complexity : O(1)

Better:
Time Complexity : O(N) + O(N log N)
Space Complexity : O(1)

Optimal:
Time Complexity : O(N) + O(N) ~ O(2N)
Space Compelxity: O(N)
*/