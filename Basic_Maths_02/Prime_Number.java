//Check if a number is prime or not
package Basic_Maths_02;

import java.util.*;
public class Prime_Number {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number:");
        int num = input.nextInt();
        //boolean res = brute(num);
        boolean res = optimal(num);
        if(res){
            System.out.println(num+" is Prime Number!!");
        }
        else{
            System.out.println(num+" Not a Prime Number!!");
        }

    }
    public static boolean brute(int n){
        boolean res = true;
        for(int i=2; i<n;i++){
            if(n % i == 0){
                res = false;
                return res;
            }
        }
        return res;
    }
    public static boolean optimal(int num){
        int count = 0;
        for(int i=1; i*i<=num; i++){
            if(num % i == 0){
                count++;
            }
            if( i != num/i){
                count++;
            }
        }
        if(count == 2){
            return true;
        }
        return false;
    }
}

//OUTPUT
/*
Enter the number:5
5 is Prime Number!!

Enter the number:12
12 Not a Prime Number!!
*/
//--------------------------------------------------------------------------------------------------------------

/*
Brute:
Time Complexity : O(N)
Space Complexity : O(1)

Optimal:
Time Complexity : O(Sqrt(N))
Space Complexity : O(1)
*/