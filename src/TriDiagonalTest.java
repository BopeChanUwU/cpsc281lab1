/**
 * This file is part of a solution to
 * CPSC 281 Assignment 1 Question 3 Test, Fall 2025
 *
 * <p> Implements a TriDiagonalTest class demonstrating the TriDiagonalMatrix class
 *
 * @author Tristen Sandhu
 * Student Number: 230165842
 * @version 1
 */

public class TriDiagonalTest {
    public static void main(String[] args) {

        // Create a tridiagonal matrix of size 5x5
        int[][] triMatrix = {
            {4, 1, 0, 0, 0},
            {2, 5, 3, 0, 0},
            {0, 6, 7, 8, 0},
            {0, 0, 9, 10, 11},
            {0, 0, 0, 12, 13}
        };
        TriDiagonalMatrix matrix = new TriDiagonalMatrix(triMatrix);

        System.out.println("Value at (1,1): " + matrix.getValue(1, 1)); // Should be 5
        // Print the entire matrix
        System.out.println("Tridiagonal Matrix:");
        System.out.println(matrix);
        // Store some values in the tridiagonal matrix
        matrix.storeValue(1, 1, 100);
        matrix.storeValue(1, 2, 1);
        matrix.storeValue(2, 1, 2);
        matrix.storeValue(2, 2, 5);
        matrix.storeValue(2, 3, 3);
        matrix.storeValue(3, 2, 6);
        matrix.storeValue(3, 3, 7);
        matrix.storeValue(3, 4, 8);
        matrix.storeValue(4, 3, 9);
        matrix.storeValue(4, 4, 10);
        matrix.storeValue(4, 5, 11);
        matrix.storeValue(5, 4, 12);
        matrix.storeValue(5, 5, 13);

        // Print the entire matrix
        System.out.println("Tridiagonal Matrix:");
        System.out.println(matrix);

        // Retrieve and print some values
        System.out.println("Value at (1,2): " + matrix.getValue(1, 2)); // Should be 1
        System.out.println("Value at (2,2): " + matrix.getValue(2, 2)); // Should be 7
        System.out.println("Value at (1,1): " + matrix.getValue(1, 1)); // Should be 4
        System.out.println("Value at (1,3): " + matrix.getValue(1, 3)); // Should be 0 (outside tridiagonal)

        // Attempt to store a non-tridiagonal value (should throw an exception)
        try {
            matrix.storeValue(1, 3, 5); // This should raise an exception
        } catch (IllegalArgumentException e) {
            System.out.println("Caught an exception: " + e.getMessage());
        }
    }
}
