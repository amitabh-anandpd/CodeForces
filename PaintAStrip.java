import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.Writer;
import java.io.BufferedReader;

import java.util.InputMismatchException;

public class PaintAStrip {
    public static void main(String args[])throws IOException {
        BfReader obj = new BfReader(System.in);
        FastPrinter out = new FastPrinter(System.out);
        int tests = obj.readInt();
        while(tests-->0){
            int n = obj.readInt();
            if(n==1) {out.println(1); continue;}
            if(n<=4) {out.println(2); continue;}
            int counter = 4;
            for(int i = 2; i < n; i++){
                counter = 2*(counter+1);
                if(counter>=n){
                    out.println(i+1);
                    break;
                }
            }
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
