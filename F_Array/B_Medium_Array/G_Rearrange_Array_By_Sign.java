//Rearrange Array Elements by Sign
//Case1: Array having equal count of +ves and -ves
//Case2: Array not having equal counts of +ve and -ves
package F_Array.B_Medium_Array;

import java.util.*;
public class G_Rearrange_Array_By_Sign {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the array elements:");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for(int i=0; i<n; i++){
            arr[i] = input.nextInt();
        }
        //brute(arr, n );
        //optimal(arr,n);
        bruteCase2(arr,n);
        System.out.println("Rearranged Array:");
        for(int num : arr){
            System.out.print(num+" ");
        }
    }
    //Brute:case1
    public static void brute(int[] arr, int n){
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        for(int num : arr){
            if(num < 0){
                neg.add(num);
            }
            else{
                pos.add(num);
            }
        }
        for(int i=0; i<n/2; i++){
            arr[2 * i] = pos.get(i);
            arr[2 * i + 1] = neg.get(i);
        }
    }
    //Optimal: cas1
    public static void  optimal(int[] arr, int n){
        int[] res = new int[n];
        int posIndex = 0;
        int negIndex = 1;
        for(int num : arr){
            if(num < 0){
                res[negIndex] = num;
                negIndex += 2;
            }
            else{
                res[posIndex] = num;
                posIndex += 2;
            }
        }
        for(int i=0; i<n; i++){
            arr[i] = res[i];
        }
    }
    //Brute :Case2
    public static void bruteCase2(int[] arr , int n){
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        for(int num : arr){
            if(num < 0){
                neg.add(num);
            }
            else{
                pos.add(num);
            }
        }
        if(pos.size() > neg.size()){
            for(int i=0; i<neg.size(); i++){
                arr[2*i] = pos.get(i);
                arr[2*i+1] = neg.get(i);
            }
            int index = neg.size() * 2;
            for(int i=neg.size(); i<pos.size(); i++){
                arr[index++] = pos.get(i);
            }
        }
        else{
            for(int i=0; i<pos.size(); i++){
                arr[2*i] = pos.get(i);
                arr[2*i+1] = neg.get(i);
            }
            int index = pos.size() * 2;
            for(int i=pos.size(); i<neg.size(); i++){
                arr[index++] = neg.get(i);
            }
        }
    }
}

//OUTPUT
/*
Enter the array elements:4        
Enter the array elements:
-1 -2 1 2
Rearranged Array:
1 -1 2 -2
*/
//-----------------------------------------------------------------------------------------------------------
/*
Brute:
Time Complexity : O(N) + O(N/2)
Space Complexity : O(N)

Optimal:
Time Complexity : O(N)
Space Complexity : O(N)

Brute:case2
Time Complexity : O(2N)
Space Complexity : O(N)
*/