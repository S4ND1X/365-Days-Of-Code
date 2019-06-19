#include <iostream>

using namespace std;

int main(){
    
    int number, k;    
    cin >>number >> k;
    //Si el numero termina en 0 se resta 50, si no, se resta 1
    for(int i = 0; i<k; i++){
        if(number % 10 == 0) number = number/10; 
        else number-=1;
    }  
    printf("%d\n",number);
    return 0;
}