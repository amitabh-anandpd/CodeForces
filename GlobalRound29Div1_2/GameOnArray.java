import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.Writer;
import java.io.BufferedReader;

import java.util.InputMismatchException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class GameOnArray {
    static HashMap<Long, Integer> sortByValue(HashMap<Long, Integer> hm) {
        List<Map.Entry<Long, Integer> > list =
               new LinkedList<Map.Entry<Long, Integer> >(hm.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Long, Integer> >() {
            public int compare(Map.Entry<Long, Integer> o1, 
                               Map.Entry<Long, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
        
        HashMap<Long, Integer> temp = new LinkedHashMap<Long, Integer>();
        for (Map.Entry<Long, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
    public static void main(String args[])throws IOException {
        BfReader obj = new BfReader(System.in);
        FastPrinter out = new FastPrinter(System.out);
        int tests = obj.readInt();
        for(int i = 0; i < tests; i++){
            int n = obj.readInt();
            long[] a = new long[n];
            HashMap<Long, Integer> map = new HashMap<>();
            for(int j = 0; j < n; j++){
                a[j] = obj.readInt();
                map.put(a[j], map.getOrDefault(a[j], 0)+1);
            }
            HashMap<Long, Integer> sorted = sortByValue(map);
            int turn = 0;
            long alice = 0;
            long bob = 0;
            for(Map.Entry<Long, Integer> entry : sorted.entrySet()){
                if(entry.getKey()%2==0){
                    alice+=(entry.getValue()*entry.getKey())/2;
                    bob+=(entry.getValue()*entry.getKey())/2;
                    continue;
                }
                if(turn==0){
                    alice+=((entry.getKey()/2) + 1)*entry.getValue();
                    bob+=(entry.getKey()/2)*entry.getValue();
                    turn = 1;
                }
                else{
                    bob+=((entry.getKey()/2) + 1)*entry.getValue();
                    alice+=(entry.getKey()/2)*entry.getValue();
                    turn = 0;
                }
            }
            out.println(alice+" "+bob);

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
