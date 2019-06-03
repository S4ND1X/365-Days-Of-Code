// A. Team
// time limit per test2 seconds
// memory limit per test256 megabytes
// inputstandard input
// outputstandard output
// One day three best friends Petya, Vasya and Tonya decided to form a team and take part in programming contests. Participants are usually offered several problems during programming contests. Long before the start the friends decided that they will implement a problem if at least two of them are sure about the solution. Otherwise, the friends won't write the problem's solution.

// This contest offers n problems to the participants. For each problem we know, which friend is sure about the solution. Help the friends find the number of problems for which they will write a solution.



#include <iostream>
using namespace std;
//?Prototipo de funcion
void solves(int, int, int);
//?Variable global
int nSolves = 0;
int main(){

    int n, p, v,t;
    cin >> n;
    for(int i = 0; i < n ; i++){
        cin >> p >> v >> t;
        solves(p,v,t);
    }
    cout << nSolves << endl;
    return 0;
}

void solves(int n1, int n2, int n3){
    //?Si más de una persona lo puede resolver se suma    
    if(n1 + n2 + n3 >= 2)nSolves++;    
}