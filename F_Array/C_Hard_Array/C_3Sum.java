//3SUM Problem
package F_Array.C_Hard_Array;

import java.util.*;
public class C_3Sum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the array size:");
        int size = input.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter the array elements:");
        for(int i=0; i<size; i++){
            arr[i] = input.nextInt();
        }
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        //list = brute(arr,size);
        //list = better(arr,size);
        list = optimal(arr,size);

        System.out.println("Result:");
        for(ArrayList<Integer> triplet : list){
            System.out.println(triplet);
        }
    }
    //Brute
    public static ArrayList<ArrayList<Integer>> brute(int[] arr , int n){
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        for(int i=0; i<n-2; i++){
            for(int j=i+1; j<n-1; j++){
                for(int k=j+1; k<n; k++){
                    if(arr[i] + arr[j] + arr[k] == 0){
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[k]);
                        Collections.sort(temp);
                        set.add(temp);
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }
    //Better
    public static ArrayList<ArrayList<Integer>> better(int [] arr , int n){
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        for(int i=0; i<n-1; i++){
            HashSet<Integer> hashset = new HashSet<>();
            for(int j=i+1; j<n; j++){
                int third = -(arr[i] + arr[j]);
                if(hashset.contains(third)){
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(arr[i]);
                    temp.add(arr[j]);
                    temp.add(third);
                    Collections.sort(temp);
                    set.add(temp);
                }
                hashset.add(arr[j]);
            }
        }
        return new ArrayList<>(set);
    }
    //Optimal
    public static ArrayList<ArrayList<Integer>> optimal(int[] arr , int n){
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(i>0 && arr[i] == arr[i-1]){
                continue;
            }
            int j = i+1;
            int k = n-1;
            while(j < k){
                int sum = arr[i] + arr[j] + arr[k];
                if(sum == 0){
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(arr[i]);
                    temp.add(arr[j]);
                    temp.add(arr[k]);
                    list.add(temp);
                    j++;
                    k--;

                    while(j<k && arr[j] == arr[j-1]){
                        j++;
                    }
                    while(j < k && arr[k] == arr[k+1]){
                        k--;
                    }
                }
                else if(sum < 0){
                    j++;
                }
                else{
                    k--;
                }
            }
        }
        return list;
    }
}
//OUTPUT
/*
Enter the array size:6
Enter the array elements:
-1 0 1 2 -1 -4
Result:
[-1, -1, 2]
[-1, 0, 1]
*/
//---------------------------------------------------------------------------------------------------------------------------
/*
Brute:
Time Complexity: O(N^3) due to three nested loops.
Space Complexity: O(M) where M is the number of unique triplets found.

Better:
Time Complexity : O(N^2) 
Space Complexity : O(N) + O(N)

Optimal:
Time Complexity : O(N) + O(N log N)
Space Complexity : O(1)
*/
