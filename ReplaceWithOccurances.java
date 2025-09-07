import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.Writer;
import java.io.BufferedReader;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.HashMap;

public class ReplaceWithOccurances {
    public static void main(String args[])throws IOException {
        BfReader obj = new BfReader(System.in);
        FastPrinter out = new FastPrinter(System.out);
        int tests = obj.readInt();
        for(int i = 0; i < tests; i++){
            int n = obj.readInt();
            int[] b = new int[n];
            Map<Integer, Integer> map = new HashMap<>();
            for(int j = 0; j < n; j++){
                int m = obj.readInt();
                b[j] = m;
                map.put(m, map.getOrDefault(m,0)+1);
            }
            boolean is_ok = true;
            for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                if(entry.getValue()%entry.getKey()!=0){
                    is_ok = false;
                    break;
                }
            }
            if(is_ok){
                int c = 1;
                // for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                //     int v = entry.getValue();
                //     int k = entry.getKey();
                //     if(k==v){
                //         for(int j = 0; j < k; j++){
                //             out.print(c+" ");
                //         }
                //         c++;
                //     }
                //     else{
                //         for(int j = 0; j < n; j++){
                //             for(int l = 0; l < b[j]; l++)
                //                 out.print(c+" ");
                //             c++;
                //             j+=b[j]-1;
                //             if(j>(n-1)) break;
                //         }
                //     }

                // }
                for(int j = 0; j < n; j++){
                    for(int l = 0; l < b[j]; l++)
                        out.print(c+" ");
                    c++;
                    j+=b[j]-1;
                    if(j>(n-1)) break;
                }
                out.println();
            }
            else out.println("-1");
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
