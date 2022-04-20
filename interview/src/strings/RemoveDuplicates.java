/**
 * Date 31/03/2022
 *
 * @author akhilpathivada
 *
 * https://www.geeksforgeeks.org/remove-duplicates-from-a-given-string/
 *
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 */
package strings;

import java.util.LinkedHashSet;

public class RemoveDuplicates {
        
        private void removeDuplicates(String str) {
                // LinkedHashSet maintains the insertion order
                LinkedHashSet<Character> lhs = new LinkedHashSet<>();
                // add all characters into set
                for(char ch : str.toCharArray()) {
                        lhs.add(ch);
                }
                // print string after deleting duplicate elements
                for(Character ch : lhs) {
                        System.out.print(ch);
                }
        }
        
        public static void main(String[] args) {
                String str = "geeksforgeeks";
                new RemoveDuplicates().removeDuplicates(str);
        }
}
