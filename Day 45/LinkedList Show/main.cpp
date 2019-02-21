#include <iostream>
#include <conio.h>
using namespace std;
struct Nodo {
    int dato;
    //How to declare a pointer
    Nodo *siguiente;
};
//Insert Function
void insertarLista(Nodo *&,int);
//Show list
void mostrarLista(Nodo *);
int main(){
    int dato;
    Nodo *lista = NULL;
    cout << "Ponga un numero: " << endl;
    cin  >> dato;
    insertarLista(lista,dato);
    cout << "Ponga un numero: " << endl;
    cin  >> dato;
    insertarLista(lista,dato);
    cout << "Ponga un numero: " << endl;
    cin  >> dato;
    insertarLista(lista,dato);
    mostrarLista(lista);
    getch();
    return 0;
}
void insertarLista(Nodo *&lista,int n){
    //Crear nodo
     Nodo *nuevo_nodo = new Nodo();
     //Valor a meter
     nuevo_nodo->dato = n;

     Nodo *aux1 = lista;
     Nodo *aux2;
     while((aux1 != NULL) && (aux1->dato < n)){
        aux2 = aux1;
        aux1 = aux1->siguiente;
     }
     if (lista == aux1){
        lista = nuevo_nodo;
     }
     else{
        aux2->siguiente = nuevo_nodo;
     }
     nuevo_nodo->siguiente = aux1;
     cout <<"\tElemento: " << n << " insertado correctamente" << endl;
}
void mostrarLista(Nodo *lista){
    //Crear Nodo
    Nodo *actual = new Nodo();
    //Igualar a lista o al primero
    actual = lista;
    //Mientras no sea NULL moostrar los valores
    while (actual != NULL){
            //Mostrar el dato del nodo
        cout << actual->dato << " ->";
        //Pasar al sigueinte nodo.
        actual = actual->siguiente;
    }
}
