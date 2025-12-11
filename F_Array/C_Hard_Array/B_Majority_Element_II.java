//Majority Elements(&gt;N/3 times) | Find the elements that appears more than N/3 times in the array
package F_Array.C_Hard_Array;

import java.util.*;
public class B_Majority_Element_II {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the array size:");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for(int i=0; i<n; i++){
            arr[i] = input.nextInt();
        }
        ArrayList<Integer> list = new ArrayList<>();
        //list = brute(arr,n,list);
        //list = better(arr,n,list);
        list = optimal(arr,n,list);
        System.out.println("Result:");
        for(int num : list){
            System.out.print(num+" ");
        }
    }
    //Brute
    public static ArrayList<Integer> brute(int[] arr , int n, ArrayList<Integer> list){
        for(int i=0; i<n; i++){
            if(list.isEmpty() || !list.contains(arr[i])){
                int count = 0;
                for(int j=i; j<n; j++){
                    if(arr[i] == arr[j]){
                        count++;
                    }
                }
                if(count > n/3){
                    list.add(arr[i]);
                }
            }
        }
        return list;
    }
    //Better
    public static ArrayList<Integer> better(int[] arr , int n, ArrayList<Integer> list){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : arr){
            map.put(num , map.getOrDefault(num, 0)+1);

            if(map.get(num) > n/3 && !list.contains(num)){
                list.add(num);
            }
            if(list.size() == 2){
                break;
            }
        }
        return list;
    }
    //Optimal
    public static ArrayList<Integer> optimal(int[] arr , int n, ArrayList<Integer> list){
        int count1 = 0 , count2 = 0;
        int ele1 = Integer.MIN_VALUE , ele2 = Integer.MIN_VALUE;
        for(int num : arr){
            if(count1 == 0 && ele2 != num){
                count1 = 1;
                ele1 = num;
            }
            else if (count2 == 0 && ele1 != num){
                count2 = 1;
                ele2 = num;
            }
            else if(ele1 == num){
                count1++;
            }
            else if(ele2 == num){
                count2++;
            }
            else{
                count1--;
                count2--;
            }
        }
        //Verify
        count1 = 0;
        count2 = 0;
        for(int num : arr){
            if(num == ele1){
                count1++;
            }
            else if(num == ele2){
                count2++;
            }
        }
        if(count1 > n/3){
            list.add(ele1);
        }
        if(count2 > n/3){
            list.add(ele2);
        }
        return list;
    }
}

//OUTPUT
/*
Enter the array size:3
Enter the array elements:
3 2 3
Result:
3 
*/