package educative.subsets;

import java.util.*;

public class Permutations {
    public static List<List<Integer>> findPermutations(int[] nums) {
      List<List<Integer>> result = new ArrayList<>();
      Queue<List<Integer>> permutations = new LinkedList<>();
      permutations.add(new ArrayList<>());
      for (int currentNum : nums) {
          int n = permutations.size();
          for (int i = 0; i < n; i++) {
              List<Integer> oldPermutations = permutations.poll();
              for (int j = 0; j <= Objects.requireNonNull(oldPermutations).size(); j++) {
                  List<Integer> newPermutations = new ArrayList<>(oldPermutations);
                  newPermutations.add(j, currentNum);
                  if (newPermutations.size() == nums.length)
                      result.add(newPermutations);
                  else
                      permutations.add(newPermutations);
              }
          }
      }
      return result;
    }


    public static void main(String[] args) {
        Permutations.findPermutations(new int[]{1,2,3,4}).forEach(System.out::println);
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(1, 2);
        System.out.println(list);
    }
}
