package br.com.guilhermealvessilve.dynamic.programming.fibonacci;

import java.util.HashMap;
import java.util.Map;

public class FibonacciMemoizationRecursive {

    public static void main(String[] args) {
        System.out.println("fibonacci(1): " + fibonacci(1)); // 1
        System.out.println("fibonacci(2): " + fibonacci(2)); // 1
        System.out.println("fibonacci(3): " + fibonacci(3)); // 2
        System.out.println("fibonacci(4): " + fibonacci(4)); // 3
        System.out.println("fibonacci(5): " + fibonacci(5)); // 5
        System.out.println("fibonacci(6): " + fibonacci(6)); // 8
        System.out.println("fibonacci(7): " + fibonacci(7)); // 13
        System.out.println("fibonacci(8): " + fibonacci(8)); // 21
        System.out.println("fibonacci(50): " + fibonacci(50)); // 12586269025
    }

    public static long fibonacci(long n) {
        var memo = new HashMap<Long, Long>();
        return fibonacci(n, memo);
    }

    private static long fibonacci(long n, Map<Long, Long> memo) {
        if (memo.containsKey(n)) return memo.get(n);
        if (n <= 2) return 1;
        long result = fibonacci(n - 1, memo) + fibonacci(n - 2, memo);
        memo.put(n, result);
        return result;
    }
}
