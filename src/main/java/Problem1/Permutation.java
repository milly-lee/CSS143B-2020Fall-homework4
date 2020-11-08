package Problem1;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    // Used website to figure out recursive helper strategy
    // https://stackoverflow.com/questions/24460480/permutation-of-an-arraylist-of-numbers-using-recursion#24460752

    public static List<List<Integer>> permute(int[] nums) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        return permuteHelp(list);
    }

    // Helper function
    public static List<List<Integer>> permuteHelp(List<Integer> list) {

        // Base case
        if (list.size() == 0) {
            List<List<Integer>> list2 = new ArrayList<>();
            list2.add(new ArrayList<>());
            return list2;
        }

        List<List<Integer>> list2 = new ArrayList<>();
        int element = list.remove(0);

        // Recursive function
        List<List<Integer>> recursiveReturn = permuteHelp(list);

        // Sum everything up
        for (List<Integer> li : recursiveReturn) {
            for (int index = 0; index <= li.size(); index++) {
                List<Integer> temp = new ArrayList<>();
                temp.addAll(li);
                temp.add(index, element);
                list2.add(temp);
            }

        }
        return list2;
    }

}