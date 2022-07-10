package br.com.guilhermealvessilve.dynamic.programming.canconstruct;

import java.util.List;

public class CanConstructTabulation {

    public static void main(String[] args) {
        System.out.println("canConstruct(abcdef, [ab, abc, cd, def, abcd]): " + canConstruct("abcdef", List.of("ab", "abc", "cd", "def", "abcd"))); // true
        System.out.println("canConstruct(skateboard, [bo, rd, ate, t, ska, sk, boar]): " + canConstruct("skateboard", List.of("bo", "rd", "ate", "t", "ska", "sk", "boar")));  // false
        System.out.println("canConstruct(enterapotentpot, [a, p, ent, enter, ot, o, t]): " + canConstruct("enterapotentpot", List.of("a", "p", "ent", "enter", "ot", "o", "t"))); // true
        System.out.println("canConstruct(eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef, [e, ee, eee, eeee, eeeee, eeeeee]): " + canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", List.of(
            "e",
            "ee",
            "eee",
            "eeee",
            "eeeee",
            "eeeeee"
        ))); // false
    }

    public static boolean canConstruct(String target, List<String> wordBank) {
        var table = new boolean[target.length() + 1];
        table[0] = true;

        for (int i = 0; i < table.length; i++) {
            if (!table[i]) continue;
            for (var word : wordBank) {
                int endIndex = i + word.length();
                if (endIndex <= target.length() && target.substring(i, endIndex).equals(word)) {
                    table[endIndex] = true;
                }
            }
        }

        return table[target.length()];
    }
}
