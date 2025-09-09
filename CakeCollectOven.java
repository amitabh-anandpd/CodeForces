import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.Writer;
import java.io.BufferedReader;

import java.util.InputMismatchException;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class CakeCollectOven {
    public static void main(String args[])throws IOException {
        BfReader obj = new BfReader(System.in);
        FastPrinter out = new FastPrinter(System.out);
        int tests = obj.readInt();
        obj.readLine();
        for(int i = 0; i < tests; i++){
            String[] st = obj.readLine().split(" ");
            long n = Long.parseLong(st[0]);
            long m = Long.parseLong(st[1]);
            List<Long> a = new ArrayList<>();
            String[] s = (obj.readLine()).split(" ");
            long sum = 0L;
            for(int j = 0; j < n; j++){
                long num = Long.parseLong(s[j]);
                a.add(num);
                sum+=num;
            }
            if(n==1){
                out.println(a.get(0)*m);
                continue;
            }
            if(m>n){
                sum = n * sum * ((m/n));
            }
            else sum = 0L;
            int start = (int) ((int)(n - (m%n))%n);
            Collections.sort(a);
            for(int j = 0; j < m%n; j++){
                sum += (j+1)*a.get(start);
                start = (start+1)%(int)n;
            }
            for(int j = (int)(m%n); j < n; j++){
                sum -= (n-(j+1)) * a.get(start);
                start = (start+1)%(int)n;
            }
            out.println(sum);
        }
        out.close();
    }

    //FastScanner and FastWriter implementation from SecondThread (codeforces)
    static class BfReader extends BufferedReader{
        public BfReader(InputStream in){
            super(new InputStreamReader(in));
        }
        static boolean isWhiteSpace(int c) {
            return c >= 0 && c <= 32;
        }
        public String next() {
            StringBuilder sb = new StringBuilder();
            int c = read();
            while (isWhiteSpace(c)) {
                c = read();
            }
            if (c < 0) {
                return null;
            }
            while (c >= 0 && !isWhiteSpace(c)) {
                sb.appendCodePoint(c);
                c = read();
            }
            return sb.toString();
        }
        public int read() {
            try {
                int ret = super.read();
                return ret;
            } catch (IOException e) {
                throw new InputMismatchException();
            }
        }
        public String readLine() {
            try {
                return super.readLine();
            } catch (IOException e) {
                return null;
            }
        }
        public int readInt() {
            int c = read();
            while (isWhiteSpace(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int ret = 0;
            while (c >= 0 && !isWhiteSpace(c)) {
                if (c < '0' || c > '9') {
                    throw new NumberFormatException("digit expected " + (char) c
                            + " found");
                }
                ret = ret * 10 + c - '0';
                c = read();
            }
            return ret * sgn;
        }
    }
    static class FastPrinter extends PrintWriter {
        public FastPrinter(OutputStream out) {
            super(out);
        }
        public FastPrinter(Writer out) {
            super(out);
        }
    }
}
