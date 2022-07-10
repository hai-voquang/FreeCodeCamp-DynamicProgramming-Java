package br.com.guilhermealvessilve.dynamic.programming.canconstruct;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CanConstructMemoizationRecursive {

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
        var memo = new HashMap<String, Boolean>();
        return canConstruct(target, wordBank, memo);
    }

    private static boolean canConstruct(String target, List<String> wordBank, Map<String, Boolean> memo) {
        if (memo.containsKey(target)) return memo.get(target);
        if (target.isEmpty()) return true;

        return wordBank.stream()
                .anyMatch(word -> {
                    var result = target.startsWith(word) && canConstruct(target.substring(word.length()), wordBank, memo);
                    memo.put(target, result);
                    return result;
                });
    }
}
