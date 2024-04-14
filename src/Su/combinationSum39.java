/*
https://www.youtube.com/watch?v=OyZFFqQtu98&list=PLgUwDviBIf0rQ6cnlaHRMuOp4H_D-7hwP&index=3&ab_channel=takeUforward
Time  - Exponential
*/

package Su;

import java.util.ArrayList;
import java.util.List;

public class combinationSum39 {

    public static void main(String[] args) {
        combinationSum39 sum = new combinationSum39();
        int[] candidates = {2,3,6,7};
        int target =7;
        System.out.println(sum.combinationSum(candidates,target));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(0,candidates,target,ans,new ArrayList<>());
        return ans;
    }

    // This recursive method explores possible combinations using backtracking
    public void findCombinations(int index, int[] candidates, int target, List<List<Integer>> ans, List<Integer> combination) {
        // Base case 1: If we have reached the end of the candidates array
        if (index == candidates.length) {
            if (target == 0) {                             //// If the current combination adds up to the target, add it to the final list
                ans.add(new ArrayList<>(combination));     // Create a copy of the current combination to avoid modifying the original list during backtracking
            }
            return;       // Backtrack since we've reached the end (no more elements to explore in the current path)
        }


        if (candidates[index] <= target) {

            combination.add(candidates[index]);     // Include the current candidate in the combination

            // Explore further combinations by recursively calling findCombinations:
            // 1. Try including the current candidate again (allowing duplicates in the combination)
            findCombinations(index, candidates, target - candidates[index], ans, combination);


            combination.removeLast();      // Backtrack: remove the current candidate from the combination
        }

        // Explore further combinations without the current candidate (considering only unique combinations)
        findCombinations(index + 1, candidates, target, ans, combination);
    }
}
