#include <iostream>
using namespace std;

//La funcion recibira variables float y son punteros
void swap(float *,float *);
int main(){

    float num1 = 12.5, num2 = 5.1;
    printf("Numero 1: %f, Numero 2 : %f",num1,num2);
    //Pasamos la direccion de memoria de las variables
    swap(&num1, &num2);    
    //Despues del cambio de valor 
    printf("\nNumero 1: %f, Numero 2 : %f",num1,num2);
    return 0;
}


void swap(float *dir_num1, float *dir_num2){
    //Cambio de variables clasico pero utilizando punteros
    float aux;
    aux = *dir_num1;
    *dir_num1 = *dir_num2;
    *dir_num2 = aux;
}
