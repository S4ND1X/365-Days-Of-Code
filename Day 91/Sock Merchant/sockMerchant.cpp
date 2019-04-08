#include <iostream>

using namespace std;

int main() {
    int arr[102],n,count[102] = {0},pares = 0;
    cin >> n;
    for(int i = 0; i < n; i++) {
        cin >> arr[i];
        count[arr[i]]++;
    }
    for(int i = 0; i < 101; i++){
        if(count[i]!= 0)pares+=count[i]/2;
    }
    cout << pares << endl;
    return 0;
}
