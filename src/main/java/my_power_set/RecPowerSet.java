package my_power_set;


import java.util.HashSet;
import java.util.Set;

/**
 * Used solution from:
 * https://www.baeldung.com/java-power-set-of-a-set
 *
 */
public class RecPowerSet<T> {
  private Set<T> oneRemoved(Set<T> set, T element) {
      Set<T> newSet = new HashSet<>();
      for (T s : set) {
          if (!s.equals(element)) {
              newSet.add(s);
          }
      }
      return newSet;
  }

  private Set<Set<T>> distributeIn(Set<Set<T>> powerSetWithoutElement, T element) {
      Set<Set<T>> powerSetWithElement = new HashSet<>();
      for (Set<T> set: powerSetWithoutElement) {
          Set<T> subsetWithElement = new HashSet<>(set);
          subsetWithElement.add(element);
          powerSetWithElement.add(subsetWithElement);
      }
      return powerSetWithElement;
  }

  private Set<Set<T>> union (Set<Set<T>> set1, Set<Set<T>> set2) {
      Set<Set<T>> powerSet = new HashSet<>();
      powerSet.addAll(set1);
      powerSet.addAll(set2);
      return powerSet;
  }
  public Set<Set<T>> recursivePowerSet(Set<T> set) {
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

    public static void main(String[] args) {
        RecPowerSet<String> ps = new RecPowerSet<>();
        System.out.println(ps.recursivePowerSet(Set.of("Test", "Book", "Apple")));
    }
}
