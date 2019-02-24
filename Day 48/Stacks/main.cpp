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

int main(){
    //Al inicio es NULL porque no hay nada
    Nodo *pila = NULL;
    int n1,n2;
    cout << "Dame dos numeros a insertar: " << endl;
    cin >> n1 >> n2;
    agregarPila(pila,n1);
    agregarPila(pila,n2);

    getch();
    return 0;
}

void agregarPila(Nodo *&pila, int n){
    //Crear nuevo nodo
    Nodo *nuevo_nodo = new Nodo();
    //Asignar el valor dentro del nodo
    nuevo_nodo->dato = n;
    nuevo_nodo->siguiente = pila;
    pila = nuevo_nodo;

    cout << "\nElemento " << n << " fue agregado a Pila" << endl;
}
