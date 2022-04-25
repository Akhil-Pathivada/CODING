/**
 * Date 25/04/2022
 *
 * @author akhilpathivada
 */
package zipcar;

import java.util.Arrays;
import java.util.Stack;

public class Main {
        
        private void remove(String s) {
                Stack<Integer> stack = new Stack<>();
                char[] str = s.toCharArray();
                for (int i = 0; i < s.length(); ++i) {
                        if (s.charAt(i) == ')') {
                                while (!stack.isEmpty() && s.charAt(stack.peek()) != '(') {
                                        stack.pop();
                                }
                                if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                                        stack.pop();
                                } else {
                                     //  s = s.replace(s.charAt(i), '*');
                                        str[i] = ' ';
                                }
                        }
                        else if (s.charAt(i) == '('){
                                stack.push(i);
                        }
                }
                while (!stack.isEmpty() && str[stack.peek()] == '(') {
                        
                        str[stack.pop()] = ' ';
                       // System.out.println("com");
                }
                System.out.println(Arrays.toString(str));
        }
        
        public static void main(String[] args) {
                //System.out.println("Hello World");
                String s = "((((a(b(c)d))))))";
               // new Main().remove(s);
                int[] arr  = { 18, 3, 19, 20, 5, 21, 9 };
               // new Main().get(arr);
        }
}
