#include <iostream>
#include <vector>


using namespace std;

int elevacionRecursivo(int n, int y);

int main(){
    
    int n,y;
    cin >> n >> y;
    cout << n << " elevado a " << y <<  " es = " << elevacionRecursivo(n,y) << endl;


    return 0;
}

int elevacionRecursivo(int n, int y){
    if(y == 1) return n;
    else return n * elevacionRecursivo(n, y-1);
}
