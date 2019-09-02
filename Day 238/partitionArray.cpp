#include <iostream>
#include <vector>
using namespace std;



string solve(int, vector<int>);

int main(){

    int k, arrLen, num;
    vector<int> arr;

    cin >> k >> arrLen;

    for(int i = 0; i < arrLen; i++){
        cin >> num;
        arr.push_back(num);
    }

    cout << solve(k, arr);

    return 0;
}


string solve(int k, vector<int> arr) {
    if(arr.size() % k != 0){
        return "No";
    }
    else{
        int cont = 1;
        for(int i = 1; i < arr.size(); i++){
            if(k % i - 1 == 0) {
                cont = 1;
            }

            if(arr[i] == arr[i -1] && cont > 1){
                return "No";
            }
            cont++;


    }
        return "Yes";
    }
}