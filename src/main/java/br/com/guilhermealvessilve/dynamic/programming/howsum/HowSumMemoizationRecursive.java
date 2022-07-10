package br.com.guilhermealvessilve.dynamic.programming.howsum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class HowSumMemoizationRecursive {

    public static void main(String[] args) {
        System.out.println("howSum(7, [2, 3]): " + howSum(7L, List.of(2L, 3L))); // [2, 2, 3]
        System.out.println("howSum(7, [5, 3, 4, 7]): " + howSum(7L, List.of(5L, 3L, 4L, 7L))); // [3, 4]
        System.out.println("howSum(7, [2, 4]): " + howSum(7L, List.of(2L, 4L))); // null
        System.out.println("howSum(8, [2, 3, 5]): " + howSum(8L, List.of(2L, 3L, 5L))); // [2, 2, 2, 2]
        System.out.println("howSum(300, [7, 14]): " + howSum(300L, List.of(7L, 14L))); // null
    }

    public static List<Long> howSum(long targetSum, List<Long> numbers) {
        var memo = new HashMap<Long, List<Long>>();
        return howSum(targetSum, numbers, memo);
    }

    private static List<Long> howSum(long targetSum, List<Long> numbers, Map<Long, List<Long>> memo) {
        if (memo.containsKey(targetSum)) return memo.get(targetSum);
        if (targetSum == 0) return new ArrayList<>();
        if (targetSum < 0) return null;

        List<Long> result = null;
        for (var number : numbers) {
            var combination = howSum(targetSum - number, numbers, memo);
            if (null == combination) continue;
            return Stream.concat(Stream.of(number), combination.stream())
                    .toList();
        }

        memo.put(targetSum, result);
        return result;
    }
}
