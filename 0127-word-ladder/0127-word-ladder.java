import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (word.equals(endWord)) return level;

                char[] arr = word.toCharArray();
                for (int pos = 0; pos < arr.length; pos++) {
                    char original = arr[pos];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original) continue;
                        arr[pos] = c;
                        String newWord = new String(arr);
                        if (dict.contains(newWord)) {
                            queue.add(newWord);
                            dict.remove(newWord); // Mark visited
                        }
                    }
                    arr[pos] = original;
                }
            }
            level++;
        }
        return 0;
    }
}
