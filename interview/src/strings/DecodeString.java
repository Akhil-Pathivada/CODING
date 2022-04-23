/**
 * Date 23/04/2022
 *
 * @author akhilpathivada
 *
 * https://leetcode.com/problems/decode-string/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 */
package strings;

import java.util.Stack;

public class DecodeString {
        
        private String decodeString(String s) {
                Stack<Integer> counts = new Stack<>(); // stores numbers
                Stack<String> result = new Stack<>(); // stores chars
                String output = ""; // the required output
                int i = 0;
                while (i < s.length()) {
                        if(Character.isDigit(s.charAt(i))) { // a digit
                                int number = 0;
                                // if it's a number
                                while (Character.isDigit(s.charAt(i))) {
                                        number = number * 10 + (s.charAt(i) - '0');
                                        ++i;
                                }
                                counts.push(number);
                        } else if (s.charAt(i) == '[') { // push the formed string till now
                                result.push(output);
                                output = ""; // reset output string
                                ++i;
                        } else if (s.charAt(i) == ']') {
                                int count = counts.pop();
                                StringBuilder temp = new StringBuilder(result.pop());
                                // add a chars on its frequency
                                while (count-- > 0) {
                                        temp.append(output);
                                }
                                output = temp.toString();
                                ++i;
                        } else { // is character
                                output += s.charAt(i); // add it to output
                                ++i;
                        }
                }
                return output;
        }
        
        public static void main(String[] args) {
                String s = "3[a2[c]]";
                System.out.println(new DecodeString().decodeString(s));
        }
}
