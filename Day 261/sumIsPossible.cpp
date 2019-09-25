#include <iostream>
#include <map>
#include <vector>
using namespace std;
bool isSumPossible(vector<int>, int);
int main(){

    vector<int>arr{1,2,3,4,5,6,7,8,9};
    int k;

    cin >> k;

    cout << isSumPossible(arr, k);

    return 0;
}

bool isSumPossible(vector<int> arr, int k){
    map<int, int>m;
    for(int i: arr){
        m[abs(k-i)] = i;
        if(m.find(i) != m.end()){
            printf("Es posible sumando: %d + %d = %d\n", i,m[i],k);
            return true;
        }
    }
    return false;
}