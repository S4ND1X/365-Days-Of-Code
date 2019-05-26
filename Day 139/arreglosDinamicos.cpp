#include <iostream>
#include <stdlib.h>
using namespace std;

//?New : Reserva un numero de bytes solicitado
//? Delete : Libera bloque de bytes reservado

void pedirDatos();
void mostrarDatos();
    //Tamaño de array y puntero para cada calificacion
int numCal, *cal;

int main(){

    pedirDatos();
    mostrarDatos();

    //Despues de ya no usar el array se libera la memoria que habiamos asignado para ese array
    delete[] cal; 

    return 0;
}
void pedirDatos(){
    cin >> numCal;
    //Se crea de esta manera para reservar exactamente la memoria que necesitas
    cal = new int[numCal]; //Crear arreglo dinamico y asignarlo al puntero en la primera posicion
    //Guardar las calificaciones en esa posicion de memoria
    for(int i = 0; i  < numCal; i++)cin >> cal[i];
}
void mostrarDatos(){
    for(int i = 0; i < numCal; i++) cout << cal[i] << ", ";
}
