//Union of array
package F_Array.A_Easy_Array;

import java.util.*;
public class J_Find_Union {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the size of array1:");
        int n1 = input.nextInt();
        int[] arr1 = new int[n1];
        System.out.println("Enter the array 1 elements:");
        for(int i=0; i<n1; i++){
            arr1[i] = input.nextInt();
        }

        System.out.print("Enter the size of array 2:");
        int n2 = input.nextInt();
        int[] arr2 = new int[n2];
        System.out.println("Enter the array 2 elements:");
        for(int i=0; i<n2; i++){
            arr2[i] = input.nextInt();
        }

        //List<Integer> list = brute(arr1,n1,arr2,n2,new ArrayList<>());
        List<Integer> list = optimal(arr1,n1,arr2,n2,new ArrayList<>());
        System.out.println("Union of 2 array:");
        for(int num : list){
            System.out.print(num+" ");
        }
    }
    //Brute
    public static ArrayList<Integer> brute(int[] arr1, int n1 , int[] arr2, int n2 , ArrayList<Integer> list){
        HashSet<Integer> set = new HashSet<>();
        for(int num : arr1){
            set.add(num);
        }
        for(int num : arr2){
            set.add(num);
        }
        for(int num : set){
            list.add(num);
        }
        return list;
    }
    //Optimal
    public static ArrayList<Integer> optimal(int[] arr1 , int n1 ,int[] arr2 , int n2, ArrayList<Integer> list){
        int i = 0;
        int j = 0;
        while(i<n1 && j<n2){
            if(arr1[i] < arr2[j]){
                if(list.isEmpty() || list.get(list.size()-1) != arr1[i]){
                    list.add(arr1[i]);
                }
                i++;
            }
            else if(arr2[j] < arr1[i]){
                if(list.isEmpty() || list.get(list.size()-1) != arr2[j]){
                    list.add(arr2[j]);
                }
                j++;
            }
            else{
                if(list.isEmpty() || list.get(list.size()-1) != arr1[i]){
                    list.add(arr1[i]);
                }
                i++;
                j++;
            }
        }
        while(i < n1){
            if(list.isEmpty() || list.get(list.size()-1) != arr1[i]){
                list.add(arr1[i]);
            }
            i++;
        }
        while(j < n2){
            if(list.isEmpty() || list.get(list.size()-1) != arr2[j]){
                list.add(arr2[j]);
            }
            j++;
        }
        return list;
    }
}

//OUTPUT
/*
Enter the array 1 elements:
1 1 2 2 3 
Enter the size of array 2:8
Enter the array 2 elements:
1 2 3 4 4 5 6 6 
Union of 2 array:
1 2 3 4 5 6
*/
//-----------------------------------------------------------------------------------------------------------------------------
/*
Brute:
Time Complexity : O(N1) + O(N2) + O(N1+N2)
Space Complexity : O(N1 + O(N2)solve + O(N1 + N2)return

Optimal:
Time Complexity : O(N1) + O(N2)
Space Complexity : O(N1) + O(N2) return
*/