#include<iostream>
using namespace std;


int main(){

    //?Suma numeros muy grandes
    short n;
    long long int num, sum = 0;
    cin >> n;
    for(int i = 0; i < n; i++){
        cin >> num;
        sum+=num;
    }
    cout << sum;


    return 0;
}