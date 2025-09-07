import java.io.*;

public class Ahomework {
    public static void main(String args[])throws IOException {
        BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
        int test_cases = Integer.parseInt(obj.readLine());
        for(int i = 0; i < test_cases; i++){
            @SuppressWarnings("unused")
            int len_A = Integer.parseInt(obj.readLine());
            String A = obj.readLine();
            int len_B = Integer.parseInt(obj.readLine());
            String B = obj.readLine();
            String order = obj.readLine();
            for(int j = 0; j < len_B; j++){
                if(order.charAt(j)=='V')
                    A = B.charAt(j) + A;
                else
                    A = A + B.charAt(j);
            }
            System.out.println(A);
        }
    }
}
