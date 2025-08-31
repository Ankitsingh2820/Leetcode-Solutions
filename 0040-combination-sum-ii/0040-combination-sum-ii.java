import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // sort to handle duplicates
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int remain, int start,
                           List<Integer> path, List<List<Integer>> result) {
        if (remain == 0) {
            result.add(new ArrayList<>(path)); // found a valid combination
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // Skip duplicates (important!)
            if (i > start && candidates[i] == candidates[i - 1]) continue;

            if (candidates[i] > remain) break; // pruning

            path.add(candidates[i]);
            backtrack(candidates, remain - candidates[i], i + 1, path, result);
            path.remove(path.size() - 1); // backtrack
        }
    }
}
