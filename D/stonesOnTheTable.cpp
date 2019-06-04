// A. Stones on the Table
// time limit per test2 seconds
// memory limit per test256 megabytes
// inputstandard input
// outputstandard output
// There are n stones on the table in a row, each of them can be red, green or blue. Count the minimum number of stones to take from the table so that any two neighboring stones had different colors. Stones in a row are considered neighboring if there are no other stones between them.
// #include <iostream>
#include <iostream>
using namespace std;
int main(){

    int n;
    string colors;
    cin >> n;
    cin >> colors;
    int cont = 0;
    //?Si es el mismo color a su derecham se quita una
    for(int i = 0; i < n-1; i++){
        if(colors[i] == colors[i+1])cont++;
    }

    cout << cont;
    return 0;
}