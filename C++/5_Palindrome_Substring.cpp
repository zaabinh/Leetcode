#include<bits/stdc++.h>
using namespace std;

#define ll long long
const int N = 1e3 + 8;
const ll MOD = 1e9 + 7;
const ll base = 311;
ll p[N];


class Solution {
public:
    ll getHash(int i, int j, ll H[])
    {
        return ((H[j] - H[i - 1] * p[j - i + 1] + MOD * MOD) % MOD);
    }

    bool is_Palin(int i, int j, int n, ll Hs[], ll Ht[])
    {
        return (getHash(i, j, Hs) == getHash(n - j + 1, n - i + 1, Ht));
    }
    string longestPalindrome(string s) {
        ll Hs[N], Ht[N];
        int n = s.size();
        s = ' ' + s;
        p[0] = 1;
        Hs[0] = 0;
        Ht[0] = 0;
        for(int i = 1; i <= n; i++)
        {
            p[i] = (p[i - 1] * base) % MOD;
            Hs[i] = (Hs[i - 1] * base + s[i]) % MOD;
            Ht[i] = (Ht[i - 1] * base + s[n - i + 1]) % MOD;
        }
        int ans_l = 0, ans_r = 0;
        for(int i = 1; i <= n; i++)
        {
            int lo = 0, hi = min(i, n - i);
            while(lo <= hi)
            {
                int mid = (lo + hi) / 2;
                if(is_Palin(i - mid + 1, i + mid, n, Hs, Ht))
                {
                    if(2 * mid > ans_r - ans_l + 1) ans_l = i - mid + 1, ans_r = i + mid;
                    lo = mid + 1;
                } else hi = mid - 1;
            }

            lo = 0, hi = min(i, n - i);
            while(lo <= hi)
            {
                int mid = (lo + hi) / 2;
                if(is_Palin(i - mid, i + mid, n, Hs, Ht))
                {
                    if(2 * mid + 1 > ans_r - ans_l + 1) ans_l = i - mid, ans_r = i + mid;
                    lo = mid + 1;
                } else hi = mid - 1;
            }
        }
        ans_l = max(ans_l, 1);
        return s.substr(ans_l, ans_r - ans_l + 1);
    }
};

int main()
{
    string s;
    getline(cin, s);
    Solution Solve;
    string ans = Solve.longestPalindrome(s);
    cout << ans;
}
