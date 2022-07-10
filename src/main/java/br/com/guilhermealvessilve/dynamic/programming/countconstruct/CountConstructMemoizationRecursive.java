package br.com.guilhermealvessilve.dynamic.programming.countconstruct;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountConstructMemoizationRecursive {

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
        var memo = new HashMap<String, Long>();
        return countConstruct(target, wordBank, memo);
    }

    public static long countConstruct(String target, List<String> wordBank, Map<String, Long> memo) {
        if (memo.containsKey(target)) return memo.get(target);
        if (target.isEmpty()) return 1;

        long result = wordBank.stream()
                .mapToLong(word -> {
                    if (target.startsWith(word)) {
                        return countConstruct(target.substring(word.length()), wordBank, memo);
                    }

                    return 0;
                })
                .sum();

        memo.put(target, result);
        return result;
    }
}
