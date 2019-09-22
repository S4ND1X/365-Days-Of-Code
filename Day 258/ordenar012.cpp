#include <iostream>
#include <vector>
#include <set>

using namespace std;

int main(){

    vector<int> arr {2,3,4,5,6,2,3,4,1,10,10};
    set<int>s;
    for(auto i:arr) s.insert(i);
    for(auto i: s) cout << i << " ";

    return 0;
}