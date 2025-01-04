import java.util.*;

public class RepeatedDNA {
    public static List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();

        for (int i = 0; i + 9 < s.length(); i++) {
            String sequence = s.substring(i, i + 10);
            if (!seen.add(sequence)) {
                repeated.add(sequence);
            }
        }

        return new ArrayList<>(repeated);
    }

    public static void main(String[] args) {
        // Test cases
        String s1 = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(findRepeatedDnaSequences(s1)); // Expected: [AAAAACCCCC, CCCCCAAAAA]

        String s2 = "AAAAAAAAAAAAA";
        System.out.println(findRepeatedDnaSequences(s2)); // Expected: [AAAAAAAAAA]

        String s3 = "AAAAA";
        System.out.println(findRepeatedDnaSequences(s3)); // Expected: []
    }
}