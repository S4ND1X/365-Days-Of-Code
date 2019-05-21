#include <iostream>
using namespace std;
//Create a macro, for from 0 to a limit
#define forA(n) for(int x = 0; x<n; x++)
//From limit to 0
#define forD(n) for(int x = n; x>=0; x--)

int main(){

    //Example Array
    int arr[] = {6,7,9,2,54,6,1,3,6,8,2,1};
    int i, j, aux, min;

    //? Selection sort    
    for(i = 0; i<12; i++){
        min = i;
        for(j = i+1; j<12; j++){
            if(arr[j] < arr[min]){
                //Checks for the lowest number
                min = j;
            }
        }
        //Swap variables
        aux = arr[i];
        arr[i] = arr[min];
        arr[min] = aux;
    }

    printf("Ascendente:  ");
    forA(12){
        printf("%d->",arr[x]);
    }
    printf("\nDescendente:  ");
    forD(12){
        printf("%d->",arr[x]);    
    }
    return 0;
}