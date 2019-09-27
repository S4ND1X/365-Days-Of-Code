#include <iostream>
#include <set>
#include<map>
#include <vector>
#include <bits/stdc++.h>
using namespace std;

int main(){

    unordered_set <int> s;
    vector <int> vec{2,3,4,5,7,2,1,5,5,5,5,10};
    for(auto it: vec) s.insert(abs(11-it));

    for(auto it: vec) s.find(it) != s.end() ? cout << true << endl: cout << false << endl;


    vector<int> arr {3,2,2,5,6,1,8,3,2};
    map<int, int> m;

    for(auto it: arr){
        m[it]++;
        if(m[it] >= 2){
            cout << "The first recurring value is: " << it << endl;
            break;
        }
    }




    return 0;
}