package br.com.guilhermealvessilve.dynamic.programming.countconstruct;

import java.util.List;

public class CountConstructTabulation {

    public static void main(String[] args) {
        System.out.println("countConstruct(purple, [purp, p, ur, le, purpl]): " + countConstruct("purple", List.of("purp", "p", "ur", "le", "purpl"))); // 2
        System.out.println("countConstruct(abcdef, [ab, abc, cd, def, abcd]): " + countConstruct("abcdef", List.of("ab", "abc", "cd", "def", "abcd"))); // 1
        System.out.println("countConstruct(skateboard, [bo, rd, ate, t, ska, sk, boar]): " + countConstruct("skateboard", List.of("bo", "rd", "ate", "t", "ska", "sk", "boar")));  // 0
        System.out.println("countConstruct(enterapotentpot, [a, p, ent, enter, ot, o, t]): " + countConstruct("enterapotentpot", List.of("a", "p", "ent", "enter", "ot", "o", "t"))); // 4
        System.out.println("countConstruct(eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef, [e, ee, eee, eeee, eeeee, eeeeee]): " + countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", List.of(
                "e",
                "ee",
                "eee",
                "eeee",
                "eeeee",
                "eeeeee"
        ))); // 0
    }

    public static long countConstruct(String target, List<String> wordBank) {
        var table = new long[target.length() + 1];
        table[0] = 1;

        for (int i = 0; i < table.length; i++) {
            for (var word : wordBank) {
                int endIndex = i + word.length();
                if (endIndex <= target.length() && target.substring(i, endIndex).equals(word)) {
                    table[endIndex] += table[i];
                }
            }
        }

        return table[target.length()];
    }
}
