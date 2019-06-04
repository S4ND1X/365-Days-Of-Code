// A. Word Capitalization
// time limit per test2 seconds
// memory limit per test256 megabytes
// inputstandard input
// outputstandard output
// Capitalization is writing a word with its first letter as a capital letter. Your task is to capitalize the given word.

// Note, that during capitalization all the letters except the first one remains unchanged.


#include <iostream>
#include <string>

using namespace std;

int main(){

    string word;
    cin >> word;
    //?putchar imprime letra del valor ascci, toupper regresa el int del valor ascii en mayuscula    
    cout << to_string(putchar(toupper(word[0]))).substr(0,0) << word.substr(1,word.length()-1);
    return 0;
}