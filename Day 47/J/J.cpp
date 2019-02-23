#include <iostream>
#include <vector>
using namespace std;

void printArr(int *cosa, int size){
    int i;
    for(i = 0; i < size; i++)
    {
       printf("%d ", cosa[i]);
    }
    printf("\n");
}

int main(){  
    int lista[4] ={1,2,3,4};

    int *cosa=lista;

    int size=sizeof(lista)/sizeof(lista[0]);
    printf("%d\n", size);

    printArr(cosa, size);
    return 0;
}

  /*vector<vector<int>> matrix;
    int matrixLenght;
    cin >> matrixLenght;
    for (int i = 0; i<matrixLenght; i++){
        for (int j = 0; j<i; j++){
            cin >> matrix[i][j];
        }
    }*/