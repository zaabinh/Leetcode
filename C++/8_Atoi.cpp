#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    long myAtoi(string s) {
        const long MAX = 2147483648;
        long sign = 1, val = 0, i = 0;
        while(s[i] == ' ' && i < s.size()) i++;
        if(s[i] == '-') sign = -1, i++;
        else if(s[i] == '+') i++;
        while(s[i] <= '9' && s[i] >= '0' && i < s.size())
        {
            val = val * 10 + (s[i++] - '0');
            if(val > MAX) {val = MAX; break;}
        }
        if(val == MAX && sign == 1) val--;
        return sign * val;
    }
};

int main()
{
    string s;
    Solution Solve;
    cin >> s;
    cout << Solve.myAtoi(s);
}
