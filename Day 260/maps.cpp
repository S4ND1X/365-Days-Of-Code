#include <iostream>
#include <map>
#include <set>
#include <vector>
using namespace std;

void mapDemo(){
    map<int, int>A;
    vector<int>arr{1,2,3,4,5,6,7,8,9};
    int sumPair = 11;

    for(int i: arr){
        cout << sumPair-i << " " <<  i << endl;;
        A[sumPair-i] = i;
    }

    map<char, int>cnt;
    string x = "Jorgito sanchez";
    for(char c: x){
        cnt[c]++;
    }
}
int main(){

    mapDemo();

    return 0;
}