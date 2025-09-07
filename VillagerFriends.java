import java.io.*;
import java.util.*;

public class VillagerFriends {
    public static void main(String[] args)throws IOException{
        BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(obj.readLine());
        for(int i = 0; i < tests; i++){
            int n = Integer.parseInt(obj.readLine());
            String[] numbers = (obj.readLine()).split(" ");
            List<Integer> nums = new ArrayList<>();
            for(String num : numbers)
                nums.add(Integer.parseInt(num));
            Collections.sort(nums);
            long sum = 0L;
            for(int j = n-1; j > 0; j-=2){
                //int max = Math.max(nums.get(j), nums.get(j+1));
                //nums.set(j, nums.get(j)-max);
                //nums.set(j+1,  nums.get(j+1)-max);
                sum += nums.get(j);
            }
            if(n%2!=0){
                //int max = Math.max(nums.get(n-2), nums.get(n-1));
                //nums.set(n-2, nums.get(n-2)-max);
                //nums.set(n-1,  nums.get(n-1)-max);
                sum += nums.get(0);
            }
            System.out.println(sum);
        }
    }
}