#include <iostream>
#include<vector>
#include<numeric>
using namespace std;

int simpleArraySum(vector<int> ar)
{
    int sum = 0;
    //return accumulate(ar.begin(), ar.end(),0);
    for(auto it: ar) sum+=it;
    return sum;
}

int main()
{
    vector<int>a {1,2,3,4,5};
    cout << simpleArraySum(a);
    return 0;
}