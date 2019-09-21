#include <iostream>
#include <set>
#include <vector>

using namespace std;

int main(){

    set <int> s;
    vector <int> arr {1,2,3,4,5,5,6,6,7,7,10,10};

    for(int i = 0; i < arr.size(); i++) s.insert(arr[i]);

    for(auto i:s) cout << i << " ";


    return 0;
}