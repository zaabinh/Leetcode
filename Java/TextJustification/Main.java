import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int i = 0;
        List<String> justifiedWords = new ArrayList<>();
        while(i < words.length) {
            int curWidth = 0;
            List<String> curWords = new ArrayList<>();
            while(i < words.length && curWidth + words[i].length() + curWords.size() <= maxWidth) {
                // System.out.print(words[i] + " ");
                curWidth += words[i].length();
                curWords.add(words[i++]);
            }
            int spaces = maxWidth - curWidth;
            int wordsCount = Math.max((curWords.size() - 1), 1);
            String line = "";
            for(int j = 0; j < curWords.size() - 1; j++) {
                String w = curWords.get(j);
                int space = 1;
                if(i < words.length) {
                    space = spaces / wordsCount;
                    if(j + 1 <= (spaces % wordsCount)) space++;
                }
                line = line + w + " ".repeat(space);
            }
            line = line + curWords.get(curWords.size() - 1);
            if(i >= words.length || curWords.size() == 1) line = line + " ".repeat(maxWidth - line.length());
            justifiedWords.add(line);
            // System.out.println(line + " " + line.length());
            // System.out.println(curWidth + " " + spaces);

        }
        return justifiedWords;
    }
}


public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] words = {"ask","not","what","your","country","can","do","for","you","ask","what","you","can","do","for","your","country"};
        int maxWidth = 16;
        List<String> ans = s.fullJustify(words, maxWidth);
    }
}