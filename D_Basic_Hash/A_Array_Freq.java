//Count frequency of each element in the array
package D_Basic_Hash;

import java.util.*;
public class A_Array_Freq {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the array size:");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for(int i=0; i<n; i++){
            arr[i] = input.nextInt();
        }
        hash_freq(n,arr);
    }
    public static void hash_freq(int n , int arr[]){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : arr){
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }
            else{
                map.put(num,1);
            }
        }
        //PRINT
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            System.out.println( entry.getKey() +" -> " + entry.getValue() );
        }
    }
}

//OUTPUT
/*
Enter the array size:10
Enter the array elements:
1 3 5 7 2 1 4 6 3 1
1 -> 3
2 -> 1
3 -> 2
4 -> 1
5 -> 1
6 -> 1
7 -> 1
*/
//----------------------------------------------------------------------------------------------------------------
/*
Time Complexity : O(N log N)
Space complexity : O(N)
*/