#include <iostream>
#include <vector>
using namespace std;
int main() {
    int n, tmp = -1, index = -1, mxNum = -1;
    cin >> n;
    vector<int> types(n);
    for (int types_i = 0; types_i < n; types_i++) {
        cin >> types[types_i];
        if (types[types_i] > mxNum)
        mxNum = types[types_i];
    }
    vector<int> cnt(mxNum, 0);
    for (int i = 0; i < types.size(); i++)
        cnt[types[i]]++;
    for (int i = 0; i <= mxNum; i++) {
        if (cnt[i] > tmp) {
        tmp = cnt[i];
        index = i;
        }
    }
    cout << index << endl;
    return 0;
}
