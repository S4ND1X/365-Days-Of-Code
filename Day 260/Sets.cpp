#include<iostream>
#include<set>
#include<algorithm>
using namespace std;
void setDemo(){
    //LogN to insert and order
    set<int> S;
    S.insert(1);
    S.insert(2);
    S.insert(7);
    S.insert(0);

    for(int i: S)
        printf("->%d",i);
    printf("\n");


    //0,1,2,7
    auto it = S.find(5);
    if(it == S.end()) cout << "Not present" << endl;
    else cout << "It's present" << endl;
    auto it2 = S.upper_bound(2); // >
    cout << *it2 << endl;
}
int main()
{
    setDemo();
    return 0;
}
