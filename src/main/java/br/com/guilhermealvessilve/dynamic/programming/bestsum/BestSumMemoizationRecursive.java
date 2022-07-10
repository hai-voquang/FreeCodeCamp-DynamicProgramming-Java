package br.com.guilhermealvessilve.dynamic.programming.bestsum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestSumMemoizationRecursive {

    public static void main(String[] args) {
        System.out.println("bestSum(7, [5, 3, 4, 7]): " + bestSum(7L, List.of(5L, 3L, 4L, 7L))); // [7]
        System.out.println("bestSum(8, [2, 3, 5]): " + bestSum(8L, List.of(2L, 3L, 5L))); // [3, 5]
        System.out.println("bestSum(8, [2, 3, 5]): " + bestSum(8L, List.of(1L, 4L, 5L))); // [4, 4]
        System.out.println("bestSum(100, [1, 2, 5, 25]): " + bestSum(100L, List.of(1L, 2L, 5L, 25L))); // [25, 25, 25, 25]
    }

    public static List<Long> bestSum(long targetSum, List<Long> numbers) {
        var memo = new HashMap<Long, List<Long>>();
        return bestSum(targetSum, numbers, memo);
    }

    public static List<Long> bestSum(long targetSum, List<Long> numbers, Map<Long, List<Long>> memo) {
        if (memo.containsKey(targetSum)) return memo.get(targetSum);
        if (targetSum == 0) return new ArrayList<>();
        if (targetSum < 0) return null;

        List<Long> shortestCombination = null;
        for (var number : numbers) {
            long remainder = targetSum - number;
            var remainderCombination = bestSum(remainder, numbers, memo);
            if (null == remainderCombination) {
                continue;
            }

            var combination = new ArrayList<>(remainderCombination);
            combination.add(number);
            if (null == shortestCombination || shortestCombination.size() > combination.size()) {
                shortestCombination = combination;
            }
        }

        memo.put(targetSum, shortestCombination);
        return shortestCombination;
    }
}
