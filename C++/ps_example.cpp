#include<cstdio>

typedef long long LL;
#define MOD 1000000007LL
#define N 50000
int n; char s[N+2];
LL h[N+1], pow[N+1], rh[N+1];

inline int hash(int i, int j) {
    return (h[j] - h[i-1] * pow[j-i+1] + MOD * MOD) % MOD;
}

inline int rhash(int i, int j) {
    return (rh[n-i+1] - rh[n-j] * pow[j-i+1] + MOD * MOD) % MOD;
}

void init() {
    pow[0] = 1; h[0] = rh[0] = 0;
    for(int i = 1; i <= n; ++i) {
        h[i] = (h[i-1] * 95 + s[i] - 32) % MOD;
        rh[i] = (rh[i-1] * 95 + s[n-i+1] - 32) % MOD;
        pow[i] = pow[i-1] * 95 % MOD;
    }
}

bool checkLength(int len) {
    for(int i = 1; i + len - 1 <= n; ++i)
        if(hash(i, i + len - 1) == rhash(i, i + len - 1)) return 1;
    return 0;
}

int main() {
    scanf("%d%s", &n, s+1); init();
    int lo = 1, hi = n - (n % 2 == 0);
    while(lo < hi) {
        int mid = (lo+hi)/2; if(mid % 2 == 0) ++mid;
        if(checkLength(mid)) lo = mid; else hi = mid - 2;
    }
    int res = lo;
    lo = 0; hi = n - n % 2;
    while(lo < hi) {
        int mid = (lo+hi)/2; if(mid % 2) ++mid;
        if(checkLength(mid)) lo = mid; else hi = mid - 2;
    }
    if(lo > res) res = lo;
    printf("%d\n", res);
    return 0;
}
