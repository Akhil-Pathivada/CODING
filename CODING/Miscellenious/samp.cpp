#include <iostream>
using namespace std;

int main() {
	// your code goes here
	ios::sync_with_stdio(0);
    cin.tie(0);
	int t;
	cin >> t;
	while (t--) {
	    int n, k, d;
	    cin >> n >> k >> d;
	    int arr[n];
	    int sum = 0;
	    for(int i=0; i < n; ++i){
	        cin >> arr[i];
	        sum += arr[i];
	    }
	    int days_taken_to_complete_all_problems = sum/k;
	    cout << min(days_taken_to_complete_all_problems, d) << endl;
	    
	}
	return 0;
}

