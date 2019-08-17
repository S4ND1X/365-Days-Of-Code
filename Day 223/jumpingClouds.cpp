#include <iostream>
using namespace std;

int main(){

    int n, wea, saltos = 0;

    cin >> n;

    int arr[n];
    for(int i = 0; i < n; i++){
        cin >> wea;
        arr[i] = wea;
    }

    int i = 0;
    while(i < n){
        if(arr[i + 2] == 0){
            saltos++;
            i +=2;
        }
        else if(arr[i +1] == 0) {
            saltos++;
            i++;
        }
        else i++;
    }

    cout << saltos;

    return 0;
}