Given a string representing a positive integer, remove exactly one occurrence of the given digit so that the resulting integer is as large as possible.

import java.util.*;
class Solution {
    public static String removeDigit(String number, char digit) {
        int n = number.length();

        // Convert to StringBuilder so we can delete characters
        StringBuilder sb = new StringBuilder(number);

        // Step 1: Try to remove a digit that makes the number bigger
        for (int i = 0; i < n - 1; i++) {
            if (number.charAt(i) == digit && number.charAt(i) < number.charAt(i + 1)) {
                sb.deleteCharAt(i);
                return sb.toString();
            }
        }

        // Step 2: If we didn't remove yet, remove the LAST occurrence
        sb.deleteCharAt(number.lastIndexOf(digit));
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDigit("1321", '1')); // 321
        System.out.println(removeDigit("1211", '1')); // 121
        System.out.println(removeDigit("1221", '1')); // 221
        System.out.println(removeDigit("111", '1'));  // 11
    }
}
