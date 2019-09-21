#include <iostream>
#include <vector>

using namespace std;

int main(){

    vector <int> arr;
    int n, sum = 0;
    cin >> n;
    for(int i = 0; i < n; i++){
        arr.push_back(i+1);
    }

    int arrSum = arr.size() * (arr.size() + 1) / 2;

    for(int i = 0; i < arr.size(); i++) sum+=arr[i];

    if(sum == arrSum) cout << true << endl;
    else cout << abs(arrSum - sum)  << endl;

    return 0;
}