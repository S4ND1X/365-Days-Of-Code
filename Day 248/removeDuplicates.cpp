// A. Remove Duplicates
// time limit per test1 second
// memory limit per test256 megabytes
// inputstandard input
// outputstandard output
// Petya has an array a consisting of n integers. He wants to remove duplicate (equal) elements.

// Petya wants to leave only the rightmost entry (occurrence) for each element of the array. The relative order of the remaining unique elements should not be changed.

#include <iostream>
#include <set>
using namespace std;
int main(){

    int n, m;
    set <int> s;
    cin >> n;
    for(int i = 0; i < n; i++){
        cin >> m;
        s.insert(m);
    }
    cout << s.size() << endl;
    for(auto i = s.rbegin(); i != s.rend(); ++i)cout << *i << ' ';

    return 0;
}