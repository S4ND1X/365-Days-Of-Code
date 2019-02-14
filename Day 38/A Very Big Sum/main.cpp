#include <iostream>
#include <vector>

using namespace std;
long aVeryBigSum(int arrLenght, vector<long> arr){
    long sum = 0;
    for (int x = 0; x<arrLenght; x++){
    sum += arr[x];
    }
    return sum;
}


int main()
{
    vector<long> arr;
    int arrLenght;
    long arrNum;
    cin << arrLenght;
    for (int i = 0; i<arrLenght; i++){
        cin >> arrNum;
        arr.push_back(arrNum);
    }

    return 0;
}
