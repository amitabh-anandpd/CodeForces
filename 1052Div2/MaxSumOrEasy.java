import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.Writer;
import java.io.BufferedReader;

import java.util.InputMismatchException;

public class MaxSumOrEasy {
    public static void main(String args[])throws IOException {
        BfReader obj = new BfReader(System.in);
        FastPrinter out = new FastPrinter(System.out);
        int tests = obj.readInt();
        while(tests-->0){
            @SuppressWarnings("unused")
            int l = obj.readInt();
            int r = obj.readInt();
            // int min = (int)(Math.log(r)/Math.log(2));
            out.println(1L*r*(r+1));
            // if(r==(Math.pow(2, min)-1)){
            //     for(int i = 0; i < r; i++){
            //         out.print((r-i)+" ");
            //     }
            //     continue;
            // }
            int a[] = new int[r+1];
            boolean used[] = new boolean[r+1];
            for(int i = r; i >= 0; i--){
                if(used[i]) continue;
                int k = 1;
                while(k<=i) k<<=1;
                int mask = k-1;
                int j = mask-i;
                a[i] = j;
                a[j] = i;
                used[i] = true;
                used[j] = true;
            }
            for(int i = 0; i <=r; i++){
                out.print(a[i]+" ");
            }
            out.println();
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