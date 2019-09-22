#include <iostream>

using namespace std;

int fib(int);
int main(){
    //cout << fib(3);
    cout << "Enter an integer " << endl;
    int number;
    cin >> number;

    //convert the number into digits
    //lets say the number is 12345, of course this would require 5 variables,
    return 0;
}

//todo 1,1,2,3,5

int fib(int n){
    if(n<=1) return n;
    return fib(n - 1) + fib(n - 2);
}