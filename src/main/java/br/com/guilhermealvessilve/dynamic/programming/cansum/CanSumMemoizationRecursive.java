package br.com.guilhermealvessilve.dynamic.programming.cansum;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CanSumMemoizationRecursive {

    public static void main(String[] args) {
        System.out.println("canSum(7, [2, 3]): " + canSum(7L, List.of(2L, 3L))); //true
        System.out.println("canSum(7, [5, 3, 4, 7]): " + canSum(7L, List.of(5L, 3L, 4L, 7L))); //true
        System.out.println("canSum(7, [2, 4]): " + canSum(7L, List.of(2L, 4L))); //false
        System.out.println("canSum(8, [2, 3, 5]): " + canSum(8L, List.of(2L, 3L, 5L))); //true
        System.out.println("canSum(300, [7, 14]): " + canSum(300L, List.of(7L, 14L))); //false
    }

    public static boolean canSum(long targetSum, List<Long> numbers) {
        var memo = new HashMap<Long, Boolean>();
        return canSum(targetSum, numbers, memo);
    }

    private static boolean canSum(long targetSum, List<Long> numbers, Map<Long, Boolean> memo) {
        if (memo.containsKey(targetSum)) return memo.get(targetSum);
        if (targetSum == 0) return true;
        if (targetSum < 0) return false;
        return numbers.stream()
                .anyMatch(number -> {
                    var calculation = targetSum - number;
                    var result = canSum(calculation, numbers, memo);
                    memo.put(calculation, result);
                    return result;
                });
    }
}
