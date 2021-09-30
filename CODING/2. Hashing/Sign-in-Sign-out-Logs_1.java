/*
A log file is provided as a string array where each entry is in the form of "user_id timestamp action".
Each of the values are seperated by space. 

1. Both user_id and timestamp consists only of digits, are at most 9 digits long and start with a non-zero digit.
2. timestamp represents the time in seconds since the application was last launched
3. action will be either "sign-in" or "sign-out"

Given a log with entries in no particular order, return an array of strings that denote user_ids of users 
whose signed out in maxSpan seconds or less than after signing in.

Example:

logs = ["30 99 sign-in", "12 100 sign-in", "20 80 sign-in", "21 110 sign-in", "12 120 sign-out", "20 101 sign-out", "30 105 sign-out"]
maxSpan = 20

Output : [12, 30]

Time Complexity : O(N ^ 2)
Space Complexity : O(1)

*/

import java.util.*;
        
 class GFG {
    
    static List<String> processLogs(List<String> logs, int maxSpan) {

        TreeSet<String> result = new TreeSet<String>();

        for(int i = 0; i < logs.size(); ++i) {

            String item1 = logs.get(i);

            for(int j = i + 1; j < logs.size(); ++j) {

                String item2 = logs.get(j);
                // ids
                String id1 = item1.split(" ")[0]; 
                String id2 = item2.split(" ")[0];
                // status
                String status1 = item1.split(" ")[2];
                String status2 = item2.split(" ")[2];

                if((id1.equals(id2)) && (!status1.equals(status2))) {

                    Integer t1 = Integer.parseInt(item1.split(" ")[1]); 
                    Integer t2 = Integer.parseInt(item2.split(" ")[1]); 

                    int span = Math.abs(t1 - t2);

                    if(span <= maxSpan) {

                        result.add(id1);
                    }
                }
            }
        }
        return new ArrayList<String>(result);
    }

    public static void main(String[] args) {

        List<String> input = new ArrayList<>();
        input.add ("30 99 sign-in");
        input.add ("12 100 sign-in");
        input.add ("20 80 sign-in");
        input.add ("21 110 sign-in");
        input.add ("12 120 sign-out");
        input.add ("20 101 sign-out");
        input.add ("30 105 sign-out");

        int maxSpan = 20;
        List<String> result = processLogs(input, maxSpan);

        System.out.println(result);
    }
}