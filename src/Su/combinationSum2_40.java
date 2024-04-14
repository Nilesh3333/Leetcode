/*
1.https://www.youtube.com/watch?v=OyZFFqQtu98&list=PLgUwDviBIf0rQ6cnlaHRMuOp4H_D-7hwP&index=3&ab_channel=takeUforward1
2.https://www.youtube.com/watch?v=G1fRTGRxXU8&ab_channel=takeUforward
CombinationSum39
*/
package Su;

import java.util.*;

public class combinationSum2_40 {
    public static void main(String[] args) {
        combinationSum2_40 comb = new combinationSum2_40();
        int[] candidates ={10,1,2,7,6,1,5};
        int target =8;
        System.out.println(comb.combinationSum2(candidates,target));
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(0,candidates,target,ans,new ArrayList<>());
        return ans;
    }

    private void findCombinations(int idx, int[] candidates, int target, List<List<Integer>> ans, ArrayList<Integer> combination) {
        if(target == 0){
                ans.add(new ArrayList<>(combination));
            return;
        }
        for(int i=idx;i<candidates.length;i++){
            if(i>idx && candidates[i] == candidates[i-1]) continue;
            if(candidates[i] > target) break;

            combination.add(candidates[i]);
            findCombinations(i+1,candidates,target - candidates[i],ans,combination);
            combination.removeLast();
        }
    }
}



/*
public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        HashSet<List<Integer>> ans = new HashSet<>();
        Arrays.sort(candidates);
        findCombinations(0,candidates,target,ans,new ArrayList<>());
        return new ArrayList<>(ans);
    }

    private void findCombinations(int i, int[] candidates, int target, HashSet<List<Integer>> ans, ArrayList<Integer> combination) {
        if( i == candidates.length){
            if(target == 0)
                ans.add(new ArrayList<>(combination));
            return;
        }
        if(candidates[i]<= target){
            combination.add(candidates[i]);
            findCombinations(i+1,candidates,target - candidates[i],ans,combination);
            combination.removeLast();
        }
        findCombinations(i+1,candidates,target ,ans,combination);
    }
*/