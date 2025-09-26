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
import java.util.List;
import java.util.Map;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class EqualOccurances {
    static HashMap<Integer, Integer> sortByValue(HashMap<Integer, Integer> hm) {
        List<Map.Entry<Integer, Integer> > list =
               new LinkedList<Map.Entry<Integer, Integer> >(hm.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >() {
            public int compare(Map.Entry<Integer, Integer> o1, 
                               Map.Entry<Integer, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
        
        HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>();
        for (Map.Entry<Integer, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
    public static void main(String args[])throws IOException {
        BfReader obj = new BfReader(System.in);
        FastPrinter out = new FastPrinter(System.out);
        int tests = obj.readInt();
        for(int i = 0; i < tests; i++){;
            int n = obj.readInt();
            int[] a = new int[n];
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int j = 0; j < n; j++){
                a[j] = obj.readInt();
                map.put(a[j], map.getOrDefault(a[j], 0)+1);
            }
            HashMap<Integer, Integer> sorted = sortByValue(map);
            int max = Integer.MIN_VALUE;
            int k = 0;
            int size = sorted.size();
            int[] prev = new int[size];
            for(Map.Entry<Integer, Integer> entry : sorted.entrySet()){
                prev[k] = entry.getValue();
                k++;
            }
            k = 0;
            for(Map.Entry<Integer, Integer> entry : sorted.entrySet()){
                int val;
                if(k==0) val = (entry.getValue()*size);
                else val = (entry.getValue())*(size-k);
                max = Math.max(max, val);
                k++;
            }
            out.println(max);
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
