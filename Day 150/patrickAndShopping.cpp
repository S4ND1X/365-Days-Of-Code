// A. Patrick and Shopping
// time limit per test1 second
// memory limit per test256 megabytes
// inputstandard input
// outputstandard output
// Today Patrick waits for a visit from his friend Spongebob. To prepare for the visit, Patrick needs to buy some goodies in two stores located near his house. There is a d1 meter long road between his house and the first shop and a d2 meter long road between his house and the second shop. Also, there is a road of length d3 directly connecting these two shops to each other. Help Patrick calculate the minimum distance that he needs to walk in order to go to both shops and return to his house.
// Patrick always starts at his house. He should visit both shops moving only along the three existing roads and return back to his house. He doesn't mind visiting the same shop or passing the same road multiple times. The only goal is to minimize the total distance traveled.
#include <iostream>
using namespace std;
int main(){

    int r1,r2,r3,d1,d2,d3,d4;
    cin >> r1 >> r2 >> r3;
    //?Se hace la suma de todas las combinaciones posibles de caminos
    d1 = r1 + r2 + r3;
    d2 = 2 * (r1 + r2);
    d3 = r1 + r3 + r3 + r1;
    d4 = r2 + r3 + r3 + r2;
    //?Se imprime el minimo de todas las combinaciones
    cout << min(d1,min(d2, min(d3, d4)));

    

    return 0;
}