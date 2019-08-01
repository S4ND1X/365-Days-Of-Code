
#include <iostream>
#include <set>

using namespace std;

int main(){

    set<char> nonRepeated;
    set<char> repeated;

    string myString;

    cin >> myString;

    for(int i = 0; i < myString.length(); i++){
        if(nonRepeated.count(myString[i]) == 0)nonRepeated.insert(myString[i]);
        else repeated.insert(myString[i]);
    }

    set<char>::iterator setIt = repeated.begin();
    for(int i = 0; i < repeated.size() ; i++){
        cout<< *setIt << endl;
        setIt++;
    }

    return 0;
}
