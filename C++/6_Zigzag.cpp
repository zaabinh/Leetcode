#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    string convert(string s, int numRows) {
        if(numRows == 1) return s;
        vector <string> ZZ(numRows + 2, "");
        string ans = "";
        int step = 1, Row = 1;
        for(int i = 0; i < s.size(); i++)
        {

            if(step == 1 && Row == numRows + 1) {step = -1; Row-=2;}
            if(step == -1 && Row == 0) {step = 1; Row+=2;}
            ZZ[Row] += s[i];
            Row += step;
        }
        for(int i = 1; i <= numRows; i++)
            ans += ZZ[i];
        return ans;
    }
};

int main()
{
    string s = "PAYPALISHIRING";
    int numRows = 3;
    Solution Solve;
    string Result = Solve.convert(s, numRows);
    cout << Result;
}
