
import java.io.*;
import java.util.List;

public class Solution extends Template {

    public static void main(String args[]) throws IOException {
        int cases = inputInt();

        while (cases-- > 0) {
            solve();
        }

        closeBW();

    }

    private static void solve() {

    }

}

class Template {

    static Reader sc = new Reader();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int inputInt() throws IOException {
        return sc.nextInt();
    }

    public static long inputLong() throws IOException {
        return sc.nextLong();
    }

    public static double inputDouble() throws IOException {
        return sc.nextDouble();
    }

    public static String inputString() throws IOException {
        return sc.readLine();
    }

    public static void print(String a) throws IOException {
        bw.write(a);
    }

    public static void printWithSpace(String a) throws IOException {
        bw.write(a + " ");
    }

    public static void printNextLine(String a) throws IOException {
        bw.write(a + "\n");
    }

    public static void printWithSpace(int a) throws IOException {

        bw.write(Integer.toString(a) + " ");
    }

    public static void printNextLine(int a) throws IOException {
        bw.write(Integer.toString(a) + "\n");
    }

    public static void print(double a) throws IOException {
        bw.write(Double.toString(a));
    }

    public static void printWithSpace(double a) throws IOException {
        bw.write(Double.toString(a) + " ");
    }

    public static void printNextLine(double a) throws IOException {
        bw.write(Double.toString(a) + "\n");
    }

    public static void print(char a) throws IOException {
        bw.write(Character.toString(a));
    }

    public static void printWithSpace(char a) throws IOException {
        bw.write(Character.toString(a) + " ");
    }

    public static void printNextLine(char a) throws IOException {
        bw.write(Character.toString(a) + "\n");
    }

    public static void print(float a) throws IOException {
        bw.write(Float.toString(a));
    }

    public static void printWithSpace(float a) throws IOException {
        bw.write(Float.toString(a) + " ");
    }

    public static void printNextLine(float a) throws IOException {
        bw.write(Float.toString(a) + "\n");
    }

    public static void print(long a) throws IOException {
        bw.write(Long.toString(a));
    }

    public static void printWithSpace(long a) throws IOException {
        bw.write(Long.toString(a) + " ");
    }

    public static void printNextLine(long a) throws IOException {
        bw.write(Long.toString(a) + "\n");
    }

    public static void closeBW() throws IOException {
        bw.flush();
        bw.close();
    }

    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }
            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }

}

class StandardFunctions {
    public static int lowerBound(List<Integer> ar, int k) {
        int s = 0;
        int e = ar.size();
        while (s != e) {
            int mid = s + e >> 1;
            if (ar.get(mid) < k) {
                s = mid + 1;
            } else {
                e = mid;
            }
        }
        if (s == ar.size()) {
            return -1;
        }
        return s;
    }

    public static int upperBound(List<Integer> ar, int k) {
        int s = 0;
        int e = ar.size();
        while (s != e) {
            int mid = s + e >> 1;
            if (ar.get(mid) <= k) {
                s = mid + 1;
            } else {
                e = mid;
            }
        }
        if (s == ar.size()) {
            return -1;
        }
        return s;
    }
}