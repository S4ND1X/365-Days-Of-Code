#include <iostream>

using namespace std;

int main(){

    int n, cambio = 0, resultado = 0;
    char c;

    cin >> n;

    for(int i = 0; i < n; i++){

        cin >> c;

        if(c == 'U') cambio++;

        else cambio--;

        if(cambio == 0 && c == 'U')resultado++;
    }

    cout << resultado;

    return 0;
}