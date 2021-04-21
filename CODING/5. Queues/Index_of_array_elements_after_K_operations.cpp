/* Given an array arr[] and an integer K, the task is to print the position of the array elements, 
 * where the ith value in the result is the index of the ith element in the original array after applying following operations exactly K times:
 *
 * 1. Remove the first array element and decrement it by 1.
 * 2. If it is greater than 0 after decrementing, place it at the end of the array and shift the position of the elements to left.
 *
 * Ref: https://www.geeksforgeeks.org/find-the-index-of-the-array-elements-after-performing-given-operations-k-times/
 *
 * Time Complexity: O(max(N, K))
 * Auxiliary Space: O(N)
 *  */

#include<iostream>
#include<queue>
using namespace std;

// Print the current pair
void printPair(pair<int, int> p)
{
    // Gives first element from queue pair
    int f = p.first;

    // Gives second element from queue pair
    int s = p.second;

    cout << "(" << f << ", " << s << ") ";
}

// Print the Queue of Pairs
void showQueue(queue<pair<int, int> > gq)
{
    // Print element until the queue is not empty
    while (!gq.empty()) {
        printPair(gq.front());
        gq.pop();
    }

    cout << '\n';
}

// Print the Indexes of each pair
void printIndexes(queue<pair<int, int> > que)
{
    // Print index element until the queue is not empty
    while (!que.empty()) {
        cout << que.front().second << ", ";
        que.pop();
    }
}

void findElementPositions(int *arr, int N, int K) {

	queue<pair<int, int> > que;
	// Build a Queue with Array elements and index
	for(int i=0; i<N; ++i) {
		que.push({arr[i], i});
	}
	
	// Perform the operations K times 
	for(int i=0; i<K; ++i) {
		if(que.front().first == 1) {
			que.pop();
		} 
		else {
			pair<int, int> temp = que.front();
			que.pop();
			--temp.first;
			que.push(temp);
		}
	}

	// showQueue(que);
	printIndexes(que);
}

int main() {

	int arr[] = {3, 1, 3, 2};
	int K = 4;

	int len = sizeof(arr) / sizeof(arr[0]);
	
	findElementPositions(arr, len, K);
}
