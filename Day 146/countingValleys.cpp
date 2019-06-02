#include <iostream>

using namespace std;

int main(){

    int n, cont = 0,vall = 0;
    cin >> n;
    string s;
    cin >>  s;

    //?Se cuenta como valle si esta en nivel de mar y viene de subida
    for(int i = 0; i < n; i++){
        if(s[i] == 'U')cont++;
        else cont--;
        if(cont == 0 and s[i] == 'U')vall++;
    }

    cout << vall;

    return 0;
}