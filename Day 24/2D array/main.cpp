#include <iostream>

using namespace std;

int main()
{
    //Rows, and Columns
    int numberGrid[3][2] = {
                          {1, 2},
                          {3, 4},
                          {5, 6}
                          };


    //How to iterate trough the 2d array
    for(int i = 0; i<3; i++){
        for (int j = 0; j<2; j++){
            cout << numberGrid[i][j];
        }
        cout << endl;
    }
    return 0;
}
