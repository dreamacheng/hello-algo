package exm.algo.string;

import java.util.*;
import java.util.stream.Collectors;

public class MostCommonWord {

    public static void main(String[] args) {
        String input = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = new String[]{"hit"};
        System.out.println(mostCommonWord(input, banned));
    }

    public static String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedList = Arrays.stream(banned).map(String::toLowerCase).collect(Collectors.toSet());
        String[] split = paragraph.split("[!?',;. ]+");
        Map<String, Integer> rest = new HashMap<>();
        for (String s : split) {
            if (bannedList.contains(s.toLowerCase())) {
                continue;
            }
            rest.merge(s.toLowerCase(), 1, Integer::sum);
        }
        return Objects.requireNonNull(rest.entrySet().stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .orElse(null)).getKey();
    }
}
