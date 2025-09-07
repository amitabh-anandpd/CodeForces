import java.io.*;

public class CunningSellerEasy {
    public static void main(String args[])throws IOException {
        BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
        int test_cases = Integer.parseInt(obj.readLine());
        for(int i = 0; i < test_cases; i++){
            int n = Integer.parseInt(obj.readLine());
            int[] bt = new int[31];
            int k = 0;
            while(n!=0){
                bt[k++] = n%3;
                n = n/3;
            }
            long cost = 0;
            for(int j = 0; j < 31; j++){
                if(bt[j]==0)
                    continue;
                cost+= bt[j]*(Math.pow(3, j+1) + j*(Math.pow(3, j-1)));
            }
            System.out.println(cost);
        }
    }
}
