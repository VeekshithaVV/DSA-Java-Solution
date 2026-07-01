//Roman to Integer
package H_String.B_Medium_String;

import java.util.*;
public class G_Roman_To_Integer {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the Roman Number:");
        String roman = input.next();
        input.close();

        System.out.println("Integer:"+romanToInteger(roman));
    }
    public static int romanToInteger(String roman){
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int len = roman.length();
        int result = map.get(roman.charAt(len-1));
        for(int i=len-2; i>=0; i--){
            if(map.get(roman.charAt(i)) < map.get(roman.charAt(i+1))){
                result -= map.get(roman.charAt(i));
            }
            else{
                result += map.get(roman.charAt(i));
            }
        }
        return result;
    }
}

//OUTPUT
/*
Enter the Roman Number:MCMXCIV
Integer:1994
*/

//------------------------------------------------------------------------------------------------------------
