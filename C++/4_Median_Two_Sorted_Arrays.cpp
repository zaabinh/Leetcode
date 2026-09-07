#include<bits/stdc++.h>
using namespace std;

// arrays merge method
//class Solution {
//public:
//    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
//        int i = 0, j = 0;
//        int n = nums1.size(), m = nums2.size();
//        vector<int> merged;
//        do
//        {
//            if(j == m) {merged.push_back(nums1[i++]); continue;}
//            if(i == n) {merged.push_back(nums2[j++]); continue;}
//            int num;
//            if(nums1[i] > nums2[j]) num = nums2[j++]; else num = nums1[i++];
//            merged.push_back(num);
//        } while(i + j < (n + m) / 2 + 1);
//        double ans = ((n + m) % 2 == 0) ? (merged[(n + m) / 2] + merged[(n + m) / 2 - 1]) / 2.0 : merged[(n + m) / 2];
//        return ans;
//    }
//};

// two pointer method
//class Solution {
//public:
//    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
//        int i = 0, j = 0, med1, med2;
//        int n = nums1.size(), m = nums2.size();
//        do
//        {
//            if(j == m) {med2 = med1; med1 = nums1[i++]; continue;}
//            if(i == n) {med2 = med1; med1 = nums2[j++]; continue;}
//            int num;
//            if(nums1[i] > nums2[j]) med2 = med1, med1 = nums2[j++]; else med2 = med1, med1 = nums1[i++];
//        } while(i + j < (n + m) / 2 + 1);
//        if((n + m) % 2 == 1) return med1;
//        return (med1 + med2) / 2.0;
//    }
//};

//binary search method
class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2){
        const int lim = 1e6 + 8;
        int n = nums1.size(), m = nums2.size();
        if(n == 1 && m == 0) return nums1[0];
        if(n == 0 && m == 1) return nums2[0];
        int l = -lim, r = lim;
        while(l <= r)
        {
            int mid = (l + r) / 2;
            int i = upper_bound(nums1.begin(), nums1.end(), mid) - nums1.begin(),
                j = upper_bound(nums2.begin(), nums2.end(), mid) - nums2.begin();
            int cnt1 = n - i,
                cnt2 = m - j;
            //cout << mid << " " << cnt1 << " " << cnt2 << " " << (n + m) / 2 << endl;
            if(cnt1 + cnt2 == ((n + m) / 2))
            {
                int num1 = nums1[i - 1], num2 = nums2[j - 1];
                if((n + m) % 2 == 1) return max(num1, num2);
                else return (num1 + num2) / 2.0;
            }
            if(cnt1 + cnt2 > ((n + m) / 2)) l = mid + 1;
            else r = mid - 1;
        }
        return 0;
    }
};

int main()
{
    int n, m;
    cin >> n >> m;
    vector<int> a(n), b(m);
    for(int i = 0; i < n; i++) cin >> a[i];
    for(int i = 0; i < m; i++) cin >> b[i];
    Solution Solve;
    double ans = Solve.findMedianSortedArrays(a, b);
    cout << ans;
}
