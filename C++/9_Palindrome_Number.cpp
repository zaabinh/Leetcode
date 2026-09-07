#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool isPalindrome(long x) {
        if(x < 0) return 0;
        long x1 = x, rev = 0;
        do
        {
            rev = rev * 10 + x1 % 10;
        } while(x1 /= 10);
        return (rev == x);
    }
};

int main()
{

}
