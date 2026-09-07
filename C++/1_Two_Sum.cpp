#include<bits/stdc++.h>
using namespace std;
const int N = 1e4 + 8;
map <int,int> d;
int n, sum, a[N];
int main()
{
    cin >> n >> sum;
    for(int i = 1; i <= n; i++)
    {
        cin >> a[i];
        d[a[i]] = i;
        if(d[sum - a[i]]) return cout << d[sum - a[i]] - 1 << " " << i - 1, 0;
    }
}
