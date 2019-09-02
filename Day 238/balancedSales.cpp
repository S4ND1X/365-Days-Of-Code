#include <iostream>
#include <vector>
using namespace std;

int solucion(vector <int>);
int main(){

    int n, wea;
    cin >> n;
    vector <int> arr;
    for(int i= 0; i < n; i++){
        cin >> wea;
        arr.push_back(wea);
    }

    cout<< solucion(arr);



}

int balancedSum(vector <int> arr){
    int startIndex = 1;
    int end = arr.size() - 2;

    int sumLeft = arr[0];
    int sumRight = arr[arr.size() - 1];

    if(arr.size() == 3 && sumLeft == sumRight) return startIndex;

    while(startIndex <= end){
        if(sumLeft == sumRight && startIndex == end) return startIndex;
        if(sumLeft < sumRight){
            sumLeft += arr[startIndex];
            startIndex++;
        }
        else{
            sumRight += arr[end];
            end--;
        }
    }
}