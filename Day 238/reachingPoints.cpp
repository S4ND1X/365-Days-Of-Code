#include <iostream>

using namespace std;
string canReach(int x1, int y1, int x2, int y2);

int main(){

    int x1, y1, x2, y2;
    cin >> x1 >> y1 >> x2 >> y2;
    cout << canReach(x1, y2, x2, y2);

    return 0;
}

/*
* (x+y,y)
* (x, x+y)
*/

string canReach(int x1, int y1, int x2, int y2) {
    if(y1 > y2 || x1 > x2) return "No";

    else if (x1 == x2 && y1 == y2) return "Yes";
    else if(x1+ y1 <= x2) return canReach(x1 + y1,y1, x2, y2);
    else if(x1 + y1 <= y2) return canReach(x1,y1 + x1, x2, y2);
    return "No";
}
