import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Combinations {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(1);
        set.add(2);
        //set.add(3);
        //set.add(4);
        Set<Set<Integer>> solutions = new HashSet<Set<Integer>>();
        Set<Set<Integer>> ps = getPowerSet(set);
        for (Set<Integer> s : ps) {
            if (correctSum(s, 2))
                solutions.add(s);
        }


    }

    public static Set<Set<Integer>> getPowerSet(Set<Integer> originalSet) {
        Set<Set<Integer>> sets = new HashSet<Set<Integer>>();
        if (originalSet.isEmpty()) {
            sets.add(new HashSet<Integer>());
            return sets;
        }
        List<Integer> list = new ArrayList<Integer>(originalSet);
        Integer head = list.get(0);
        Set<Integer> rest = new HashSet<Integer>(list.subList(1, list.size()));
        for (Set<Integer> set : getPowerSet(rest)) {
            Set<Integer> newSet = new HashSet<Integer>();
            newSet.add(head);
            newSet.addAll(set);
            sets.add(newSet);
            sets.add(set);
        }
        return sets;
    }

    private static boolean correctSum(Set<Integer> newSet, int amount) {
        int sum = 0;
        for (Integer i : newSet) {
            sum += i;
            if (sum > amount)
                return false;
        }
        return sum == amount;
    }


    public static long getCombos(int n, int sum) {
        // tab[i][j] is how many combinations of (i+1) vars add up to j
        long[][] tab = new long[n][sum + 1];
        // # of combos of 1 var for any sum is 1
        for (int j = 0; j < tab[0].length; ++j) {
            tab[0][j] = 1;
        }
        for (int i = 1; i < tab.length; ++i) {
            for (int j = 0; j < tab[i].length; ++j) {
                // # combos of (i+1) vars adding up to j is the sum of the #
                // of combos of i vars adding up to k, for all 0 <= k <= j
                // (choosing i vars forces the choice of the (i+1)st).
                tab[i][j] = 0;
                for (int k = 0; k <= j; ++k) {
                    tab[i][j] += tab[i - 1][k];
                }
            }
        }
        return tab[n - 1][sum];
    }

}
