#include <iostream>
#include <math.h>
#include <stdlib.h>
#include <string.h>
#include <fstream>
#include <vector>
#include <unordered_map>
#include <unordered_set>

using namespace std;

void lectura();

int main(){
    lectura();
}

void lectura(){

    unordered_map <string,string> paises;
    paises["JA"] = "Japon";
    paises["D"] = "Alemania";
    paises["PP"] = "Brasil";
    paises["CF"] = "Canada";
    paises["A7"] = "Catar";
    paises["CC"] = "Chile";
    paises["B"] = "China";
    paises["OY"] = "Dinamarca";
    paises["HC"] = "Ecuador";
    paises["A6"] = "Emiratos arabes";
    paises["EC"] = "España";
    paises["N"] = "Estados unidos";
    paises["PK"] = "Indonesia";
    paises["XA"] = "Mexico";
    paises["9V"] = "Singapur";
    paises["HS"] = "Tailandia";


    unordered_map <string,int> cantidades;
    unordered_set<string> iniciales;

    ifstream archivo;
    string texto;

    archivo.open("vuelos.txt",ios::in);

    if (archivo.fail()){
        cout<<"No se pudo abrir el archivo";
        exit(1);
    }
    while (!archivo.eof()){
        getline(archivo,texto);
        iniciales.insert(texto);
        cantidades[texto]++;
    }

    int sum = 0;
    for(auto it: iniciales){
        sum += cantidades[it];
    }

    for(auto it: iniciales){
        if( (cantidades[it] / sum) * 100 >= 20){
            cout << "El pais " << paises[it] << " excede el limite con "  << cantidades[it] << endl;
        }else{
            cout << "El pais " << paises[it] << " tuvo -> "  << cantidades[it] << endl;
        }
    }

    archivo.close();
}