package br.com.guilhermealvessilve.dynamic.programming.canconstruct;

import java.util.List;

public class CanConstructRecursive {

    public static void main(String[] args) {
        System.out.println("canConstruct(abcdef, [ab, abc, cd, def, abcd]): " + canConstruct("abcdef", List.of("ab", "abc", "cd", "def", "abcd"))); // true
        System.out.println("canConstruct(skateboard, [bo, rd, ate, t, ska, sk, boar]): " + canConstruct("skateboard", List.of("bo", "rd", "ate", "t", "ska", "sk", "boar")));  // false
        System.out.println("canConstruct(enterapotentpot, [a, p, ent, enter, ot, o, t]): " + canConstruct("enterapotentpot", List.of("a", "p", "ent", "enter", "ot", "o", "t"))); // true
    }

    public static boolean canConstruct(String target, List<String> wordBank) {
        if (target.isEmpty()) return true;

        return wordBank.stream()
                .anyMatch(word -> target.startsWith(word) && canConstruct(target.substring(word.length()), wordBank));
    }
}
