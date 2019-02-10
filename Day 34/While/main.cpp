#include <iostream>

using namespace std;

int main()
{
    int option = 1;
    int i = 0;
    while (option !=5){
    cout << "Press any other number than 5" << endl;
    cin >> option;
    i++;
    if (i == 10){
        cout << "You are really patient you win" << endl ;

    }
    }
    return 0;
}
