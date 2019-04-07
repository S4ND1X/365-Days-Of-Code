#include <bits/stdc++.h>
#include <iostream>
using namespace  std;

int main(){

    map<string,int>m;
    int n,q;
    string str;
    
    cin >> n;
    for(int i = 0; i < n; i++){
        cin >> str;
        m[str]++;
    }
    cin >> q;
    for(int i = 0; i < q; i++){
        cin >> str;
        cout << m[str] << endl;
    }
    return 0;
}