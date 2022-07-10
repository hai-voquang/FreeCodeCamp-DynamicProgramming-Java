package br.com.guilhermealvessilve.dynamic.programming.bestsum;

import java.util.ArrayList;
import java.util.List;

public class BestSumRecursive {

    public static void main(String[] args) {
        System.out.println("bestSum(7, [5, 3, 4, 7]): " + bestSum(7L, List.of(5L, 3L, 4L, 7L))); // [7]
        System.out.println("bestSum(8, [2, 3, 5]): " + bestSum(8L, List.of(2L, 3L, 5L))); // [3, 5]
        System.out.println("bestSum(8, [2, 3, 5]): " + bestSum(8L, List.of(1L, 4L, 5L))); // [4, 4]
    }

    public static List<Long> bestSum(long targetSum, List<Long> numbers) {
        if (targetSum == 0) return new ArrayList<>();
        if (targetSum < 0) return null;

        List<Long> shortestCombination = null;
        for (var number : numbers) {
            long remainder = targetSum - number;
            var combination = bestSum(remainder, numbers);
            if (null == combination) {
                continue;
            }

            combination.add(number);
            if (null == shortestCombination || shortestCombination.size() > combination.size()) {
                shortestCombination = combination;
            }
        }

        return shortestCombination;
    }
}
