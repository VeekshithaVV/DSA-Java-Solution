//Intersection Of 2 Array
package F_Array.A_Easy_Array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class P_Find_Intersection {
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
    public static ArrayList<Integer> brute(int[] arr1, int n1 , int[] arr2 , int n2 , ArrayList<Integer> list){
        int[] visit = new int[n2];
        Arrays.fill(visit, 0);
        for(int i=0; i<n1; i++){
            for(int j=0; j<n2; j++){
                if(arr1[i] == arr2[j] && visit[j] == 0){
                    list.add(arr1[i]);
                    visit[j] = 1;
                    break;
                }
                if(arr2[j] > arr1[i]){
                    break;
                }
            }
        }
        return list;
    }
    //Optimal
    public static ArrayList<Integer> optimal(int[] arr1 , int n1 , int[] arr2 , int n2 , ArrayList<Integer> list){
        int i = 0;
        int j = 0;
        while(i<n1 && j <n2){
            if(arr1[i] < arr2[j]){
                i++;
            }
            else if(arr2[j] < arr1[i]){
                j++;
            }
            else{
                list.add(arr1[i]);
                i++;
                j++;
            }
            
        }
        return list;
    }
}

//OUTPUT
/*
Enter the array 1 elements:
1 1 2 3 4
Enter the size of array 2:7
Enter the array 2 elements:
1 1 3 4 4 5 6
Union of 2 array:
1 1 3 4 
 */
//---------------------------------------------------------------------------------------
/*
Brute:
Time Complexity : O(N1 * N2)
Space Complexity : O(N2)

Optimal:
Time Complexity : O(N1 + N2)
SPace Complexity : O(1)
*/