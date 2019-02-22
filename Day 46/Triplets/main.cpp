#include <iostream>
#include <vector>
using namespace std;
//Checa las posiciones de los numeros
int triplesLista(vector <int> arr){    
    for (int x = 0; x<arr.size(); x++){
        if (arr[x] % 3 == 0) cout << x+1 << " ";        
    }    
}

int main()
{
    vector <int> arr;
    int numberArray, arrayLen, cant = 0;
    cin >> arrayLen;
    //Si es divisible entre 3 se suma a la cantidad
    for (int i = 0; i <arrayLen ; i++){
        cin >> numberArray;
        if (numberArray % 3 == 0)cant++;
        arr.push_back(numberArray);        
    }
    if (cant == 0)cout << "No hay triples." << endl;
    else cout << cant << endl;
    triplesLista(arr);

    return 0;
}
