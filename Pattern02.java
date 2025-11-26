//Pattern-2: Right-Angled Triangle Pattern
package PATTERNS;

import java.util.*;
public class Pattern02 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the n:");
        int n = input.nextInt();
        print_pattern2(n);
    }
    public static void print_pattern2(int n){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
        
    }
}

//OUTPUT
/* Enter the n:5
* 
* * 
* * * 
* * * * 
* * * * * 
*/