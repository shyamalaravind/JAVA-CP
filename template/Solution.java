package template;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.StringTokenizer;

public class Solution extends StandardFunctions {
    static PrintWriter out = new PrintWriter(System.out);

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


    
    private static void solve() {
    
    }


}

class StandardFunctions extends Input {
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



class SegmentTreeForSlots {
    int size;
    int [] tree;

    SegmentTreeForSlots(int size){
        this.size = size;
        this.tree = new int[4 * size];
        buildTree(0, size - 1, 0);
    }

    private void buildTree(int start, int end, int index){
        if(start == end){
            tree[index] = 1;
            return;
        }

        int left = 2* index + 1;
        int right = 2 * index + 2;
        int mid = (end - start)/2 + start;


        buildTree(start, mid, left);
        buildTree(mid + 1, end, right);
        tree[index] = tree[left] + tree[right];
    }

    public int getPositionAndUpdate(int k) {
        return getPositionAndUpdate(0, size - 1, 0, k);
    }

    private int getPositionAndUpdate(int start, int end, int index, int k){
        if(start == end) {
            tree[index] = 0;
            return start;
        }
        int left = 2 * index + 1;
        int right =  2 * index + 2;
        int mid = (end - start)/ 2 + start;
        int returnVal = -1;
        if(tree[left] >= k) {
            returnVal =  getPositionAndUpdate(start, mid, left, k);
        }
        else {
            returnVal =  getPositionAndUpdate(mid + 1, end, right, k - tree[left]);
        }
        tree[index] = tree[left] + tree[right];
        return returnVal;
    }
}



class DisjointSet
{
    int[] parent;
    int[] size;
    
    DisjointSet(int n)
    {
        this.parent = new int[n];
        this.size = new int[n];
        
        for(int i = 0; i < n; i++) parent[i] = i;
        Arrays.fill(size, 1);
    }
    
    public void union(int u, int v)
    {
        int parU = getParent(u);
        
        int parV = getParent(v);
        
        if(parU == parV) return;
        
        if(size[parU] > size[parV])
        {
            parent[parV] = parU;
            size[parU] = size[parU] + size[parV];
        }
        else 
        {
            parent[parU] = parV;
            size[parV] = size[parU] + size[parV];
        }
    }
    
    public int getParent(int u)
    {
        if(parent[u] == u) return u;
        parent[u] = getParent(parent[u]);
        return parent[u];
    }
}


