package lessons_from_class.my_power_set;


import java.util.*;

/**
 * Used solution from:
 * https://www.baeldung.com/java-power-set-of-a-set
 *
 */
public class RecPowerSet<T> {
  private static<T> Set<T> oneRemoved(Set<T> set, T element) {
      Set<T> newSet = new HashSet<>();
      for (T s : set) {
          if (!s.equals(element)) {
              newSet.add(s);
          }
      }
      return newSet;
  }

  private static<T> Set<Set<T>> distributeIn(Set<Set<T>> powerSetWithoutElement, T element) {
      Set<Set<T>> powerSetWithElement = new HashSet<>();
      for (Set<T> set: powerSetWithoutElement) {
          Set<T> subsetWithElement = new HashSet<>(set);
          subsetWithElement.add(element);
          powerSetWithElement.add(subsetWithElement);
      }
      return powerSetWithElement;
  }

  private static<T> Set<Set<T>> union (Set<Set<T>> set1, Set<Set<T>> set2) {
      Set<Set<T>> powerSet = new HashSet<>();
      powerSet.addAll(set1);
      powerSet.addAll(set2);
      return powerSet;
  }
  public static<T> Set<Set<T>> recursivePowerSet(Set<T> set) {
        if (set.isEmpty()) {
            Set<Set<T>> ret = new HashSet<>();
            ret.add(set);
            return ret;
        }

        T element = set.iterator().next();
        Set<T> subSetWithoutElement = oneRemoved(set, element);
        Set<Set<T>> powerSetSubSetWithoutElement = recursivePowerSet(subSetWithoutElement);
        Set<Set<T>> powerSetSubSetWithElement = distributeIn(powerSetSubSetWithoutElement, element);

       return union(powerSetSubSetWithElement, powerSetSubSetWithoutElement);
    }

    public static <T>  List<List<T>> findSubsets(T[] nums) {
        List<List<T>> subsets = new ArrayList<>();
        // start by adding the empty subset
        subsets.add(new ArrayList<>());
        for (T currentNumber : nums) {
            // we will take all existing subsets and insert the current number in them to create new subsets
            int n = subsets.size();
            for (int i = 0; i < n; i++) {
                // create a new subset from the existing subset and insert the current element to it
                List<T> set = new ArrayList<>(subsets.get(i));
                set.add(currentNumber);
                subsets.add(set);
            }
        }
        return subsets;
    }

    public static void main(String[] args) {
        System.out.println(RecPowerSet.findSubsets(new String[]{"Test", "Mirror", "IceCream"}));
        System.out.println(RecPowerSet.recursivePowerSet(Set.of("Test", "Mirror", "IceCream")));
        System.out.println(RecPowerSet.findSubsets(new Integer[]{1,2,3,4}));
    }
}
