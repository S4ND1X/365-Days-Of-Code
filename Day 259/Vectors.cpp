#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int main()
{
    vector<int>vec{14,3,25,12,65,76};

    sort(vec.begin(), vec.end()); // 0(NlogN)

    //3,12,14,25,65,76
    //binary search O(LogN)

    bool present = binary_search(vec.begin(),vec.end(), 65),
        present1 = binary_search(vec.begin(),vec.end(), 65);

    vec.push_back(100);
    vec.push_back(100);
    vec.push_back(100);
    vec.push_back(100);
    vec.push_back(100);
    vec.push_back(123);

    vector<int>::iterator  it = lower_bound(vec.begin(),vec.end(), 100); //Regresa el primer elemento que sea >=
    vector<int>::iterator  it1 = upper_bound(vec.begin(),vec.end(), 100); //Regresa el primer elemento que sea >

    cout << *it << " " << *it1 << endl; //Imprimir lo que esta en la posicion
    cout << it1 - it;

    return 0;
}
