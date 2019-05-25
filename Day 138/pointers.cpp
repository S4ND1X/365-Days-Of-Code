#include <iostream>
using namespace std;
int main(){

    int numeros[] = {4,3,2,5,9,10,1,6,7,8};
    int *dir_numeros;
    //Asignar al puntero la posicion de memoria del primer elemento
    dir_numeros = numeros;
    for(int i = 0; i < 10; i++){
        //Si el valor que esta en esa posicion de memoria es par se imprime
        if(*dir_numeros % 2 == 0){
            //*dir_numeros imprime el valor y dir_numeros imprime la direccion de memoria
            cout << "El numero " << *dir_numeros<<" en la posicion de memoria " << dir_numeros<< " es par." << endl;
        }
        //Aumentar 4 bytes para cambiar a la siguiente posicion del array
        dir_numeros++;
    }
    //Restablecer direccion a primera posicion de arreglo
    int aux = numeros[0];
    dir_numeros = numeros;
    for(int i = 0; i < 10; i++){
        //Si el valor en la posicion de memoria es menor, ese sera el nuevo minimo.
        if(*dir_numeros < aux) aux = *dir_numeros;
        dir_numeros++;
    }
    cout << "El numero menor es : " << aux;

    return  0;
}