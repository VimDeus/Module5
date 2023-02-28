import java.io.FileWriter;
import java.io.IOException;

public class FibonnaciSeq {

    public static long fibonacciRecursive(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacciRecursive(n-1) + fibonacciRecursive(n-2);
        }
    }

    public static long fibonacciIterative(int n) {
        if (n <= 1) {
            return n;
        } else {
            long prev1 = 0, prev2 = 1, curr = 0;
            for (int i = 2; i <= n; i++) {
                curr = prev1 + prev2;
                prev1 = prev2;
                prev2 = curr;
            }
            return curr;
        }
    }

    public static void main(String[] args) throws IOException {
        String csvFile = "fibonacci.csv";
        FileWriter writer = new FileWriter(csvFile);

        writer.append("n");
        writer.append(',');
        writer.append("Recursive (ns)");
        writer.append(',');
        writer.append("Iterative (ns)");
        writer.append('\n');

        for (int n = 0; n <= 20; n++) {
            long startTime = System.nanoTime();
            long fibRec = fibonacciRecursive(n);
            long endTime = System.nanoTime();
            long durationRec = endTime - startTime;

            startTime = System.nanoTime();
            long fibIte = fibonacciIterative(n);
            endTime = System.nanoTime();
            long durationIte = endTime - startTime;

            writer.append(Integer.toString(n));
            writer.append(',');
            writer.append(Long.toString(durationRec));
            writer.append(',');
            writer.append(Long.toString(durationIte));
            writer.append('\n');
        }

        writer.flush();
        writer.close();
    }
}