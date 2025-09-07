import java.io.*;

public class PaintingWithTwoColors {
    public static void main(String args[])throws IOException {
        BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
        int test_cases = Integer.parseInt(obj.readLine());
        for(int i = 0; i < test_cases; i++){
            String[] nums = (obj.readLine()).split(" ");
            int n = Integer.parseInt(nums[0]);
            int a = Integer.parseInt(nums[1]);
            int b = Integer.parseInt(nums[2]);
            if((n-b)%2!=0){
                System.out.println("NO");
                continue;
            }
            if((n-a)%2==0 || a<=b){
                System.out.println("YES");
                continue;
            }
            System.out.println("NO");
        }
    }
}
