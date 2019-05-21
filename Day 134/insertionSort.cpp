#include <iostream>
using namespace std;
//Create a macro, for from 0 to a limit
#define forA(n) for(int x = 0; x<n; x++)
//From limit to 0
#define forD(n) for(int x = n; x>=0; x--)

int main(){

    //Example Array
    int arr[] = {6,7,9,2,54,6,1,3,6,8,2,1};
    int i, pos, aux;

    //? Insertion sort    
    for(i = 0; i<12; i++){
        pos = i;
        //?Actual number
        aux = arr[i];
        //?If number in the left is bigger than the actual, swap.
        while((pos>0) && (arr[pos-1] > aux)){
        arr[pos] = arr[pos -1];
        pos--;
        }
        arr[pos] = aux;
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