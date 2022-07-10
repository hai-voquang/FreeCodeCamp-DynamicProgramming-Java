package br.com.guilhermealvessilve.dynamic.programming.cansum;

import java.util.List;

public class CanSumTabulation {

    public static void main(String[] args) {
        System.out.println("canSum(7, [2, 3]): " + canSum(7, List.of(2L, 3L))); //true
        System.out.println("canSum(7, [5, 3, 4, 7]): " + canSum(7, List.of(5L, 3L, 4L, 7L))); //true
        System.out.println("canSum(7, [2, 4]): " + canSum(7, List.of(2L, 4L))); //false
        System.out.println("canSum(8, [2, 3, 5]): " + canSum(8, List.of(2L, 3L, 5L))); //true
        System.out.println("canSum(300, [7, 14]): " + canSum(300, List.of(7L, 14L))); //false
    }

    public static boolean canSum(int targetSum, List<Long> numbers) {
        var array = new boolean[targetSum + 1];
        array[0] = true;

        for (int i = 0; i < array.length; i++) {
            if (!array[i]) continue;
            for (var number : numbers) {
                setTrue(array, (int) (i + number));
            }
        }

        return array[targetSum];
    }

    private static void setTrue(boolean[] array, int i) {
        if (array.length <= i) return;
        array[i] = true;
    }
}
