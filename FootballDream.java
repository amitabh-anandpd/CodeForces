import java.io.*;

public class FootballDream {
    public static void main(String args[])throws IOException {
        BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
        int test_cases = Integer.parseInt(obj.readLine());
        for(int i = 0; i < test_cases; i++){
            String[] nums = (obj.readLine()).split(" ");
            int a = Integer.parseInt(nums[0]);
            int b = Integer.parseInt(nums[1]);
            int c = Integer.parseInt(nums[2]);
            int d = Integer.parseInt(nums[3]);
            c-=a;
            d-=b;
            if(a>b){
                if(a>(b*2+2)){
                    System.out.println("NO");
                    continue;
                }
            }
            else if(b>a){
                if(b>(a*2+2)){
                    System.out.println("NO");
                    continue;
                }
            }
            if(c>d){
                if(c>(d*2+2)){
                    System.out.println("NO");
                    continue;
                }
            }
            else if(d>c){
                if(d>(c*2+2)){
                    System.out.println("NO");
                    continue;
                }
            }
            System.out.println("YES");
        }
    }
}
