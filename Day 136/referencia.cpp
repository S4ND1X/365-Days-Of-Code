#include <iostream>
using namespace std;
void calcular(int, int, int&, int&);
int main (){

    int num1, num2, sum = 0, product = 0;
    cin >> num1 >> num2;
    calcular(num1, num2, sum, product);

    printf("La suma de %d + %d es = %d y su producto es %d",num1, num2, sum, product);

    return 0;
}

void calcular(int num1, int num2, int& sum, int& product){
    sum = num1 + num2;
    product = num1*num2;
}