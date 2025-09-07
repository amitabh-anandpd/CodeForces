import java.io.*;
import java.util.*;

public class SecretNum {
    public static void main(String args[])throws IOException {
        BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
        int test_cases = Integer.parseInt(obj.readLine());
        for(int i = 0; i < test_cases; i++){
            long n = Long.parseLong(obj.readLine());
            List<Long> list = new ArrayList<>();
            int power = 1;
            while(n>=Math.pow(10, power)){
                long div = (long)Math.pow(10, power) + 1;
                if(n%div==0){
                    list.add(n/div);
                }
                power++;
            }
            System.out.println(list.size());
            if(list.size()>0){
                Collections.sort(list);
                for(int j = 0; j < list.size(); j++){
                    System.out.print(list.get(j)+ " ");
                }
                System.out.println();
            }
        }
    }
}