// A. Buy a Shovel
// time limit per test1 second
// memory limit per test256 megabytes
// inputstandard input
// outputstandard output
// Polycarp urgently needs a shovel! He comes to the shop and chooses an appropriate one. The shovel that Policarp chooses is sold for k burles. Assume that there is an unlimited number of such shovels in the shop.

// In his pocket Polycarp has an unlimited number of "10-burle coins" and exactly one coin of r burles (1 ≤ r ≤ 9).

// What is the minimum number of shovels Polycarp has to buy so that he can pay for the purchase without any change? It is obvious that he can pay for 10 shovels without any change (by paying the requied amount of 10-burle coins and not using the coin of r burles). But perhaps he can buy fewer shovels and pay without any change. Note that Polycarp should buy at least one shovel.
#include <iostream>
using namespace std;
int main(){


    int price, coin, i = 1;
    bool flag = true;
    cin >> price >> coin;
    //?Sale del bucle si el residuo de 10 es 0 o si restando la moneda disponible es 0
    while(flag){
        if((price*i) % 10 == 0)flag = !flag;
        else if(((price*i) - coin) % 10 == 0)flag = !flag;
        else i++;
    }
    cout << i;
    

    return 0;
}