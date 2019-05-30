#include <iostream>
using namespace std;

int main() {

    int nPrisioners,nCandys,start, cases;
    cin >> cases;
    for(int t = 0; t < cases; t++){
        cin >> nPrisioners >> nCandys >> start;
        if(!((nCandys + start -1)%nPrisioners))cout << nPrisioners << endl;
        else cout << (nCandys + start - 1) % nPrisioners << endl;
    }
    return 0;
}