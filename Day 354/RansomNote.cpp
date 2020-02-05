/**
*  Given an arbitrary ransom note string and another string containing letters from all the magazines, 
*  write a function that will return true if the ransom note can be constructed from the magazines; 
*  otherwise, it will return false. 
*  Each letter in the magazine string can only be used once in your ransom note.
*/


#include <iostream>
#include <unordered_map>
using namespace std;

bool canConstruct(string ,string);
int main(){


    cout << canConstruct("abcd","abcc");


    return 0;
}
/**
 * Se crea un map, se guarda el numero de ocurrencias de las letras de magazine
 * y al final se le resta las ocurrencias de las notas, si en algun momento es negativo regresa false
 * @param note es el string que necistas saber si es posible construirse
 * @param magazine es el string con el que debes de construir la nota 
 */
bool canConstruct(string note, string magazine){
    //Se crea un map vacio
    unordered_map<char,int> magazineCharacters;
    //Se agregan todas las ocurrencias de la letra
    for(auto i:magazine){
        magazineCharacters[i]++;
    }
    //Se recorre la nota y si no encuentra alguna letra, regresa falso o si es negativo
    for(auto i: note){
        //Si no encuentra ningun valor en esa key regresa false
        if(magazineCharacters.find(i) == magazineCharacters.end()){
            return false;
        }else if(magazineCharacters[i]-- < 0){
            return false;
        }
        magazineCharacters[i]--;
    }
    return true;
}