import java.io.*;

public class LargestSubsequenceNeat {
    public static int getLargest(int num, int k, int n, int[] arr){
        if(k-n<=0) return 0;
        int count = 0;
        int largest = 0;
        for(int i = k; i < n; i++){
            for(int j = i; j < n; j++){
                if(arr[j]==num){
                    count++;
                }
                if(count==num){
                    int l = getLargest(arr[j+1], j+1, n, arr);
                }
            }
        }
        return largest;
    }
    public static void main(String args[])throws IOException {
        BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
        int test_cases = Integer.parseInt(obj.readLine());
        for(int i = 0; i < test_cases; i++){
            int n = Integer.parseInt(obj.readLine());
            String[] nums = (obj.readLine()).split(" ");
            int arr[] = new int[n];
            for(int j = 0; j < n; j++){
                arr[j] = Integer.parseInt(nums[j]);
            }
            int[] largest = new int[n];
            for(int j = 0; j < n; j ++){
                largest[j] = getLargest(arr[j], j+1, n, arr);
            }
            int m = largest[0];
            for(int j = 0; j < n; j ++){
                if(m<largest[j])
                    m = largest[j];
            }
            System.out.println(largest[m]);
        }
    }
}
