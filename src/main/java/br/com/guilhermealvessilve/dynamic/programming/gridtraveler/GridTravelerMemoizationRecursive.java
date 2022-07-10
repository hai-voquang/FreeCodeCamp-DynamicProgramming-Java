package br.com.guilhermealvessilve.dynamic.programming.gridtraveler;

import java.util.HashMap;
import java.util.Map;

public class GridTravelerMemoizationRecursive {

    public static void main(String[] args) {
        System.out.println("gridTraveler(1, 1): " + gridTraveler(1, 1)); //1
        System.out.println("gridTraveler(2, 3): " + gridTraveler(2, 3)); //3
        System.out.println("gridTraveler(3, 2): " + gridTraveler(3, 2)); //3
        System.out.println("gridTraveler(3, 3): " + gridTraveler(3, 3)); //6
        System.out.println("gridTraveler(18, 18): " + gridTraveler(18, 18)); //2333606220
    }

    public static long gridTraveler(long m, long n) {
        var memo = new HashMap<String, Long>();
        return gridTraveler(m, n, memo);
    }

    private static long gridTraveler(long m, long n, Map<String, Long> memo) {
        var key = m + "," + n;
        if (memo.containsKey(key)) return memo.get(key);
        if (m == 1 && n == 1) return 1;
        if (m == 0 || n == 0) return 0;
        long result = gridTraveler(m - 1, n, memo) + gridTraveler(m, n - 1, memo);
        memo.put(key, result);
        return result;
    }
}
