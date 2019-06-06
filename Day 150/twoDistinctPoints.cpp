// A. Two distinct points
// time limit per test1 second
// memory limit per test256 megabytes
// inputstandard input
// outputstandard output
// You are given two segments [l1;r1] and [l2;r2] on the x-axis. It is guaranteed that l1<r1 and l2<r2. Segments may intersect, overlap or even coincide with each other.

// The example of two segments on the x-axis.
// Your problem is to find two integers a and b such that l1≤a≤r1, l2≤b≤r2 and a≠b. In other words, you have to choose two distinct integer points in such a way that the first point belongs to the segment [l1;r1] and the second one belongs to the segment [l2;r2].

// It is guaranteed that the answer exists. If there are multiple answers, you can print any of them.

// You have to answer q independent queries.
#include <iostream>
using namespace std;
int main(){

    int n, l1, r1, l2, r2, p1, p2;
    cin >> n;
    for(int i = 0; i < n; i++){
        //?Siempre imprime puntos que estan en ambos conjuntos pero sin ser iguales
        cin >> l1 >> r1 >> l2 >> r2;
        if(l1 != l2) cout << l1 << " " << l2 << endl;
        else if(r1 != r2) cout << r1 << " " << r2 << endl;
        else if((l1 == l2) && (r1 == r2)) cout << l1 << " " << r2 << endl;
    }



    return 0;
}