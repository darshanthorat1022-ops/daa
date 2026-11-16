
import java.util.*;

public class fibb {

    static void iterative(int n) {
        int a = 0, b = 1;

        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");
            int c = a + b;
            a = b;
            b = c;
        }
    }

    static int recursive(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        return recursive(n - 1) + recursive(n - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of terms: ");
        int n = sc.nextInt();

        System.out.println("1. Iterative");
        System.out.println("2. Recursive");
        System.out.print("Enter choice: ");
        int ch = sc.nextInt();

        if (n < 0) {
            System.out.println("Invalid number of terms");
        } else if (ch == 1) {
            iterative(n);
        } else if (ch == 2) {
            for (int i = 0; i < n; i++) {
                System.out.print(recursive(i) + " ");
            }
        } else {
            System.out.println("Invalid choice");
        }
    }
}
