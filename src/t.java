import java.util.*;

public class t {
    // Given a mapping of digits to array of characters, ie. "1"=>{}, "2"=>{"A","B","C"}, "3"=>{"D","E","F"} etc.
// Print out all the string permutations a given input of digits maps to
    static HashMap<String, List<String>> data = new HashMap();

    public static void main(String[] args) {
        phonestr("23");
    }

    public static void phonestr(String digits) {
        List<String> val1 = new ArrayList<String>();
        List<String> val2 = new ArrayList<String>();
        val1.add("A");
        val1.add("B");
        val1.add("C");
        data.put("2", val1);
        val2.add("D");
        val2.add("E");
        val2.add("F");
        data.put("3", val2);

        for (List<String> combination : getCombinations(digits)) {
            if (combination.size() == digits.length()) {
                for (String letter : combination) {
                    System.out.print(letter);
                }
                System.out.println();
            }
        }
    }

    public static List<List<String>> getCombinations(String digits) {
        List<List<String>> sets = new ArrayList<List<String>>();
        if (digits.length() == 0)
            return sets;
        String first = String.valueOf(digits.charAt(0));
        String rest = digits.substring(1);
        for (String s : data.get(first)) {
            List<String> newSet = new ArrayList<String>();
            newSet.add(s);
            sets.add(newSet);
            for (List<String> combination : getCombinations(rest)) {
                List<String> newSet2 = new ArrayList<String>();
                newSet2.addAll(combination);
                newSet2.add(0, s);
                sets.add(newSet2);
                sets.add(combination);
            }
        }
        return sets;
    }
}
