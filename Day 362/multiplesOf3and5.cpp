#include <iostream>
using namespace std;


int sumOfMultiples(int);
int main(){


    cout << sumOfMultiples(999);

    return 0;
}

int sumOfMultiples(int n){
    int sumOf3 = 3 * (((n/3)*(n/3 + 1)) / 2);
    int sumOf5 = 5 * (((n/5)*(n/5 + 1)) / 2);
    int sumOf15 = 15 * (((n/15)*(n/15 + 1)) / 2);

    return sumOf3 + sumOf5 - sumOf15;

}