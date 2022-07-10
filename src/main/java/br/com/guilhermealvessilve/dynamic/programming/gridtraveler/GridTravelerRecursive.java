package br.com.guilhermealvessilve.dynamic.programming.gridtraveler;

public class GridTravelerRecursive {

    public static void main(String[] args) {
        System.out.println("gridTraveler(1, 1): " + gridTraveler(1, 1)); //1
        System.out.println("gridTraveler(2, 3): " + gridTraveler(2, 3)); //3
        System.out.println("gridTraveler(3, 2): " + gridTraveler(3, 2)); //3
        System.out.println("gridTraveler(3, 3): " + gridTraveler(3, 3)); //6
    }

    public static long gridTraveler(long m, long n) {
        if (m == 1 && n == 1) return 1;
        if (m == 0 || n == 0) return 0;
        return gridTraveler(m - 1, n) + gridTraveler(m, n - 1);
    }
}
