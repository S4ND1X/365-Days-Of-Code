#include<iostream>
#include<string>

using namespace std;

//?Recibe un string y checa cuantas palabras hay en el string formato camelCase;
int countWordsInCamelCase(string s){
    int cont = 1;
    if(s.size() == 1) { return cont; }
    else{
        for(int i = 0; i < s.size(); i++){
            if(int(s[i]) >= 65 && int(s[i]) <=90) { cont++; }
        }
    }
    return cont;
}
int main(){
    string s;
    cin >> s;
    cout << countWordsInCamelCase(s);

    return 0;
}