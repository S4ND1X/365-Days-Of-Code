#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int simpleArraySum(vector<int> arr, int n){
    int sum = 0,num;
    //Iterate and sum
    for (int i = 0; i<n; i++){
        sum += arr[i];
    }
    return n;
}

int main (){
    //Define Variables
    int arr_lenght,arr_num;
    int arr_lenght,arr_num;
    cin >> arr_lenght;
    //How to create a vector of N size
    vector<int> arr;
    for(int x = 0; x<arr_lenght; x++){
        cin >> arr_num;
        arr.push_back(arr_num);
    }
    cout << simpleArraySum(arr,arr_lenght);
    for(int j=0; j<6;j++){
    cout << arr[j];
    }
}
