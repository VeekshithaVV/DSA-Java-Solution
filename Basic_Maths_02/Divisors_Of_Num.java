//Print all Divisors of a given Number
package Basic_Maths_02;

import java.util.*;
public class Divisors_Of_Num{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number:");
        int num = input.nextInt();
        List<Integer> result = new ArrayList<>();
        //result = brute(num,result);
        result = optimal(num,result);
        System.out.println("Divisors are :");
        for(int div : result){
            System.out.print(div+" ");
        }
    }
    public static List<Integer> brute(int num, List<Integer> result){
        for(int i=1; i<=num; i++){
            if(num % i == 0){
                result.add(i);
            }
        }
        return result;
    }
    public static List<Integer> optimal(int num , List<Integer> result){
        for(int i=1; i*i <= num ; i++){
            if(num % i == 0){
                result.add(i);
            }
            if( i != num / i){
                result.add(num / i);
            }
        }
        //Collections.sort(result);
        return result;
    }
}

//OUTPUT
/*
Brute:
Enter the number:12
Divisors are :
1 2 3 4 6 12

Optimal:
Enter the number:12
Divisors are :
1 2 3 4 6 12
*/
//------------------------------------------------------------------------------------------------------------------------

/*
Brute:
Time Complexity : O(N)
Space Complexity : O(K) where K is no. of divisores -> not to solve but to store

Optimal:
Time Complexity : O(Sqrt(N)) + O(k log k) sort
Space Complexity : O(K)
*/