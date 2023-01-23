package datastructures2018;

import java.util.Scanner;

/**
 *
 * @author EddyJ
 */
public class Occurrences {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String s = input.nextLine();
     
        char[] chars = s.toCharArray();
        System.out.print("Enter a character: ");
        String ch = input.nextLine();
        char key = ch.charAt(0);
        
        System.out.println(key + " appears " + count(chars, key) + " time(s).");
        
    }
    public static int count(char[] chars, char ch){
        return count(chars, ch, chars.length - 1);
    }
    private static int count(char[] chars, char ch, int high){
        if(high >= 0)
            return count(chars, ch, high - 1) + ((chars[high] == ch) ? 1 : 0);
                    else 
            return 0;
            
    }
}
