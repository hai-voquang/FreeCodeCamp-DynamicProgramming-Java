package br.com.guilhermealvessilve.dynamic.programming.cansum;

import java.util.List;

public class CanSumRecursive {

    public static void main(String[] args) {
        System.out.println("canSum(7, [2, 3]): " + canSum(7L, List.of(2L, 3L))); //true
        System.out.println("canSum(7, [5, 3, 4, 7]): " + canSum(7L, List.of(5L, 3L, 4L, 7L))); //true
        System.out.println("canSum(7, [2, 4]): " + canSum(7L, List.of(2L, 4L))); //false
        System.out.println("canSum(8, [2, 3, 5]): " + canSum(8L, List.of(2L, 3L, 5L))); //true
    }

    public static boolean canSum(long targetSum, List<Long> numbers) {
        if (targetSum == 0) return true;
        if (targetSum < 0) return false;
        return numbers.stream()
                .anyMatch(number -> canSum(targetSum - number, numbers));
    }
}
