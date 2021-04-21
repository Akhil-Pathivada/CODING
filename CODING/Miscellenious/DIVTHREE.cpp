/* 
 * Chef wants to host some Division-3 contests. Chef has N setters who are busy creating new problems for him. The ith setter has made Ai problems where 1≤i≤N.
 *
 * A Division-3 contest should have exactly K problems. Chef wants to plan for the next D days using the problems that they have currently. But Chef cannot host more than one Division-3 contest in a day.
 *
 * Given these constraints, can you help Chef find the maximum number of Division-3 contests that can be hosted in these D days?
 *  */
#include <iostream>
using namespace std;

int main() {
	// your code goes here
	int t;
	cin >> t;
	while (t--) {
	    int n, k, d;
	    cin >> n >> k >> d;
	    int arr[n];

	    cout << "Enter the problems set by each Setter : "
	    int sum_of_all_problems = 0;
	    for(int i=0; i < n; ++i){
	        cin >> arr[i];
	        sum += arr[i];
	    }
	    int days_taken_to_complete_all_problems = sum/k;
	    cout << min(days_taken_to_complete_all_problems, d) << endl;
	    
	}
	return 0;
}

