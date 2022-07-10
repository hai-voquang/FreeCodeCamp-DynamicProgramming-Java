package br.com.guilhermealvessilve.dynamic.programming.gridtraveler;

public class GridTravelerTabulation {

    public static void main(String[] args) {
        System.out.println("gridTraveler(1, 1): " + gridTraveler(1, 1)); //1
        System.out.println("gridTraveler(2, 3): " + gridTraveler(2, 3)); //3
        System.out.println("gridTraveler(3, 2): " + gridTraveler(3, 2)); //3
        System.out.println("gridTraveler(3, 3): " + gridTraveler(3, 3)); //6
        System.out.println("gridTraveler(18, 18): " + gridTraveler(18, 18)); //2333606220
    }

    public static long gridTraveler(int m, int n) {
        var table = new long[m + 1][n + 1];
        table[1][1] = 1;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                var value = table[i][j];
                add(table, i + 1, j, value);
                add(table, i, j + 1, value);
            }
        }

        return table[m][n];
    }

    private static void add(long[][] table, int i, int j, long value) {
        if (table.length <= i || table[i].length <= j) return;
        table[i][j] += value;
    }
}
