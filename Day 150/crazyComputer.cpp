//  Crazy Computer
// time limit per test2 seconds
// memory limit per test256 megabytes
// inputstandard input
// outputstandard output
// ZS the Coder is coding on a crazy computer. If you don't type in a word for a c consecutive seconds, everything you typed disappear!

// More formally, if you typed a word at second a and then the next word at second b, then if b - a ≤ c, just the new word is appended to other words on the screen. If b - a > c, then everything on the screen disappears and after that the word you have typed appears on the screen.

// For example, if c = 5 and you typed words at seconds 1, 3, 8, 14, 19, 20 then at the second 8 there will be 3 words on the screen. After that, everything disappears at the second 13 because nothing was typed. At the seconds 14 and 19 another two words are typed, and finally, at the second 20, one more word is typed, and a total of 3 words remain on the screen.

// You're given the times when ZS the Coder typed the words. Determine how many words remain on the screen after he finished typing everything.

#include <iostream>
#include<bits/stdc++.h>
using namespace std;
int main()
{
        long long int i,j,k;
        long long int n,c,count=0;

        cin>>n>>c;
        long long int a[n];

        for(i=0;i<n;i++)
            cin>>a[i];
        //? Si paso más tiempo del permitido se reinicia a 0
        for(i=0;i<n-1;i++)
        {
                if(a[i+1]-a[i]>c)
                    count=0;
                else
                    count++;
        }

        cout<<count+1;

        return 0;
}