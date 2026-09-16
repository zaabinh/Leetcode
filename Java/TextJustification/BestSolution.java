import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int n = words.length;
        int i = 0;

        while (i < n) {
            int start = i;
            int wordsLength = 0;

            // Find all words that fit in this line
            while (i < n &&
                   wordsLength + words[i].length() + (i - start) <= maxWidth) {
                wordsLength += words[i].length();
                i++;
            }

            int count = i - start;
            char[] line = new char[maxWidth];
            int pos = 0;

            // Last line or only one word -> left justified
            if (i == n || count == 1) {
                for (int j = start; j < i; j++) {
                    String word = words[j];
                    
                    // Add a word to line
                    for (int k = 0; k < word.length(); k++) {
                        line[pos++] = word.charAt(k);
                    }
                    
                    // Add a single space
                    if (pos < maxWidth) {
                        line[pos++] = ' ';
                    }
                }

                // Add remaining spaces
                while (pos < maxWidth) {
                    line[pos++] = ' ';
                }
            }

            // Fully justified
            else {
                int totalSpaces = maxWidth - wordsLength;
                int gaps = count - 1;

                // Initially, there is (totalSpaces / gaps) space between each pair of characters
                // So, the remaining spaces will be (totalSpaces % gaps)
                // To distribute spaces evenly and follow problem's description that 
                // "the empty slots on the left will be assigned more spaces than the slots on the right."
                // We'll add 1 extra space for the first (extra) words of the word list
                int spaces = totalSpaces / gaps;
                int extra = totalSpaces % gaps;

                for (int j = start; j < i; j++) {
                    String word = words[j];

                    // Add a word
                    for (int k = 0; k < word.length(); k++) {
                        line[pos++] = word.charAt(k);
                    }

                    // If not processing the last word, add space
                    if (j < i - 1) {
                        int spaceCount = spaces;

                        // Need extra space
                        if (j - start < extra) {
                            spaceCount++;
                        }

                        // Add initial spaces
                        while (spaceCount-- > 0) {
                            line[pos++] = ' ';
                        }
                    }
                }
            }

            // Append new line
            ans.add(new String(line));
        }

        return ans;
    }
}


public class BestSolution {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] words = {"ask","not","what","your","country","can","do","for","you","ask","what","you","can","do","for","your","country"};
        int maxWidth = 16;
        List<String> ans = s.fullJustify(words, maxWidth);
    }
}