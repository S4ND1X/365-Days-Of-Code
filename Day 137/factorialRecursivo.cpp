#include <iostream>

using namespace std;

int factorialRecursivo(int num);

int main(){
    
    int wea = factorialRecursivo(10);
    printf("%d",wea);


    return 0;
}

int factorialRecursivo(int num){
    if(num == 1 ) return num;
    else return num * factorialRecursivo(num-1);
    
}
