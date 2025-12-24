//4 SUM
package F_Array.C_Hard_Array;

import java.util.*;
public class D_4Sum {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the array size:");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for(int i=0; i<n; i++){
            arr[i] = input.nextInt();
        }
        System.out.print("Enter the target:");
        int target = input.nextInt();

        List<List<Integer>> res = new ArrayList<>();
        //res = brute(arr , n , target);
        //res = better(arr , n , target);
        res = optimal(arr , n , target);

        System.out.println("Result:");
        for(List<Integer> val : res){
            System.out.print(val+" ");
        }
    }
    //Brute
    public static List<List<Integer>> brute(int[] arr , int n , int target){
        HashSet<List<Integer>> set = new HashSet<>();
        for(int i=0; i<n-3; i++){
            for(int j=i+1; j<n-2; j++){
                for(int k=j+1; k<n-1; k++){
                    for(int l=k+1; l<n; l++){
                        long sum = (long) arr[i] + arr[j] + arr[k] + arr[l];
                        if(sum == target){
                            List<Integer> temp = Arrays.asList(arr[i],arr[j],arr[k],arr[l]);
                            Collections.sort(temp);
                            set.add(temp);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }
    //Better
    public static List<List<Integer>> better(int[] arr , int n , int target){
        HashSet<List<Integer>> set = new HashSet<>();
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                HashSet<Integer> seen = new HashSet<>();
                for(int k=j+1; k<n; k++){
                    long required = (long)target - (arr[i]+arr[j]+arr[k]);
                    if(seen.contains((int)required)){
                        List<Integer> temp = Arrays.asList(arr[i], arr[j] , arr[k] , (int)required);
                        Collections.sort(temp);
                        set.add(temp);
                    }
                    seen.add(arr[k]);
                }
            }
        }
        return new ArrayList<>(set);
    }
    //Optimal
    public static List<List<Integer>> optimal(int[] arr , int n , int target){
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        for(int i=0; i<n; i++){
            if(i != 0 && arr[i] == arr[i-1]){
                continue;
            }
            for(int j=i+1; j<n; j++){
                if(j != i+1 && arr[j] == arr[j-1]){
                    continue;
                }
                int k = j + 1;
                int l = n - 1;
                while (k < l) {
                    long sum = (long) arr[i] + arr[j] + arr[k] + arr[l];
                    if(sum == target){
                        List<Integer> temp = Arrays.asList(arr[i],arr[j],arr[k],arr[l]);
                        res.add(temp);
                        k++;
                        l--;
                        while(k < l && arr[k] == arr[k-1]){
                            k++;
                        }
                        while(k < l && arr[l] == arr[l+1]){
                            l--;
                        }
                    }
                    else if(sum < target){
                        k++;
                    }
                    else{
                        l--;
                    }
                }
            }
        }
        return res;
    }
}

//OUTPUT
/*
Enter the array size:6
Enter the array elements:
1 0 -1 0 -2 2
Enter the target:0
Result:
[-2, 0, 0, 2] [-1, 0, 0, 1] [-2, -1, 1, 2] 
*/
//-----------------------------------------------------------------------------------------------------------------------------
/*
Brute:
Time Complexity : O(N^4)
Space Complexity : O(2 * uniqure elements)

Better:
Time Complexity :O(N^3 + log(M))
Space Complexity : O(2 * unique elements)+O(N)

Optimal:
Time Complexity:O(N^3) + O(log N)->sort
Space Complexity:O(unique elements)
*/