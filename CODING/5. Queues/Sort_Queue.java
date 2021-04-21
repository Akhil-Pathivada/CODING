/* Given a queue with random elements, we need to sort it. We are not allowed to use extra space.
 * The operations allowed on queue are :
 *
 * 1. enqueue() : Adds an item to rear of queue.
 * 2. dequeue() : Removes an item from front of queue.
 * 3. isEmpty() : Checks if a queue is empty
 *
 * Time Complexity: O(N ^ 2)
 * Space Complexity: O(1)
 *  */

import java.util.*;

class GFG { 

	private void insertMinToRear(Queue<Integer> queue, int minIndex) {

		int minValue = 0;
		int s = queue.size();

		for(int i = 0; i < s; ++i) {

			int currValue = queue.poll();

			if(i != minIndex) {

				queue.add(currValue);
			}
			else {
				minValue = currValue;
			}
		}
		queue.add(minValue);
	}
	
	private int getMinIndex(Queue<Integer> queue, int sortIndex) {
		
		int minIndex = -1;
		int minValue = Integer.MAX_VALUE;
		
		for(int i = 0; i < queue.size(); ++i) {

			int currValue = queue.poll();

			if(currValue <= minValue && i < sortIndex) {
				
				minIndex = i;
				minValue = currValue;
			} 
			queue.add(currValue);
		}
		return minIndex;
	}

	private void sortQueue(Queue<Integer> queue) {

		for(int i = 0; i < queue.size(); ++i) {

			int minIndex = getMinIndex(queue, queue.size() - i);
			insertMinToRear(queue, minIndex);
		}
	}

	public static void main(String args[]) {

		Queue<Integer> queue = new LinkedList<Integer>();

		queue.add(30);
		queue.add(11);
		queue.add(3);
		queue.add(15);
		queue.add(4);

		GFG obj = new GFG();

		obj.sortQueue(queue);

		// printing the Queue
		while(queue.isEmpty() == false) {

		    System.out.print(queue.peek() + " ");
		    queue.poll();
		}
	}
}
