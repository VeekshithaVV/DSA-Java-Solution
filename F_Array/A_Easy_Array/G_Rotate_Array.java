//Left and Right Rotate
package F_Array.A_Easy_Array;

import java.util.Scanner;
public class G_Rotate_Array {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the array size:");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for(int i=0; i<n; i++){
            arr[i] = input.nextInt();
        }
        System.out.print("Enter the rotation count:");
        int d = input.nextInt();
        System.out.print("Left Rotate:1 || Right Rotate:2:(press 1 or 2):");
        int rotate = input.nextInt();
        if(rotate == 1){
            left_rotate(arr,n,d);
        }
        else if(rotate == 2){
            right_rotate(arr,n,d);
        }
        else{
            System.out.println("Invalid Input!!");
        }
        System.out.println("Rotated Array by "+d+" places " );
        for(int num : arr){
            System.out.print(num+" ");
        }
    }
    //LEFT ROTATE
    public static void left_rotate(int[] arr , int n , int d){
        d = d % n;
        reverse(arr , 0 , d-1);
        reverse(arr , d , n-1);
        reverse(arr , 0 , n-1);
    }
    //RIGHT ROTATE
    public static void right_rotate(int[] arr , int n , int d){
        d = d % n;
        reverse(arr , 0 , n-1);
        reverse(arr , 0 , d-1);
        reverse(arr , d , n-1);
    }
    public static void reverse(int[] arr , int start , int end){
        while(start <= end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    
}

//OUTPUT
/*
Enter the array elements:
4 5 6 7 1 2 3
Enter the rotation count:3
Left Rotate:1 || Right Rotate:2:(press 1 or 2):1
Rotated Array by 3 places 
7 1 2 3 4 5 6

Enter the array elements:
1 2 3 4 5 6 7
Enter the rotation count:3
Left Rotate:1 || Right Rotate:2:(press 1 or 2):2
Rotated Array by 3 places 
5 6 7 1 2 3 4
*/