#include <iostream>
#include <vector>
using namespace std;

vector<int> mergeVectors(vector<int> arr1, vector<int> arr2);

int main()
{

    vector<int> arr1{1, 2, 3, 4, 5, 6};
    vector<int> arr2{1, 2, 3, 4, 5, 6};

    for (int it : mergeVectors(arr1,arr2)) {
        cout << it << " -> ";
    }

    return 0;
}
vector<int> mergeVectors(vector<int> arr1, vector<int> arr2){
    vector<int> arr3;
    unsigned short int i = 0, j = 0;
    //Two pointers at each array, and advance if tht element has been inserted
    while (i < arr1.size() && j < arr2.size())
    {
        if (arr1[i] < arr2[j]) { arr3.push_back(arr1[i++]); }
        else { arr3.push_back(arr2[j++]); }
    }
    // Fill with the remaining numbers
    while (i < arr1.size())
    {
        arr3.push_back(arr1[i++]);
    }
    while (j < arr2.size())
    {
        arr3.push_back(arr2[j++]);
    }
    return arr3;
}