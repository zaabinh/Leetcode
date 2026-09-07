#include<bits/stdc++.h>
using namespace std;

const long  range = (long) pow(2, 31);

class Solution {
public:
    long reverse(long x) {
        long a = abs(x);
        if(a > range) return 0;
        long ans = 0;
        while(a)
        {
            ans = ans * 10 + a % 10;
            if(ans > range) return 0;
            a /= 10;
        }
        return  (x < 0) ? -ans : ans;
    }
};

int main()
{
    long  x = 123124;
    Solution Solve;
    cout << Solve.reverse(x);
}
