/*
Given a set of time intervals in any order, merge all overlapping intervals into one and output the result which should have only mutually exclusive intervals. 
Let the intervals be represented as pairs of integers for simplicity. 
For example, let the given set of intervals be {{1,3}, {2,4}, {5,7}, {6,8}}. 
The intervals {1,3} and {2,4} overlap with each other, so they should be merged and become {1, 4}. Similarly, {5, 7} and {6, 8} should be merged and become {5, 8}

Time Complexity : O(N * log(N))
Space Complexity : O(1)
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

        	// sort the intervals in increasing order of start time
        	Arrays.sort(arr, new Comparator<Interval>(){

            		public int compare(Interval i1, Interval i2) {
                		return i1.start - i2.start;
            		}
        	});
        	int index = 0; // we maintain this variable to modified input array itself into output array

   		for(int i = 1; i < arr.length; ++i) {
	
   			if(arr[index].end >= arr[i].start) {

   				arr[index].end = Math.max(arr[index].end, arr[i].end);
                		arr[index].start = Math.min(arr[index].start, arr[i].start);
   			}
   			else {
   				arr[++index] = arr[i];
   			}
   		}

        	System.out.print("The Merged Intervals are: ");
        	for(int i = 0; i <= index; ++i) {
            		System.out.print("[" + arr[i].start + "," + arr[i].end + "] ");
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
