
// Java program to Count
// minimum swap to make
// string palindrome
import java.util.*;

class GFG {

    // Function to Count minimum swap
    static int countSwap(String str)
    {

        // Legth of string
        int n = str.length();

        char s[] = str.toCharArray();

        // Counter to count minimum
        // swap
        int count = 0;

        // A loop which run in half
        // string from starting
        for (int i = 0; i < n / 2; ++i) {

            int left = i;

            int right = n - left - 1;

	    while (left < right) {

		 if(s[left] == s[right]) {
                    break;
                }
                else {
                    right--;
                }
            }

            if (left == right) {
                return -1;
            }

            else {
                for (int j = right; j < n - left - 1; j++) {
                    char t = s[j];
                    s[j] = s[j + 1];
                    s[j + 1] = t;
                    count++;
                }
            }
        }

        return count;
    }

    // Driver Code
    public static void main(String[] args)
    {
        String s = "geeksfgeeks";

        // Function calling
        int ans1 = countSwap(s);

        StringBuilder sb=new StringBuilder(s);
        sb.reverse();
        s = sb.toString();

        int ans2 = countSwap(s);
        if(ans1 > ans2)
          System.out.println(ans1);
        else
          System.out.println(ans2);
    }
}
