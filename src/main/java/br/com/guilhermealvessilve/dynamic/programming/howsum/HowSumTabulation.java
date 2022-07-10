package br.com.guilhermealvessilve.dynamic.programming.howsum;

import java.util.List;
import java.util.stream.Stream;

public class HowSumTabulation {

    public static void main(String[] args) {
        System.out.println("howSum(7, [2, 3]): " + howSum(7, List.of(2L, 3L))); // [3, 2, 2]
        System.out.println("howSum(7, [5, 3, 4, 7]): " + howSum(7, List.of(5L, 3L, 4L, 7L))); // [4, 3]
        System.out.println("howSum(7, [2, 4]): " + howSum(7, List.of(2L, 4L))); // null
        System.out.println("howSum(8, [2, 3, 5]): " + howSum(8, List.of(2L, 3L, 5L))); // [2, 2, 2, 2]
        System.out.println("howSum(300, [7, 14]): " + howSum(300, List.of(7L, 14L))); // null
    }

    @SuppressWarnings("unchecked")
    public static List<Long> howSum(int targetSum, List<Long> numbers) {
        List<Long>[] table = new List[targetSum + 1];
        table[0] = List.of();
        for (int i = 0; i < table.length; i++) {
            if (null == table[i]) continue;
            for (var number : numbers) {
                add(table, i, (int) (i + number), number);
            }
        }

        return table[targetSum];
    }

    private static void add(List<Long>[] table, int i, int next, long value) {
        if (table.length <= next) return;
        table[next] = Stream.concat(table[i].stream(), Stream.of(value))
                .toList();
    }
}
