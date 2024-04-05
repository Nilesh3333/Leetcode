/*Time Complexity: O(N) Space Complexity: O(N)
Time Complexity:
Creating numSet and adding elements: This takes O(N) time in the worst case, as it iterates through all elements in nums1 and adds them to the HashSet (assuming no duplicates in nums1).
Iterating through nums2 and handling differences: This also takes O(N) time in the worst case. For each element in nums2:
    contains on the HashSet takes on average constant time (O(1)).
    Removal from the HashSet and adding to difference1 also take constant time on average.
Constructing output: Converting the remaining elements in numSet to a list (difference2) takes linear time (O(N)) in the worst case, depending on the implementation of ArrayList (copying elements).

Space Complexity:
numSet: This HashSet can store up to N unique elements from nums1 in the worst case, contributing O(N) space complexity.
difference1 and difference2: These lists can hold up to N elements each in the worst case (all elements from nums2 or all remaining elements from nums1), contributing a total of O(N) space.

********************************************************************************************
Arrays.stream(nums1).distinct().boxed().collect(Collectors.toCollection(ArrayList::new));
Arrays.stream(nums2).distinct().boxed().collect(Collectors.toList());
*We call the boxed() method to convert the primitive int stream to a stream of Integer objects.
* Collectors.toCollection(ArrayList::new) specifies that the collected elements should be placed into a new ArrayList.
The ArrayList::new part is a method reference that refers to the constructor of the ArrayList class.
It's equivalent to providing a lambda expression ( ) -> new ArrayList<>(), which creates a new instance of ArrayList.
* The main difference between them is that Collectors.toList() provides a convenient way to collect elements into a List
without specifying the concrete implementation, while Collectors.toCollection(ArrayList::new) allows you to explicitly
choose the implementation (in this case, an ArrayList).
* */
import java.util.*;
public class findDifference2215 {
    public static void main(String[] args) {
    int[] num1 = new int[]{1,2,3};
    int[] num2 = new int[]{2,4,6};
    List<List<Integer>> ans = findDifference(num1,num2);
        System.out.println(ans);
    }
    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        // Use a hash set for efficient lookups (average O(1) time)
        Set<Integer> numSet1 = new HashSet<>();
        for (int num : nums1)
            numSet1.add(num);

        Set<Integer> numSet2 = new HashSet<>();
        for (int num : nums2)
            numSet2.add(num);

        for (int num : nums2) {
            if (numSet1.contains(num)){
                numSet1.remove(num);  // Remove common elements
                numSet2.remove(num);
            }
        }
        // Difference2 is simply the remaining elements in numSet (unique to nums1)
        List<Integer> difference1 = new ArrayList<>(numSet1);
        List<Integer> difference2 = new ArrayList<>(numSet2);
        return Arrays.asList(difference1, difference2);
    }
}
/*
Time Complexity : O(n*m), Space - O(n+m)
Nested loop: The core operation involves iterating through copyOfList1 (M elements) and for each element,
potentially iterating through copyOfList2 (N elements) in the worst case (when checking for containment and performing removal).
This nested loop structure contributes M * N to the time complexity.
Other factors: While creating the lists and copies, and other operations might take additional time, their contribution is considered constant compared to the dominant factor of the nested loop.
Therefore, the overall time complexity is dominated by the possibility of M * N checks in the worst case, making it O(M * N).

* public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<Integer> list1 = Arrays.stream(nums1).distinct().boxed().collect(Collectors.toList());
        List<Integer> list2 = Arrays.stream(nums2).distinct().boxed().collect(Collectors.toList());

        List<Integer> copyOfList1 = new ArrayList<>(list1);
        List<Integer> copyOfList2 = new ArrayList<>(list2);

        for (Integer i : copyOfList1) {
            if (copyOfList2.contains(i)) { //The time complexity of the contains method in an ArrayList is O(n)
                list2.remove(i);
                list1.remove(i);
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(list1);
        ans.add(list2);
        return ans;

    }
* */