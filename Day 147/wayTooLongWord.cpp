// A. Way Too Long Words
// time limit per test1 second
// memory limit per test256 megabytes
// inputstandard input
// outputstandard output
// Sometimes some words like "localization" or "internationalization" are so long that writing them many times in one text is quite tiresome.

// Let's consider a word too long, if its length is strictly more than 10 characters. All too long words should be replaced with a special abbreviation.

// This abbreviation is made like this: we write down the first and the last letter of a word and between them we write the number of letters between the first and the last letters. That number is in decimal system and doesn't contain any leading zeroes.

// Thus, "localization" will be spelt as "l10n", and "internationalization» will be spelt as "i18n".

// You are suggested to automatize the process of changing the words with abbreviations. At that all too long words should be replaced by the abbreviation and the words that are not too long should not undergo any changes.



#include <iostream>
using namespace std;
//?Prototipo de funcion
void tooLong(string word);
void pedirDatos(int n);

int main(){
    int n;
    cin >> n;
    pedirDatos(n);
    return 0;
}

void pedirDatos(int n){
    //Pide datos y llama a la funcion
    string word; 
    for(int i = 0; i < n; i++){       
        cin >> word;
        tooLong(word);    
    }

}

void tooLong(string word){
    //?Si la palabra es mayor a 10 letras se cortara
    if(word.length() > 10){        
        int i = 1;
        //?Se cuenta cada letra que hay entre la primera y la ultima letra
        for(i; i < word.length()-2; i++);
        //?I se quedo con ese valor, y se regresa la primera letra, más el numero de letras en medio y la ultima letra
        cout <<  word[0] << to_string(i) << word[word.length()-1] << endl;
    }
    else cout << word << endl;
}

