import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.Writer;
import java.io.BufferedReader;

import java.util.InputMismatchException;

public class OneToInf {

    public static long sum(long n){
        if(n<10) return n*(n+1)/2;
        long c = (long)(Math.log10(n));
        long p = (long)Math.pow(10, c);
        return (long)(sum(p-1)*10 + 45*Math.pow(10, c));
    }
    public static long digit_sum(long n){
        long sum = 0;
        while(n!=0){
            sum+=n%10;
            n/=10;
        }
        return sum;
    }
    public static void main(String args[])throws IOException {
        BfReader obj = new BfReader(System.in);
        FastPrinter out = new FastPrinter(System.out);
        int tests = obj.readInt();
        obj.readLine();
        for(int i = 0; i < tests; i++){
            long k = Long.parseLong(obj.readLine());
            int c = 1;
            while(true){
                if(k<(Math.pow(10, c-1)*9*c)) break;
                k-=Math.pow(10, c-1)*9*c;
                c++;
            }
            long n = (long)Math.pow(10, c-1)-1;
            while(k>c){
                k-=c;
                n++;
            }
            long sum = 0;
            for(int m = (int)Math.pow(10, c-2); m <= n; m++){
                sum += digit_sum(m);
            }
            sum+=sum((long)Math.pow(10, c-2)-1);
            out.println(sum+1);
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
