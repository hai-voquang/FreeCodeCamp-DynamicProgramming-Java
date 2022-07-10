package br.com.guilhermealvessilve.dynamic.programming.allconstruct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class AllConstructMemoizedRecursive {

    public static void main(String[] args) {
        System.out.println("allConstruct(purple, [purp, p, ur, le, purpl]): " + allConstruct("purple", List.of("purp", "p", "ur", "le", "purpl"))); // [[purp, le], [p, ur, p, le]]
        System.out.println("allConstruct(abcdef, [ab, abc, cd, def, abcd]): " + allConstruct("abcdef", List.of("ab", "abc", "cd", "def", "abcd"))); // [[abc, def]]
        System.out.println("allConstruct(skateboard, [bo, rd, ate, t, ska, sk, boar]): " + allConstruct("skateboard", List.of("bo", "rd", "ate", "t", "ska", "sk", "boar")));  // []
        System.out.println("allConstruct(enterapotentpot, [a, p, ent, enter, ot, o, t]): " + allConstruct("enterapotentpot", List.of("a", "p", "ent", "enter", "ot", "o", "t")));
        // [[enter, a, p, ot, ent, p, ot], [enter, a, p, ot, ent, p, o, t], [enter, a, p, o, t, ent, p, ot], [enter, a, p, o, t, ent, p, o, t]]
        System.out.println("allConstruct(eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef, [e, ee, eee, eeee, eeeee, eeeeee]): " + allConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", List.of(
                "e",
                "ee",
                "eee",
                "eeee",
                "eeeee",
                "eeeeee"
        )));
        // []
    }

    public static List<List<String>> allConstruct(String target, List<String> wordBank) {
        var memo = new HashMap<String, List<List<String>>>();
        return allConstruct(target, wordBank, memo);
    }

    public static List<List<String>> allConstruct(String target, List<String> wordBank, Map<String, List<List<String>>> memo) {
        if (memo.containsKey(target)) return memo.get(target);
        if (target.isEmpty()) return multiList();

        var result = new ArrayList<List<String>>();
        for (var word : wordBank) {
            if (target.startsWith(word)) {
                var suffixWays = allConstruct(target.substring(word.length()), wordBank, memo);
                var targetWays = suffixWays.stream()
                        .map(subList -> Stream.concat(Stream.of(word), subList.stream()).toList())
                        .toList();
                result.addAll(targetWays);
            }
        }

        memo.put(target, result);
        return result;
    }

    private static List<List<String>> multiList() {
        var list = new ArrayList<List<String>>();
        list.add(new ArrayList<>());
        return list;
    }
}
