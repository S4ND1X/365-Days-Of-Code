#include <iostream>
#include <map>
#include <set>
#include <vector>
using namespace std;

void mapDemo(){
    map<int, int>A;
    vector<int>arr{1,2,3,4,5,6,7,8,9};
    int sumPair;
    cin >> sumPair;

    bool isPossible = false;
    for(int i: arr){
        A[sumPair - i] = i;
        if(A.find(i) != A.end()){
            isPossible = true;
        }
    }
    if(isPossible) cout << "Yes";
    else cout << "No es posible";
}
int main(){

    mapDemo();

    return 0;
}