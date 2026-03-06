Given an array of characters chars, compress it using the following algorithm:
Begin with an empty string s. For each group of consecutive repeating characters in chars:
If the group's length is 1, append the character to s.
Otherwise, append the character followed by the group's length.
The compressed string s should not be returned separately, but instead, be stored in the input character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.
After you are done modifying the input array, return the new length of the array.
You must write an algorithm that uses only constant extra space.
Note: The characters in the array beyond the returned length do not matter and should be ignored.
Example 1:

Input: chars = ["a","a","b","b","c","c","c"]
Output: 6
Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".

  class Solution {
    public int compress(char[] chars) {
        String str=new String(chars);
        int n=str.length();
        int index=0;
        Integer count=1;
        for(int i=0;i<n;i++){
         while(i<n-1 && str.charAt(i)==str.charAt(i+1)){
            count++;
            i++;
        }
        chars[index++]=str.charAt(i);
        if(count>1){
            String cnt=count.toString();
        for(int j=0;j<cnt.length();j++){
            chars[index++]=cnt.charAt(j);
        }
        }
           count = 1; 
    }
    return index;

}
}




//sample code 
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);   // create scanner

        System.out.print("Enter an integer: ");
        int num = sc.nextInt();                // read integer

        System.out.print("Enter a double: ");
        double d = sc.nextDouble();            // read decimal number

        System.out.print("Enter a word: ");
        String word = sc.next();               // read one word

        sc.nextLine();                         // consume leftover newline

        System.out.print("Enter a full sentence: ");
        String sentence = sc.nextLine();       // read full line

        System.out.println("\n---- Output ----");
        System.out.println("Integer: " + num);
        System.out.println("Double: " + d);
        System.out.println("Word: " + word);
        System.out.println("Sentence: " + sentence);

        sc.close();                            // close scanner
    }
}
