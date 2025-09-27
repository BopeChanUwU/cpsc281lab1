/**
 * This file is part of a solution to
 * CPSC 281 Assignment 1, Fall 2025
 *
 * <p> Implements a Birthday class that stores a person's name and birthday
 *
 * @author Tristen Sandhu
 * Student Number: 230165842
 * @version 1
 */

public class TriDiagonalMatrix {

    private int length; // size of the matrix (n x n)
    private int[] triDiagonalStorage; // storage for the non-zero elements
    
    /**
     * Constructor for TriDiagonalMatrix throws IllegalArgumentException if the matrix is not tridiagonal
     * @param matrix
     */
    public TriDiagonalMatrix(int[][] matrix) {
        if(matrix.length != matrix[0].length) {
            throw new IllegalArgumentException("Matrix must be square");
        }
        this.length = matrix.length;
        this.triDiagonalStorage = new int[3*length-1];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                switch (i-j){   
                case 0->{ triDiagonalStorage[i] = matrix[i][j];} // main diagonal
                case -1->{ triDiagonalStorage[length+i] = matrix[i][j];} // upper diagonal
                case 1->{ triDiagonalStorage[2*length+i-2] = matrix[i][j]; }// lower diagonal
                default->{ if (matrix[i][j]!=0) throw new IllegalArgumentException("Only tridiagonal matrices are allowed"); }  
                }
            }
        }
    }

    /**
     * gets the value of the tri-diagonal matrix at position (i,j)
     * @param i int row index (1-n)
     * @param j int column index (1-n)
     * @return
     */
    public int getValue(int i, int j) {
        int row = i-1;
        int col = j-1;
        if (row < 0 || row > length || col < 0 || col > length) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (Math.abs(i - j) > 1) {
            return 0; // outside the tridiagonal
        }
        switch (i-j){   
            case 0 -> {return triDiagonalStorage[row];} // main diagonal
            case -1 -> {return triDiagonalStorage[length+row];} // upper diagonal
            case 1 -> {return triDiagonalStorage[2*length+row-2];} // lower diagonal
            default -> throw new IllegalArgumentException("This should never happen");
        }
    }

    /**
     * stores a value in the tri-diagonal matrix at position (i,j)
     * @param i int row index (1-n)
     * @param j int column index (1-n)
     * @param value int value to store
     */
    public void storeValue(int i, int j, int value) {
        int row = i-1;
        int col = j-1;
        if (row < 0 || row > length || col < 0 || col > length) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (Math.abs(i - j) > 1) {
            if (value != 0) {
                throw new IllegalArgumentException("Only tridiagonal matrices are allowed");
            } else {
                return; // do nothing for zero values outside the tridiagonal
            }
        }
        switch (i-j){   
            case 0 -> {triDiagonalStorage[row] = value;} // main diagonal
            case -1 -> {triDiagonalStorage[length+row] = value;} // upper diagonal
            case 1 -> {triDiagonalStorage[2*length+row-2] = value;} // lower diagonal
            default -> throw new IllegalArgumentException("This should never happen");
        }
    }

    /**
     * returns a string representation of the matrix as nxn
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= length; j++) {
                sb.append(getValue(i, j)).append("  ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
