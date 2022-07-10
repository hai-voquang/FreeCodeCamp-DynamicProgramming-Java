package br.com.guilhermealvessilve.dynamic.programming.bestsum;

import java.util.List;
import java.util.stream.Stream;

public class BestSumTabulation {

    public static void main(String[] args) {
        System.out.println("bestSum(7, [5, 3, 4, 7]): " + bestSum(7, List.of(5L, 3L, 4L, 7L))); // [7]
        System.out.println("bestSum(8, [2, 3, 5]): " + bestSum(8, List.of(2L, 3L, 5L))); // [3, 5]
        System.out.println("bestSum(8, [2, 3, 5]): " + bestSum(8, List.of(1L, 4L, 5L))); // [4, 4]
        System.out.println("bestSum(100, [1, 2, 5, 25]): " + bestSum(100, List.of(1L, 2L, 5L, 25L))); // [25, 25, 25, 25]
    }

    @SuppressWarnings("unchecked")
    public static List<Long> bestSum(int targetSum, List<Long> numbers) {
        List<Long>[] table = new List[targetSum + 1];
        table[0] = List.of();

        for (int i = 0; i < table.length; i++) {
            if (null == table[i]) continue;
            for (var number : numbers) {
                setBest(table, i, (int) (i + number), number);
            }
        }

        return table[targetSum];
    }

    private static void setBest(List<Long>[] table, int i, int next, long number) {
        if (table.length <= next) return;
        var combination = Stream.concat(table[i].stream(), Stream.of(number)).toList();
        if (null == table[next] || table[next].size() > combination.size()) {
            table[next] = combination;
        }
    }
}
