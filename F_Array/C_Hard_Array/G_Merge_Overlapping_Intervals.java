//Merge Overlapping Sub-intervals
package F_Array.C_Hard_Array;

import java.util.*;
public class G_Merge_Overlapping_Intervals {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of intervals:");
        int n = input.nextInt();
        int[][] arr = new int[n][2];
        System.out.println("Enter the elemets:");
        for(int i=0; i<n; i++){
            arr[i][0] = input.nextInt();
            arr[i][1] = input.nextInt();
        }
        //List<List<Integer>> result = brute(arr,n);
        List<List<Integer>> result = optimal(arr,n);
        for(List<Integer> res : result){
            System.out.print(res+" ");
        }
    }
    //Brute
    public static List<List<Integer>> brute(int[][] arr , int n){
        Arrays.sort(arr, (a,b) -> a[0]-b[0]);
        List<List<Integer>> res = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            int start = arr[i][0];
            int end = arr[i][1];

            //Skip if alredy merged
            if(!res.isEmpty() && start <= res.get(res.size()-1).get(1) ){
                continue;
            }

            for(int j=i+1; j<n; j++){
                if(arr[j][0] < end ){
                    end = Math.max(end , arr[j][1]);
                }
                else{
                    break;
                }
            }
            res.add(Arrays.asList(start,end));
        }
        return res;
    }
    //Optimal
    public static List<List<Integer>> optimal(int[][] arr , int n){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr , (a,b) -> Integer.compare(a[0], b[0]));

        for(int[] interval : arr){
            if(result.isEmpty() || result.get(result.size()-1).get(1) < interval[0]){
                result.add(Arrays.asList(interval[0], interval[1]));
            }
            else{
                int last = result.get(result.size()-1).get(1);
                int maxEnd = Math.max(last ,interval[1] );
                result.get(result.size()-1).set(1,maxEnd);
            }
        }
        return result;
    }
}

//OUTPUT
/*
Enter the number of intervals:8    
Enter the elemets:
1 3
2 6
8 9
9 11
8 10
2 4 
15 18
16 17
[1, 6] [8, 11] [15, 18] 
*/
//------------------------------------------------------------------------------------------------------------------
/*
Brute:
Time Complexity : O(N log N) + O(N^2) ~ O(N^2)
Space Complexity : O(N)

Optimal:
Time Complexity : O(N log N)
Space Complexity : O(N)
*/