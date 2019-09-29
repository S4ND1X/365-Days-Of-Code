#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
void reverseString(string &str);
int main()
{
    //*----------------------------  Reverse String   ----------------------------*
    string myStr;
    cin >> myStr;
    cout << &myStr[2] << endl;
    reverseString(myStr);
    cout << myStr << endl;


    //*----------------------------  Reverse Array   ----------------------------*
    int arr[] = {1,2,3,4,5,6};
    int i = 0,
        j = 5;

    for(i,j; i < j; i++, j--){
        swap(arr[i], arr[j]);
    }

    return 0;
}
void reverseString(string &str){
    int n = str.length();
    for(int i = 0; i < n / 2; i++){
        swap(str[i], str[n - i - 1]);
    }
}
