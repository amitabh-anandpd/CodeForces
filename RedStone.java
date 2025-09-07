import java.io.*;
import java.util.*;

public class RedStone {
    public static void main(String args[])throws IOException{
        BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(obj.readLine());
        for(int i = 0; i < tests; i++){
            @SuppressWarnings("unused")
            int n = Integer.parseInt(obj.readLine());
            int check = 0;
            String[] nums = (obj.readLine()).split(" ");
            Set<String> set = new HashSet<>();
            for(String num : nums){
                if(!set.add(num)){
                    System.out.println("YES");
                    check += 1;
                    break;
                }
            }
            if(check==0)
                System.out.println("NO");
        }
    }
}
