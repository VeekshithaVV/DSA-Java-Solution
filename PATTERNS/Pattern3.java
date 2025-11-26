//Pattern - 3: Right-Angled Number Pyramid
package PATTERNS;

import java.util.*;
public class Pattern3 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the n:");
        int n = input.nextInt();
        print_pattern3(n);
    }
    public static void print_pattern3(int n){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}


//OUTPUT
/* Enter the n:5
1 
1 2
1 2 3
1 2 3 4
1 2 3 4 5 
*/