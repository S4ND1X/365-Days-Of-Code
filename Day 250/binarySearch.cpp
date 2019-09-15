#include <iostream>
using namespace std;
int main(){

    int arr[] = {1,2,3,4,5,6,7,8,9,10};
    int min, max, mid, number;
    bool flag = false;

    cin >> number;

    min = 0;
    max = (sizeof(arr) / sizeof(arr[0]))-1;

    //Busqueda binaria
    while(min+1 != max){

        mid = (min+max)/2;
        if(arr[mid] == number){
            flag = true;
            break;
        }
        //Si es mayor el medio, ahora sera el nuevo limite
        if(arr[mid] > number){
            max = mid;
            mid = (min+max) / 2; 
        }
        //Si es menor el meido ahora sera el nuevo limite inferior
        else if (arr[mid] < number){
            min = mid;
            mid = (min+max) / 2;
        }
    }
    if(flag){
        printf("El numero esta en la posicion %d", mid);
    }
    else printf("El numero NO estaba en el arreglo");
    return 0;
}