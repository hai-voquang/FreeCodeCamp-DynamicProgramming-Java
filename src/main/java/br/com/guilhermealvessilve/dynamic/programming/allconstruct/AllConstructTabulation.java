package br.com.guilhermealvessilve.dynamic.programming.allconstruct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class AllConstructTabulation {

    public static void main(String[] args) {
        System.out.println("allConstruct(purple, [purp, p, ur, le, purpl]): " + allConstruct("purple", List.of("purp", "p", "ur", "le", "purpl"))); // [[purp, le], [p, ur, p, le]]
        System.out.println("allConstruct(abcdef, [ab, abc, cd, def, abcd]): " + allConstruct("abcdef", List.of("ab", "abc", "cd", "def", "abcd"))); // [[abc, def]]
        System.out.println("allConstruct(skateboard, [bo, rd, ate, t, ska, sk, boar]): " + allConstruct("skateboard", List.of("bo", "rd", "ate", "t", "ska", "sk", "boar")));  // []
        System.out.println("allConstruct(enterapotentpot, [a, p, ent, enter, ot, o, t]): " + allConstruct("enterapotentpot", List.of("a", "p", "ent", "enter", "ot", "o", "t")));
        // [[enter, a, p, ot, ent, p, ot], [enter, a, p, ot, ent, p, o, t], [enter, a, p, o, t, ent, p, ot], [enter, a, p, o, t, ent, p, o, t]]
    }

    @SuppressWarnings("unchecked")
    public static List<List<String>> allConstruct(String target, List<String> wordBank) {
        List<List<String>>[] table = new List[target.length() + 1];
        Arrays.setAll(table, i -> table[i] = new ArrayList<>());
        table[0].add(new ArrayList<>());

        for (int i = 0; i < table.length; i++) {
            for (var word : wordBank) {
                int endIndex = i + word.length();
                if (endIndex <= target.length() && target.substring(i, endIndex).equals(word)) {
                    var targetWays = table[i].stream()
                                    .map(subList -> Stream.concat(subList.stream(), Stream.of(word)).toList())
                                    .toList();
                    table[endIndex].addAll(targetWays);
                }
            }
        }

        return table[target.length()];
    }
}
