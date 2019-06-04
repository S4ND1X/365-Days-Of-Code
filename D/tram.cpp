// A. Tram
// time limit per test2 seconds
// memory limit per test256 megabytes
// inputstandard input
// outputstandard output
// Linear Kingdom has exactly one tram line. It has n stops, numbered from 1 to n in the order of tram's movement. At the i-th stop ai passengers exit the tram, while bi passengers enter it. The tram is empty before it arrives at the first stop. Also, when the tram arrives at the last stop, all passengers exit so that it becomes empty.

// Your task is to calculate the tram's minimum capacity such that the number of people inside the tram at any time never exceeds this capacity. Note that at each stop all exiting passengers exit before any entering passenger enters the tram.

#include <iostream>
using namespace std;
int main(){

    int n, enter, exit, minCapacity = 0, currentPassengers = 0;
    cin >> n;
    for(int i = 0; i < n; i++){
        cin >> exit >> enter;
        currentPassengers += enter - exit;
        if(currentPassengers > minCapacity)minCapacity = currentPassengers;
    }

    cout << minCapacity;

    return 0;
}