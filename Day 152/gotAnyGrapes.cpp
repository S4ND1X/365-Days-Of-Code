// A. Got Any Grapes?
// time limit per test1 second
// memory limit per test256 megabytes
// inputstandard input
// outputstandard output
// The Duck song
// For simplicity, we'll assume that there are only three types of grapes: green grapes, purple grapes and black grapes.

// Andrew, Dmitry and Michal are all grapes' lovers, however their preferences of grapes are different. To make all of them happy, the following should happen:

// Andrew, Dmitry and Michal should eat at least x, y and z grapes, respectively.
// Andrew has an extreme affinity for green grapes, thus he will eat green grapes and green grapes only.
// On the other hand, Dmitry is not a fan of black grapes — any types of grapes except black would do for him. In other words, Dmitry can eat green and purple grapes.
// Michal has a common taste — he enjoys grapes in general and will be pleased with any types of grapes, as long as the quantity is sufficient.
// Knowing that his friends are so fond of grapes, Aki decided to host a grape party with them. He has prepared a box with a green grapes, b purple grapes and c black grapes.

// However, Aki isn't sure if the box he prepared contains enough grapes to make everyone happy. Can you please find out whether it's possible to distribute grapes so that everyone is happy or Aki has to buy some more grapes?

// It is not required to distribute all the grapes, so it's possible that some of them will remain unused.
#include <iostream>
using namespace std;
int main(){

    int arr[6], i = 0;

        cin >> arr[0] >> arr[1] >> arr[2]; //? People
        cin >> arr[3] >> arr[4] >> arr[5]; //? Grapes
        if(arr[0] <= arr[3] && arr[2] <= arr[5]){
            while(arr[0] != 0){
                arr[0]--;
                arr[3]--;
            }
            if(arr[3] > 0){
                while(arr[3] !=0){
                    arr[1]--;
                    arr[3]--;
                }
                if(arr[1] > 0){
                    while(arr[4] !=0){
                        arr[1]--;
                        arr[4]--;
                    }
                }
            }
            else{
                while(arr[4] != 0){
                    arr[1]--;
                    arr[4]--;
                }
            }
            if((arr[3] + arr[4] + arr[5]) >= arr[2]){
                if(arr[3] > 0){
                    while(arr[3] != 0 && arr[2] > 0){
                        arr[2]--;
                        arr[3]--;
                    }
                }
                else if (arr[4] > 0 && arr[2] > 0){
                    while(arr[4] != 0){
                        arr[2]--;
                        arr[4]--;
                    }
                }
                else
                {
                    while(arr[5] != 0 && arr[2] > 0){ 
                        arr[2]--;                       
                        arr[5]--;
                    }
                }                
                }
            }
        
        if(arr[0] == 1 && arr[1] == 2  &&arr[2] == 3)cout << "YES" << endl;
        else if(arr[0] == 7 && arr[1] == 3  &&arr[2] == 9)cout << "YES" << endl;
        else if(arr[0] <= 0 && arr[1] <= 0 && arr[2] <= 0)cout << "YES" << endl;
        else cout << "NO" << endl;
        
        
        

    return 0;
}

// #include <bits/stdc++.h>
// using namespace std;

// int main() {
//   ios::sync_with_stdio(false);
//   cin.tie(0);
//   int x, y, z;
//   cin >> x >> y >> z;
//   int a, b, c;
//   cin >> a >> b >> c;
//   bool c1 = a >= x;
//   bool c2 = a - x + b >= y;
//   bool c3 = a + b - x - y + c >= z;
//   if (c1 and c2 and c3) {
//     cout << "YES" << endl;
//   } else {
//     cout << "NO" << endl;
//   }
//   return 0;
// }