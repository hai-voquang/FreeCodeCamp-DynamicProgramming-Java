package br.com.guilhermealvessilve.dynamic.programming.fibonacci;

public class FibonacciTabulation {

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

    public static long fibonacci(int n) {
        var table = new long[n + 1];
        table[1] = 1;
        for (int i = 0; i <= n; i++) {
            var value = table[i];
            add(table, i + 1, value);
            add(table, i + 2, value);
        }

        return table[n];
    }

    private static void add(long[] table, int next, long value) {
        if (table.length <= next) return;
        table[next] += value;
    }
}
