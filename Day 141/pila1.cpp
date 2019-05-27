//Crear pila
TPila *crearPila()
{
 TPila *Pila = (TPila*)malloc(sizeof(TPila));
    Pila->cabeza = NULL;
    return Pila;
}

//Agregar elementos a la pila
void Push(TPila *Pila, int x)
{
    TNodo *Nodo = crearNodo(x);
    Nodo->sgt = Pila->cabeza;    
    Pila->cabeza = Nodo;

}




