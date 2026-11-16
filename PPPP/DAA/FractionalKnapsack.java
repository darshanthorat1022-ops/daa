
import java.util.*;

public class FractionalKnapsack {    //fractional madhi div asti profit ani wt ch
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int[] value = new int[n];
        int[] weight = new int[n];
        double[] ratio = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter value: ");
            value[i] = sc.nextInt();

            System.out.print("Enter weight: ");
            weight[i] = sc.nextInt();

            ratio[i] = (double)value[i] / weight[i];
        }

        System.out.print("Enter capacity: ");
        int capacity = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (ratio[i] < ratio[j]) {
                    double temp = ratio[i];
                    ratio[i] = ratio[j];
                    ratio[j] = temp;

                    int t = value[i];
                    value[i] = value[j];
                    value[j] = t;

                    t = weight[i];
                    weight[i] = weight[j];
                    weight[j] = t;
                }
            }
        }

        double total = 0;

        for (int i = 0; i < n; i++) {
            if (weight[i] <= capacity) {
                total += value[i];
                capacity -= weight[i];
            } else {
                total += value[i] *((double)capacity / weight[i]);
                capacity = 0;
                break;
            }
        }

        System.out.println("Maximum Value = " + total);
        sc.close();
    }
}
