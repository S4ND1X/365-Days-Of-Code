#include <iostream>
#include <vector>
using namespace std;

bool aIsBiger(int, int);
vector<int> compareTriplets(vector<int>, vector<int>);
void imprimirVector(vector<int> arr)
{
    for (auto it : arr)
        cout << it << " ";
}
int main()
{
    //*Pedir datos, si ya pidio tres entonces mete en segundo array
    vector<int> a, b;
    int num;
    for (int i = 0; i < 6; i++)
    {
        cin >> num;
        if (i < 3){
            a.push_back(num);
        }else{
            b.push_back(num);
        }
    }

    imprimirVector(compareTriplets(a, b));

    return 0;
}
//?Comprueba si a es mayor a b
bool aIsBiger(int a, int b)
{
    return a > b ? true : false;
}

//?Regresa el vector con las puntuaciones
vector<int> compareTriplets(vector<int> a, vector<int> b)
{
    int sum1 = 0,
        sum2 = 0;
    for (int i = 0; i < 3; i++)
    {
        if (aIsBiger(a[i], b[i])) {
            sum1++;
        }else{
            sum2 += a[i] == b[i] ? 0 : 1;
        }
    }
    vector<int> c{sum1, sum2};
    return c;
}