#include <iostream>

using namespace std;

class Carta{
public:
    int poder;
    string tipoCarta;
    Cartas(int aPoder sting aTipoCarta){
        poder = aPoder;
        tipoCarta = aTipoCarta;
    }




};

int main()
{
    Carta  cartaFuego(8,"Fuego");
    cout << cartaFuego.tipoCarta;
    return 0;
}
