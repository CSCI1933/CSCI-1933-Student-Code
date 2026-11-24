/**
 * Author: Noah Park on 04.11.2021.
 */
public class Lab11Tests {

    /**s
     * Tests for Milestone 2: Color Path.
     * Your class must be named 'ColorPath.java' and have a static method named colorPath(int[][] image, int sourceRow, int sourceCol, int newColor) that returns a 2D integer array that is the updated image.
     */
    public static void testColorPath() {
    /* Test 1 output expected:
              1 1 1
              1 2 2
              2 2 1
              2 1 1
    */
        System.out.println("Color Path Test 1: ");
        int[][] test = new int[][]{ {1, 1, 1}, {1, 0, 0}, {0, 0, 1}, {0, 1, 1} };
        int[][] res = ColorPath.colorPath(test, 1, 1, 2);
        for (int[] re : res) {
            for (int i : re) System.out.print(i + " ");
            System.out.println();
        }

        System.out.println();

    /* Test 2 output expected:
            1 1 1 0 0
            1 2 2 1 1
            2 2 1 1 1
            2 1 1 2 3
            3 3 0 0 0
    */
        System.out.println("Color Path Test 2: ");
        int[][] test2 = new int[][]{ {1, 1, 1, 0, 0}, {1, 0, 0, 1, 1}, {0, 0, 1, 1, 1}, {0, 1, 1, 2, 3}, {3, 3, 0, 0, 0} };
        int[][] res2 = ColorPath.colorPath(test2, 1, 1, 2);
        for (int[] ints : res2) {
            for (int anInt : ints) System.out.print(anInt + " ");
            System.out.println();
        }

        System.out.println();

    /* Test 3 output expected:
              2 2 2
              2 2 0
              2 0 1
    */
        System.out.println("Color Path Test 3: ");
        int[][] test3 = new int[][]{ {1, 1, 1}, {1, 1, 0}, {1, 0, 1} };
        int[][] res3 = ColorPath.colorPath(test3, 1, 1, 2);
        for (int[] ints : res3) {
            for (int anInt : ints) System.out.print(anInt + " ");
            System.out.println();
        }
    }

    /**
     * Tests for Milestone 3: Path Exists.
     * Your class must be named 'PathExists.java' and have a static method named doesPathExist(char[][] grid, int sourceRow, int sourceCol) that returns a boolean that tells us if the path exists between the source and ending vertices.
     */
    // public static void testPathExists() {
    //     char[][] grid1 = new char[][]{ {'v', 'p', 'p', 'p', 'x'}, {'x', 'x', 'x', 'p', 'x'}, {'x', 'x', 'p', 'p', 'x'}, {'x', 'x', 'p', 'x', 'x'}, {'x', 'x', 'p', 'p', 'v'} };
    //     char[][] grid2 = new char[][]{ {'v', 'p', 'p', 'p', 'x'}, {'x', 'x', 'x', 'p', 'x'}, {'p', 'p', 'p', 'p', 'x'}, {'p', 'x', 'x', 'p', 'x'}, {'p', 'p', 'p', 'x', 'v'} };
    //     char[][] grid3 = new char[][]{ {'v', 'x'}, {'x', 'v'} };
    //     char[][] grid4 = new char[][]{ {'v', 'v'}, {'x', 'x'} };

    //     // Grid 1 Expected Output: True
    //     System.out.println("Path Exists Test 1: " + PathExists.doesPathExist(grid1, 0, 0));
    //     for (char[] row : grid1) {
    //         for (char c : row) System.out.print(c + " ");
    //         System.out.println();
    //     }

    //     System.out.println();

    //     // Grid 2 Expected Output: False
    //     System.out.println("Path Exists Test 2: " + PathExists.doesPathExist(grid2, 0, 0));
    //     for (char[] row : grid2) {
    //         for (char c : row) System.out.print(c + " ");
    //         System.out.println();
    //     }

    //     System.out.println();

    //     // Grid 3 Expected Output: False
    //     System.out.println("Path Exists Test 3: " + PathExists.doesPathExist(grid3, 0, 0));
    //     for (char[] row : grid3) {
    //         for (char c : row) System.out.print(c + " ");
    //         System.out.println();
    //     }

    //     System.out.println();

    //     // Grid 4 Expected Output: True
    //     System.out.println("Path Exists Test 4: " + PathExists.doesPathExist(grid4, 0, 0));
    //     for (char[] row : grid4) {
    //         for (char c : row) System.out.print(c + " ");
    //         System.out.println();
    //     }
    // }

    /**
     * Main method runs all test methods.
     *
     * @param args CLA.
     */
    public static void main(String[] args) {
        testColorPath();
        System.out.println();

        // Comment this in for Milestone 3
        // testPathExists();
        // System.out.println();
    }

}
