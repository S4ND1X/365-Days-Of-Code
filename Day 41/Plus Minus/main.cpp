#include <iostream>
#include <vector>
using namespace std;
// Complete the plusMinus function below.
void plusMinus(vector<float> arr, float array_lenght) {
    float positive = 0, negative = 0, neutral = 0;
    for (int i = 0; i<array_lenght; i++){
        if (arr[i]>0) positive++;
        else if (arr[i]<0) negative++;
        else neutral++;
    }
    negative = negative / array_lenght;
    positive = positive / array_lenght;
    neutral = neutral / array_lenght;
    cout << positive <<endl;
    cout << negative << endl;
    cout << neutral << endl;
}

int main()
{
    float arrayNumber;
    int n;
    vector<float> arr;
    cin >> n;
    for (int x = 0; x<n; x++){
        cin >> arrayNumber;
        arr.push_back(arrayNumber);
    }
    plusMinus(arr,n);
}
