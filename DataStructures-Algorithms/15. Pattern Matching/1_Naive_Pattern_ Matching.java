/*
Given a text txt[0..n-1] and a pattern pat[0..m-1], write a function search(char pat[], char txt[]) 
that prints all occurrences of pat[] in txt[]. You may assume that n > m.

C program for Naive Pattern Searching algorithm....

Time Complexity : O((N-M+1) * O(M)) ..... O(n^2)
*/

class NaiveSearch
{
    static void Search( String str, String pat)
    {
        int N = str.length();

        int M = pat.length();

        int i, j;

        for(i=0; i <= N-M; ++i)
        {
            for(j=0; j < M; ++j)
            {
                if(str.charAt(i+j) != pat.charAt(j))
                    break;
            }

            if(j == M)
                System.out.println("Pattern found at index " + i);
        }
    }

    public static void main(String args[])
    {
        String str = "AABAACAADAABAAABAA";

        String pat = "AABA";

        Search(str,pat);
    }
}
