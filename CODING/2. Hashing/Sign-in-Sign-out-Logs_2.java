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

Time Complexity : O(N)
Space Complexity : O(N)

*/

import java.util.*;
        
 class GFG {

    static List<String> processLogs(List<String> logs, int maxSpan) {

        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        TreeSet<String> result = new TreeSet<String>();

        for(int i = 0; i < logs.size(); ++i) {

            String item = logs.get(i);
            Integer id = Integer.parseInt(item.split(" ")[0]);    

            if(hashMap.containsKey(id)) {

                    Integer time1 = Integer.parseInt(item.split(" ")[1]);
                    Integer time2 = hashMap.get(id); 
                     
                    int span = Math.abs(time1 - time2);

                    if(span <= maxSpan) {

                        result.add(id.toString());
                    }
            }
            else {

                Integer time = Integer.parseInt(item.split(" ")[1]); 
                hashMap.put(id, time);
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