//Print Name N times using Recursion
package C_Basic_Recursion_03;

import java.util.Scanner;
public class A_Print_Name {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number:");
        int num = input.nextInt();
        input.nextLine();// <-- Clear buffer
        System.out.println("Enter the name:");
        String name = input.nextLine();
        print_name(num,name);
    }
    public static void print_name(int num, String name){
        if(num == 0){
            return;
        }
        System.out.println(name);
        num--;
        print_name(num, name);
    }
}

//OUTPUT
/*
Enter the number:
5
Enter the name:
Java

Java
Java
Java
Java
Java
*/
//-----------------------------------------------------------------------------------------------------------------------------

/*

Time Complexity : O(N)
Space Complexity : O(N)

*/