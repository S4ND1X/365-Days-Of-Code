#include <iostream>
#include <vector>
#include <set>
using  namespace std;
int main()
{
    vector<int>arr{12,12,3,4,5,6,7,8,9};
    set<int>s;
    for(int i: arr)s.insert(i);

    int max1 = *s.begin(), max2 = *s.begin();
    for(int i:s){
        if(i > max1){
            max2 = max1;
            max1 = i;
        }
    }
    cout << max2 << endl;

    return 0;
}
