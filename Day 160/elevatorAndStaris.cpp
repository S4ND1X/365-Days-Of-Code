#include <iostream>
using namespace std;

int main()
{
	int x,y,z,time1,time2,time3;

	cin >> x >> y >> z >> time1 >> time2 >> time3;
	int a=time1*abs(x-y);
	int b=(time2 * (abs(z - x) + abs(x - y))) +  (3 * time3);

	if (a<b)
	{
		
		cout << "NO" << endl;
	}
	else
	{
		
		cout << "YES" << endl;
	}

	return 0;
}