#include <iostream>
using namespace std;
//Clase para  crear cartas
class Carta{
public:
    int poder;
    string tipoCarta;
    Carta(int aPoder, string aTipoCarta){
        poder = aPoder;
        tipoCarta = aTipoCarta;
    }
};
//Juego recibe las cartas y determina el ganador
void winnerGame(Carta carta1, Carta carta2){
    if ((carta1.tipoCarta == "Fuego" || carta2.tipoCarta == "Fuego") && (carta2.tipoCarta == "Agua" || carta1.tipoCarta == "Agua")){
        cout << "Gana Carta Agua"<<endl;
    }
    else if ((carta1.tipoCarta == "Fuego" || carta2.tipoCarta == "Fuego") && (carta2.tipoCarta == "Hielo" || carta1.tipoCarta == "Hielo")){
          cout << "Gana Carta Fuego"<<endl;
    }
    else if ((carta1.tipoCarta == "Hielo" || carta2.tipoCarta == "Hielo")  && (carta2.tipoCarta == "Agua" || carta1.tipoCarta == "Agua")){
          cout << "Gana Carta Hielo"<<endl;
    }
    else if ((carta1.tipoCarta == "Hielo" || carta2.tipoCarta == "Hielo") && (carta1.tipoCarta == "Hielo" || carta2.tipoCarta == "Hielo")){

    }
}

int main()
{


    Carta Fuego (5,"Fuego");
    Carta Agua (9, "Agua");
    Carta Hielo (8, "Hielo");

    winnerGame(Hielo,Agua);
    winnerGame(Agua,Hielo);

    winnerGame(Hielo,Fuego);
    winnerGame(Fuego,Hielo);

    winnerGame(Agua,Fuego);
    winnerGame(Fuego,Agua);





    return 0;
}
