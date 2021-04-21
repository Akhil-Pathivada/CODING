/* Create a data structure twoStacks that represents two stacks. Implementation of twoStacks should use only one array, i.e., both stacks should use the same array for storing elements. Following functions must be supported by twoStacks.
 * push1(int x) –> pushes x to first stack
 * push2(int x) –> pushes x to second stack
 *
 * pop1() –> pops an element from first stack and return the popped element
 * pop2() –> pops an element from second stack and return the popped element
 *
 * Implementation of twoStack should be space efficient.
 *
 * Time Complexity:
 * Push operation : O(1)
 * Pop operation : O(1)
 * Auxiliary Space: O(N).
 * Use of array to implement stack so. It is not the space-optimised method as explained above.
 *
 *  */
#include <iostream> 
#include <stdlib.h> 

using namespace std;

// Creating twoStacks Data Structure 
class twoStacks {
	int *arr;
	int size;
	int top1, top2;

public:
	// Constructor
	twoStacks(int n) {
		size = n;
		arr = new int[n];
		top1 = n/2 + 1;
		top2 = n/2;
	}
	
	// Method to push element to Stack-1
	void push1(int x) {
		if(top1 > 0) {
			arr[--top1] = x;
		}
		else {
			cout << "Stack Overflow by element : " << x << endl;
			return;
		}
	}
	// Method to push element to Stack-2
	void push2(int x) {
		// There should be atleast one empty
        	// space for new element
		if(top2 < size-1) {
			arr[++top2] = x;
		}
		else {
			cout << "Stack Overflow by element : " << x << endl;
			return;
		}
	}
	
	// Method to pop element from Stack-1
	int pop1() {
		if(top1 <= size/2) {
			return arr[top1++];
		}
		else { 
			cout << "Stack Underflow";
			exit(1);
		}
	}
	// Method to pop element from Stack-2
	int pop2() {
		if(top2 >= size/2 + 1) {
			return arr[top2--];
		}
		else { 
			cout << "Stack Underflow";
			exit(1);
		}
	}
};
	
int main() {
	
	twoStacks ts(5);
	ts.push1(5); 
    	ts.push2(10); 
	ts.push2(15); 
	ts.push1(11); 
	ts.push2(7);
	
	cout << "Popped element from Stack-1 is : " 
	     << ts.pop1()
     	     << endl;

	ts.push2(40);
	cout << "Popped element from Stack-2 is : " 
	     << ts.pop2()
     	     << endl;	     
}


