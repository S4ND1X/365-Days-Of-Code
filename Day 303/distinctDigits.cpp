#include <iostream>
#include <vector>
#include <string>
#include <unordered_set>
using namespace std;

int distinctNumbers(int, int);
int main()
{

    int l, r;

    cin >> l, r;

    cout << distinctNumbers(l, r);

    return 0;
}

int distinctNumbers(int l, int r)
{
    unordered_set<char> mySet;
    for (int i = l; i <= r; i++)
    {
        string str = to_string(i);
        cout << str << endl;
        for (auto it : str)
        {
            mySet.insert(it);
        }
        for (auto it : mySet)
            cout << it << ".";
        if (mySet.size() == str.size())
        {
            return i;
        }
    }
    return -1;
}