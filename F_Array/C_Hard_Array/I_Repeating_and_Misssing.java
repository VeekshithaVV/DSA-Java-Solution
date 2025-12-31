//Repeating & Missing number in array
package F_Array.C_Hard_Array;

import java.util.*;
public class I_Repeating_and_Misssing {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the array size :");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for(int i=0; i<n; i++){
            arr[i] = input.nextInt();
        }
        List<Integer> res = new ArrayList<>();
        //res = brute(arr,n);
        //res = better(arr,n);
        res = optimal(arr,n);

        System.out.println("Missing:"+res.get(0));
        System.out.println("Repeating:"+res.get(1));
    }
    //Brute
    public static List<Integer> brute(int[] arr , int n){
        int missing = -1;
        int repeating = -1;
        for(int i=1; i<= n ; i++){
            int count = 0;
            for(int j = 0; j<n; j++){
                if(i == arr[j]){
                    count++;
                }
            }
            if(count == 2){
                repeating = i;
            }
            else if(count == 0){
                missing = i;
            }

            if(missing != -1 && repeating != -1){
                break;
            }
        }
        List<Integer> res = Arrays.asList(missing,repeating);
        return res;
    }
    //Better
    public static List<Integer> better(int[] arr , int n){
        int[] hash = new int[n+1];
        for(int num : arr){
            int index = num;
            hash[index]++;
        }
        int missing = -1;
        int repeating = -1;
        for(int i=1; i<=n; i++){
            if(hash[i] == 2){
                repeating = i;
            }
            else if(hash[i] == 0){
                missing = i;
            }

            if(missing != -1 && repeating != -1){
                break;
            }
        }
        List<Integer> res = Arrays.asList(missing,repeating);
        return res;
    }
    //Optimal
    public static List<Integer> optimal(int[] arr , int n){
        int S = (n * (n + 1))/2;
        int S2 = (n * (n + 1) * (2 * n + 1))/6;
        int Sn = 0 , S2n = 0;
        for(int num : arr){
            Sn += num;
            S2n += (num * num);
        }
        int val1 = S - Sn;
        int val2 = S2 - S2n;
        val2 = val2 / val1;
        int x = (val1 + val2) / 2;
        int y = x - val1;

        List<Integer> res = Arrays.asList(x ,y);
        return res;
    }
}

//OUTPUT
/*
Enter the array size :6
Enter the array elements:
4 3 6 2 1 1
Missing:5
Repeating:1
*/
//-------------------------------------------------------------------------------------------------------------------------
/*
Brute:
Time Complexity : O(N^2)
Space Complexity : O(1)

Better:
Time Complexity : O(2N)
Space Complexity : O(N)

Optimal:
Time Compelxity : O(N)
Space Complexity : O(1)
*/
