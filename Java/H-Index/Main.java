class Solution {
    public int hIndex(int[] citations) {
        int l = 0, r = 1001, res = 0;
        while(l <= r) {
            int mid = (l + r) / 2;
            int cnt = 0;
            boolean ok = false;
            for(int c : citations) {
                if(c >= mid) cnt++;
                if(cnt >= mid) {
                    ok = true;
                    break;
                }
            }
            //System.out.println(mid + " " + cnt);
            if(ok) {
                res = mid;
                l = mid + 1;
            }
            else r = mid - 1;
        }
        return res;
    }
}

public class Main{
    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        Solution solution = new Solution();
        System.out.println(solution.hIndex(citations));
    }
}
