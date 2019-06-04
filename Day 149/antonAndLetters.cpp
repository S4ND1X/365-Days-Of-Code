// A. Anton and Letters
// time limit per test2 seconds
// memory limit per test256 megabytes
// inputstandard input
// outputstandard output
// Recently, Anton has found a set. The set consists of small English letters. Anton carefully wrote out all the letters from the set in one line, separated by a comma. He also added an opening curved bracket at the beginning of the line and a closing curved bracket at the end of the line.

// Unfortunately, from time to time Anton would forget writing some letter and write it again. He asks you to count the total number of distinct letters in his set.
#include <iostream>
#include <set>
using namespace std;

int main(){

    set <char> s;
    string word;
    //?Se usa getline para cuando quieres leer también espacios en blanco
    getline(cin, word);
    //Si la letra esta entre a y z se agrega al set
    for(int i = 0; i < word.length(); i++){
        if(int(word[i]) >= 97 && int(word[i]) <= 122){
            s.insert(word[i]);  
    } 

    cout << s.size() << endl;

    return 0;
}