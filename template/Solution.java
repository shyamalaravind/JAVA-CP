package template;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.StringTokenizer;

public class Solution extends Input {
    static PrintWriter out = new PrintWriter(System.out);

    private static void solve() {
        out.println("asdf");
    }

    public static void main(String args[]) throws IOException {
        int cases = nextInt();
        for (int i = 1; i <= cases; i++) {
            try {
                solve();
            } catch (Throwable e) {
                System.err.println(e.toString() + " for testcase: " + i);
                e.printStackTrace();
            }
        }
        out.close();
    }

}

class StandardFunctions {
    public static int upperBound(int[] arr, int s, int e, int k) {
        while (s <= e) {
            int m = (s + e) / 2;

            if (arr[m] > k) {
                e = m - 1;
            } else
                s = m + 1;
        }

        return s;
    }

    public static int lowerBound(int[] arr, int s, int e, int k) {
        while (s <= e) {
            int m = (s + e) / 2;

            if (arr[m] >= k) {
                e = m - 1;
            } else
                s = m + 1;
        }

        return s;
    }
}

class Input {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = new StringTokenizer("");

    static String nextString() {
        while (!st.hasMoreTokens())
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
            }
        return st.nextToken();
    }

    static int nextInt() {
        return Integer.parseInt(nextString());
    }

    static long nextLong() {
        return Long.parseLong(nextString());
    }

    static double nextDouble() {
        return Double.parseDouble(nextString());
    }

    static float nextFloat() {
        return Float.parseFloat(nextString());
    }

    static boolean nextBoolean() {
        return Boolean.parseBoolean(nextString());
    }

    static char nextChar() throws IOException {
        return (char) br.read();
    }

    static String nextLine() throws IOException {
        return br.readLine();
    }

    static int[] nextIntArray(int length) {
        int[] output = new int[length];
        for (int i = 0; i < length; i++)
            output[i] = nextInt();
        return output;
    }

    static long[] nextLongArray(int length) {
        long[] output = new long[length];
        for (int i = 0; i < length; i++)
            output[i] = nextLong();
        return output;
    }

    static double[] nextDoubleArray(int length) {
        double[] output = new double[length];
        for (int i = 0; i < length; i++)
            output[i] = nextDouble();
        return output;
    }

    static float[] nextFloatArray(int length) {
        float[] output = new float[length];
        for (int i = 0; i < length; i++)
            output[i] = nextFloat();
        return output;
    }

    static boolean[] nextBooleanArray(int length) {
        boolean[] output = new boolean[length];
        for (int i = 0; i < length; i++)
            output[i] = nextBoolean();
        return output;
    }

    static char[] nextCharArray(int length) throws IOException {
        char[] output = new char[length];
        for (int i = 0; i < length; i++)
            output[i] = nextChar();
        return output;
    }

    static String[] nextStringArray(int length) throws IOException {
        String[] output = new String[length];
        for (int i = 0; i < length; i++)
            output[i] = nextLine();
        return output;
    }
}

class Stack<T> extends ArrayDeque<T> {
    Stack(Collection<T> collection) {
        super(collection);
    }

    public T pop() {
        return pollLast();
    }

    public void push(T val) {
        offerLast(val);
    }
}
