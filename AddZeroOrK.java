import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.io.BufferedReader;
import java.io.InputStream;
import java.util.InputMismatchException;

public class AddZeroOrK {
    public static void main(String args[])throws IOException {
        BfReader obj = new BfReader(System.in);
        FastPrinter out = new FastPrinter(System.out);
        int tests = obj.readInt();
        for(int i = 0; i < tests; i++){
            //start
            long n = obj.readInt();
            long k = obj.readInt();
            obj.readLine();
            long[] arr = obj.readLongString();
            for(int j = 0; j < n; j++){
                arr[j] = (arr[j]%(k+1))*k+arr[j];
                out.print(arr[j]+" ");
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
        public int[] readIntString(){
            try{
                String[] str = super.readLine().split(" ");
                int[] arr = new int[str.length];
                for(int i = 0; i < str.length; i++){
                    arr[i] = Integer.parseInt(str[i]);
                }
                return arr;
            } catch (IOException e) {
                throw new InputMismatchException();
            }
        }
        public long[] readLongString(){
            try{
                String[] str = super.readLine().split(" ");
                long[] arr = new long[str.length];
                for(int i = 0; i < str.length; i++){
                    arr[i] = Long.parseLong(str[i]);
                }
                return arr;
            } catch (IOException e) {
                throw new InputMismatchException();
            }
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
