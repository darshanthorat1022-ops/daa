import java.util.Scanner;

public class NQueenSolver {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the value of N (size of the board): ");
        int n = scanner.nextInt();
        
        if (n <= 0) {
            System.out.println("Please enter a positive integer.");
            return;
        }

        int[] board = new int[n]; // board[i] stores the column index for row i
        // Initialize board with -1 to indicate no queen is placed yet
        for (int i = 0; i < n; i++) {
            board[i] = -1;
        }

        printBoard(board, n);

        // Allow the user to place queens row by row
        for (int row = 0; row < n; row++) {
            boolean validPlacement = false;
            
            while (!validPlacement) {
                System.out.print("Enter column (0 to " + (n - 1) + ") to place queen in Row " + row + ": ");
                int col = scanner.nextInt();
                
                // Check if column is within bounds
                if (col < 0 || col >= n) {
                    System.out.println("Invalid input! Column must be between 0 and " + (n - 1) + ".");
                    continue;
                }
                
                // Check if the position conflicts with already placed queens
                if (isSafe(row, col, board)) {
                    board[row] = col;
                    validPlacement = true;
                    System.out.println(" Safe position! Queen placed successfully.");
                    printBoard(board, n);
                } else {
                    System.out.println(" Wrong position! This queen will be attacked by another queen. Try a different column.");
                }
            }
        }
        
        System.out.println("\n Congratulations! All " + n + " queens placed successfully without conflicts!");
        scanner.close();
    }

    // Helper method to check if a queen can be safely placed at (row, col)
    private static boolean isSafe(int row, int col, int[] board) {
        for (int i = 0; i < row; i++) {
            // Check if column is the same or if it lies on the same diagonal
            if (board[i] == col || Math.abs(board[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }

    // Helper method to format and print the chessboard
    private static void printBoard(int[] board, int n) {
        System.out.println("\nCurrent Board:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
