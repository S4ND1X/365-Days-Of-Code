#include <iostream>
using namespace std;
int main(){

    int arr[] = {9,4,3,2,6,7,4,2,1};
    int dato,i = 0;
    bool flag = false;

    cin >> dato;
    //Busqueda secuencial
    while((!flag) && (i < sizeof(arr)/sizeof(arr[0])) ){
        if(arr[i] == dato)flag = true;
        i++;
    }

    if(flag)printf("El numero %d, si esta en el arreglo en la posicion: %d",dato,i-1);
    else printf("El numero %d, no esta en el arreglo",dato);

    return 0;
}