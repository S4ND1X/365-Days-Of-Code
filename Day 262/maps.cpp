#include <iostream>
#include <map>
#include <set>
#include <vector>
using namespace std;

bool isSumPossible(vector<int>arr, int sumPair){
    map<int, int>A;
    for(int i: arr){
        A[sumPair - i] = i;
        if(A.find(i) != A.end()){
            return true;
        }
    }
    return false;
}
int main(){

    vector<int>arr;
    int arrLen, sumPair,numArr;
    cin >> arrLen >> sumPair;
    for(int i = 0; i < arrLen; i++){
        cin >> numArr;
        arr.push_back(numArr);
    }

    if(isSumPossible(arr,sumPair)) { cout << "The sum was posible" << endl; }
    else { cout << "The sum is not possible" << endl; }

    return 0;
}