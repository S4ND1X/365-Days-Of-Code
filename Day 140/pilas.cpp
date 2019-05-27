#include<iostream>
using namespace std;

typedef struct Nodo
{ 
    int dato;

 struct Nodo *sgt;

}TNodo;

typedef struct Pila
{
  TNodo *cabeza;
}TPila;

//Se crea el nodo
TNodo *crearNodo(int x)
{

 TNodo *nodo = (TNodo*)malloc(sizeof(TNodo));

    nodo->dato = x;

    nodo->sgt = NULL;

    return nodo;

}
