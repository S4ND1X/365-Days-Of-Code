#include <iostream>
#include <conio.h>
#include <stdlib.h>
using namespace std;

//Nodo
struct Nodo{
    char dato;
    Nodo *nextElement;    
};
void agregarPila(Nodo *&, char); //Proto
int main(){

    Nodo *pila = NULL;
    char character;
    cout << "Dame un parentesis: ";
    cin >> character;
    agregarPila(pila, character);
    getch();      
    return 0;
}
void agregarPila(Nodo *&pila, char parentesis){
    //Crear el nodo
    Nodo *new_nodo = new Nodo();
    //Asignar valores a las propiedades de la estructura
    new_nodo->dato = parentesis;
    new_nodo->nextElement = pila;
    //Cabeza sera igual al nuevo nodo
    pila = new_nodo;
    cout << "Elemento " << parentesis << " agregado correctamente";
}