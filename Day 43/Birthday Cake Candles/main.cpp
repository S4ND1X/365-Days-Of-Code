#include <iostream>
#include <vector>
using namespace std;
//Recibe un Array y cual es el numero maximo
int tallestCandles(vector<int> aArr, int maxNumber){
    int cantMax = 0;
    //Recorre todos los numeros y si es igual a max suma uno
    for (int x = 0; x < aArr.size(); x++){
        if (aArr[x] == maxNumber)cantMax++;
    }
    return cantMax;
}
int main()
{
    //Se declara el Array y despues se pide la cantidad de numeros
    vector <int> arr;
    int maxNumber = -1;
    int arrayLenght, numberArray;
    cin >> arrayLenght;
    //Se piden los numeros
    for (int i =0; i<arrayLenght; i++){
            cin >> numberArray;
            arr.push_back(numberArray);
            //Si el numero es mayor al anterior se reasigna el valor
            if (numberArray > maxNumber)maxNumber = numberArray;

    }
    cout << tallestCandles(arr, maxNumber) << endl;
    return 0;
}
