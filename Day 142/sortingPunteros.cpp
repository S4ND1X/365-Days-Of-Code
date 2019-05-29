#include <iostream>

using namespace std;

void pedirDatos();
void ordenarArr(int *, int);
void mostrarArr(int *, int);

int nElementos, *elemento;

int main(){
    pedirDatos();
    ordenarArr(elemento, nElementos);
    mostrarArr(elemento, nElementos);

    delete[] elemento;
    return 0;
}

void pedirDatos(){
    cin >> nElementos;
    elemento = new int[nElementos];
    for(int i = 0; i < nElementos; i++)cin >> *(elemento+i); // elemento[i]
}
void ordenarArr(int *elemento, int nElementos){
    int aux;
    for(int i = 0; i<nElementos; i++){
        for(int j = 0; j < nElementos-1; j++){
            if(*(elemento+j)  > *(elemento+j+1)){
                aux =  *(elemento+j);
                *(elemento+j) = *(elemento+j+1);
                *(elemento+j+1) = aux; 
            }
        }
    }
}

void mostrarArr(int *elemento, int nElementos){
    for(int i = 0; i < nElementos; i++){
        cout << *(elemento+i) << "->";
    }
}