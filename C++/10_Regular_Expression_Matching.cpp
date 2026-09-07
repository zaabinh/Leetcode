#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool isLetter(char a)
    {
        return (a >= 'a' && a <= 'z');
    }
    bool Match(string s, string p) {
        if(p.size() > s.size()) return 0;
        int pos = p.find("*");
        if(pos >= p.size() && p.size() < s.size()) return 0;
        int i = 0, j = 0;
        while(i < s.size() && j < p.size())
        {
            if(isLetter(p[j]) && s[i] != p[j]) return 0;
            if(p[j] == '.' || s[i] == p[j]) {i++; j++; continue;}
            if(p[j] == '*')
            {
                if(p[j - 1] != '.')
                {
                    while(i < s.size() && s[i] == p[j - 1]) i++;
                    if(j + 1 == p.size() && i < s.size()) return 0;
                    j++;
                } else
                {
                    i = s.find(p[j + 1], i + 1);
                    j++;
                }
            }
        }
        return 1;
    }
    bool isMatch(string s, string p)
    {
        for(int i = 0; i < p.size(); i++)
        {
            for(int j = i; j < p.size(); j++)
            {
                string sub = p.substr(i, j - i + 1);
                cout << sub << endl;
                if(Match(s, sub)) return 1;
            }
        }
        return 0;
    }
};

int main()
{
    string s, p;
    s = "mississippi";
    p = "mis*is*p*.";
    Solution Solve;
    cout << Solve.isMatch(s, p);
}
