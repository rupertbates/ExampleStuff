import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class LiarLiar {
    public static void main(String[] args) throws FileNotFoundException {
//        HashMap<String, String[]> data = new HashMap<String, String[]>();
//        data.put("stephen", new String[]{"tommaso"});
//        data.put("tommaso", new String[]{"galileo"});
//        data.put("isaac", new String[]{"tommaso"});
//        data.put("galileo", new String[]{"tommaso"});
//        data.put("george", new String[]{"isaac", "stephen"});
        Set<String> liars = new HashSet<String>(5);
        Set<String> truth = new HashSet<String>(5);
        Scanner scanner = new Scanner(new BufferedReader(new FileReader("/home/rbates/Projects/Examples/src/LiarLiarTestData2.txt")));
        int numberOfMembers = scanner.nextInt();
        for (int i = 0; i < numberOfMembers; i++) {
            String accuser = scanner.next("\\w+");
            List<String> accused = getAccused(scanner);
            if (liars.contains(accuser)) {
                truth.addAll(accused);
            } else if (truth.contains(accuser)) {
                liars.addAll(accused);
            } else if (alreadyCategorised(liars, accused)) {
                //some of the accused are already categorised as liars
                liars.addAll(accused);
                //so the accuser is telling the truth
                truth.add(accuser);
            } else if (alreadyCategorised(truth, accused)) {
                //some of the accused are already categorised as truthful
                truth.addAll(accused);
                //so the accuser is lying
                liars.add(accuser);
            } else {
                //assume that the current user is telling the truth
                truth.add(accuser);
                liars.addAll(accused);
            }
        }


//        for (Map.Entry<String, String[]> entry : data.entrySet()) {
//            if (liars.contains(entry.getKey())) {
//                Collections.addAll(truth, entry.getValue());
//            } else if (truth.contains(entry.getKey())) {
//                Collections.addAll(liars, entry.getValue());
//            } else {
//                //assume that the current user is telling the truth
//                truth.add(entry.getKey());
//                Collections.addAll(liars, entry.getValue());
//            }
//        }
        System.out.println(Math.max(liars.size(), truth.size()) + " " + Math.min(liars.size(), truth.size()));

    }
    private static boolean alreadyCategorised(Set<String> category, List<String> accused){
        for (String a : accused){
            if(category.contains(a))
                return true;
        }
        return false;
    }

    private static List<String> getAccused(Scanner scanner) {

        int numberOfAccusations = scanner.nextInt();
        ArrayList<String> accused = new ArrayList<String>(numberOfAccusations);
        for (int j = 0; j < numberOfAccusations; j++) {
            accused.add(scanner.next("\\w+"));
        }
        return accused;
    }

}

