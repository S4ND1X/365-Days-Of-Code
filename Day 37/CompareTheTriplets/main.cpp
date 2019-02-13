#include <iostream>
using namespace std;
//Function to compare
void compareArrays(int arr1[3],int arr2[3]){
    int points1 = 0, points2 = 0;
    for (int i =0; i<3; i++){
            if (arr1[i]>arr2[i])points1++;
            else if (arr1[i]<arr2[i])points2++;
            }
        cout << points1 << " " << points2 <<endl;
}
int main()
{
    //Adding items to list
    int n, array1[3],array2[3];
    cin >> array1[0] >> array1[1] >> array1[2];
    cin >> array2[0] >> array2[1] >> array2[2];
    //Calling the function
    compareArrays(array1,array2);
}
