#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int n = s.size(), ans = 0;
        vector<bool> mark(256);
        int r = 0;
        for(int l = 0; l < n; l++)
        {
            while(!mark[s[r]] && r < n)
            {
                mark[s[r]] = 1;
                ans = max(ans, r - l + 1);
                r++;
            }
            mark[s[l]] = 0;
        }
        return ans;
    }

};

int main()
{
    string s;
    getline(cin, s);
    Solution Solve;
    int ans = Solve.lengthOfLongestSubstring(s);
    cout << ans;
}
