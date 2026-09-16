// Best solution: use ASCII comparison for best performance

class Solution {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;

        while (l < r) {
            char left = s.charAt(l);
            char right = s.charAt(r);

            if (!isAlphaNumeric(left)) {
                l++;
                continue;
            }

            if (!isAlphaNumeric(right)) {
                r--;
                continue;
            }

            // Convert uppercase -> lowercase
            if (left >= 'A' && left <= 'Z')
                left += 32;

            if (right >= 'A' && right <= 'Z')
                right += 32;

            if (left != right)
                return false;

            l++;
            r--;
        }

        return true;
    }

    private boolean isAlphaNumeric(char c) {
        return (c >= 'a' && c <= 'z') ||
               (c >= 'A' && c <= 'Z') ||
               (c >= '0' && c <= '9');
    }
}

public class BestSolution {
    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "A man, a plan, a canal: Panama";
        System.out.println(s.isPalindrome(str));
    }
}