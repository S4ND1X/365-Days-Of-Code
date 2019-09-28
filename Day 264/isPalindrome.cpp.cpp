#include <iostream>
#include <map>
using namespace std;
int main()
{

    string hola = "ala";
    int i = 0,
        j = hola.length() - 1;
    bool isPalindrome = true;
    for(i, j;  i < j ; i++, j--){
        if(hola[i] != hola[j]) isPalindrome = false;
    }
    if(isPalindrome) cout << "Es palindromo" << endl;
    else cout << "No es palindromo" << endl;


    return 0;
}
