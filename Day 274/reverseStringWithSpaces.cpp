#include <iostream>
using namespace std;

string reverseString(string frase);
int main(){

    string frase = "hola  como estas";
    cout << reverseString(frase) << endl;
    return 0;
}

string reverseString(string frase){
    int i = 0;
    int start = 0, end;
    for(i; i< frase.length(); i++){
        if(frase[i] == ' ' || i == frase.size()){
            end = i - 1;
            while(start < end){
                swap(frase[start], frase[end]);
                start++;
                end--;
            }
            start = i + 1;
        }
    }

    return frase;
}