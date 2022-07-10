package br.com.guilhermealvessilve.dynamic.programming.countconstruct;

import java.util.List;

public class CountConstructRecursive {

    public static void main(String[] args) {
        System.out.println("countConstruct(purple, [purp, p, ur, le, purpl]): " + countConstruct("purple", List.of("purp", "p", "ur", "le", "purpl"))); // 2
        System.out.println("countConstruct(abcdef, [ab, abc, cd, def, abcd]): " + countConstruct("abcdef", List.of("ab", "abc", "cd", "def", "abcd"))); // 1
        System.out.println("countConstruct(skateboard, [bo, rd, ate, t, ska, sk, boar]): " + countConstruct("skateboard", List.of("bo", "rd", "ate", "t", "ska", "sk", "boar")));  // 0
        System.out.println("countConstruct(enterapotentpot, [a, p, ent, enter, ot, o, t]): " + countConstruct("enterapotentpot", List.of("a", "p", "ent", "enter", "ot", "o", "t"))); // 4
    }

    public static long countConstruct(String target, List<String> wordBank) {
        if (target.isEmpty()) return 1;

        return wordBank.stream()
                .mapToLong(word -> {
                    if (target.startsWith(word)) {
                        return countConstruct(target.substring(word.length()), wordBank);
                    }

                    return 0;
                })
                .sum();
    }
}
