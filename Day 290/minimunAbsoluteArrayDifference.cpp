#include <iostream>
#include <vector>
#include <bits/stdc++.h>
using namespace std;

int minimumAbsoluteDifference(vector<int> arr)
{
    int min = INT32_MAX, difCur;

    sort(arr.begin(), arr.end());

    for(int i = 0; i < arr.size() - 1; i++){
        difCur = abs(arr[i]  - arr[i + 1]);
        min = difCur < min ? difCur : min;
    }
    return min;
}

   // for (int i = 0; i < arr.size() - 1; i++){
    //     for(int j = i+1; j < arr.size(); j++){
    //         if(abs(arr[i] - arr[j])< min){ min = abs(arr[i] - arr[j]); }
    //     }
    // }
int main()
{
    vector<int> arr;
    int n, num;
    cin >> n;

    for (int i = 0; i < n; i++)
    {
        cin >> num;
        arr.push_back(num);
    }

    cout << minimumAbsoluteDifference(arr) << endl;
    return 0;
}
