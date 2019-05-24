#include <iostream>


using namespace std;

int sumaRecursivo(int num);

int main(){
    int num = 100;
    cout << "La suma hasta el numero " << num << " es " << sumaRecursivo(num);


    return 0;
}

int sumaRecursivo(int num){
    if(num == 1) return 1;
    else return num + sumaRecursivo(num-1);

}
