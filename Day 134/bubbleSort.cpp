#include <iostream>
using namespace std;
//Create a macro, for from 0 to a limit
#define forA(n) for(int x = 0; x<n; x++)
//From limit to 0
#define forD(n) for(int x = n; x>=0; x--)
int main(){

    //Example Array
    int arr[] = {6,7,9,2,54,6,1,3,6,8,2,1};
    int i, j, aux;

    //? Bubble sort
    for(i = 0; i<12; i++){
        for(j = 0; j<12; j++){
            if(arr[j] > arr[j+1]){
                aux = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = aux;
            }
        }
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