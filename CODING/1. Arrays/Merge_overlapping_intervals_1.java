/*
Given a set of time intervals in any order, merge all overlapping intervals into one and output the result which should have only mutually exclusive intervals. 
Let the intervals be represented as pairs of integers for simplicity. 
For example, let the given set of intervals be {{1,3}, {2,4}, {5,7}, {6,8}}. 
The intervals {1,3} and {2,4} overlap with each other, so they should be merged and become {1, 4}. Similarly, {5, 7} and {6, 8} should be merged and become {5, 8}

Time Complexity : O(N * log(N))
Space Complexity : O(N)
*/

import java.util.*;

class Interval {
	
	int start, end;
	public Interval(int start, int end) {

		this.start = start;
		this.end = end;
	}
}

class GFG { 

	private static void mergeOverlappingIntervals(Interval[] arr) {

		if(arr.length == 0) {
			return;
		}

		Stack<Interval> stack = new Stack<Interval>();
        	// sort the intervals in increasing order of start time
        	Arrays.sort(arr, new Comparator<Interval>(){

            		public int compare(Interval i1, Interval i2) {
                		return i1.start - i2.start;
            		}
        	});
   		stack.push(arr[0]);

   		for(int i = 1; i < arr.length; ++i) {

   			Interval top = stack.peek();

   			if(top.end < arr[i].start) {
   				stack.push(arr[i]);
   			}
   			else if (top.end < arr[i].end) {

   				top.end = arr[i].end;
   				stack.pop();
   				stack.push(top);
   			}
   		}
   		
        	System.out.print("The Merged Intervals are: ");
        	while (!stack.isEmpty()) {

            		Interval t = stack.pop();
            		System.out.print("[" + t.start + "," + t.end + "] ");
        	}    		
	}

	public static void main(String[] args) {

		Interval arr[] = new Interval[4];

       		arr[0] = new Interval(6, 8);
        	arr[1] = new Interval(1, 9);
        	arr[2] = new Interval(2, 4);
        	arr[3] = new Interval(4, 7);

        	mergeOverlappingIntervals(arr);
	}
}
