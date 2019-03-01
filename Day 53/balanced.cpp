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
void recorrerPila(Nodo *&);
int main(){

    Nodo *pila = NULL;
    char character;
    for (int i = 0; i<5; i++){
    cout << "Dame un caracter: " << endl;
    cin >> character;
    if (character == ')' and i == 0)break;           
    }  
    recorrerPila(pila);
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
    cout << "Elemento " << parentesis << " agregado correctamente" << endl;
}
void recorrerPila(Nodo *&pila){
    //Se crea un nodo temporal
    Nodo *temp = new Nodo();
    //El temp se iguala a la cabeza
    temp = pila;
    //Mientras que el elemento actual sea diferente a Null se va a imprimir
    do{
        cout << temp->dato << endl;
        //El temp se igualara al elemento siguiente
        temp = temp->nextElement;
    }while (temp != NULL);    
}


