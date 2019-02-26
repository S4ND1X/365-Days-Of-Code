#include <iostream>
#include <conio.h>
#include <stdlib.h>
using namespace std;
//Definir la estructura basica
struct Nodo{
    int dato;
    Nodo *siguiente;
};
void agregarPila(Nodo *&, int);
void sacarPila(Nodo *&, int &);
int main(){
    //Al inicio es NULL porque no hay nada
    Nodo *pila = NULL;
    int dato;
    cout << "Dame un numero a insertar: " << endl;
    cin >> dato;
    agregarPila(pila,dato);
    cout << "Dame otro numero a insertar: " << endl;
    cin >> dato;
    agregarPila(pila,dato);

    cout << "Sacando los elementos de la pila: ";
    while(pila != NULL)//Mientras haya elementos se sacaran
    {
        sacarPila(pila,dato);
        if (pila != NULL)cout << dato << " , ";
        else cout << dato <<".";        
    }

    getch();
    return 0;
}

void agregarPila(Nodo *&pila, int n){
    //Crear nuevo nodo
    Nodo *nuevo_nodo = new Nodo();
    //Asignar el valor dentro del nodo
    nuevo_nodo->dato = n;
    //El siguiente del nuevo nodo ira a la cabeza
    nuevo_nodo->siguiente = pila;
    //La cabeza sera igual al nuevo nodo
    pila = nuevo_nodo;

    cout << "\nElemento " << n << " fue agregado a Pila" << endl;
}

void sacarPila(Nodo *&pila, int &n){
    //Se crea un auxiliar a la cabeza
    Nodo *aux = pila;
    //Se iguala el dato al siguiente de la cabeza
    n = aux->dato;
    //La cabeza sera el que sigue de si
    pila = aux->siguiente;
    //Se borra la cabeza
    delete aux;
}
