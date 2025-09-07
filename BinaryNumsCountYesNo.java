import java.io.*;

public class BinaryNumsCountYesNo {
    public static void main(String args[])throws IOException {
        BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
        int test_cases = Integer.parseInt(obj.readLine());
        for(int i = 0; i < test_cases; i++){
            String[] nums = (obj.readLine()).split(" ");
            int n = Integer.parseInt(nums[0]);
            int k = Integer.parseInt(nums[1]);
            String[] str = (obj.readLine()).split("");
            for(int j = 0; j < n; j++){
                if(str[j].equals("0")){
                    continue;
                }
                int count = 0;
                for(int m = 0; m < k+1; m++){
                    if(m+k>n) break;
                    if(str[j+m].equals("1"))
                        count++;
                }
                if(count>k){
                    System.out.println("NO");
                    break;
                }
            }
        }
    }
}
