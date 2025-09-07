import java.io.*;

public class Alever{
    public static void main(String[] args) throws IOException {
        BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
        int test_cases = Integer.parseInt(obj.readLine());
        for(int test_case = 0; test_case < test_cases; test_case++) {
            int n = Integer.parseInt(obj.readLine());
            int[] arr1 = new int[n];
            String[] str = obj.readLine().split(" ");
            for(int i = 0; i < n; i++) {
                arr1[i] = Integer.parseInt(str[i]);
            }
            int[] arr2 = new int[n];
            str = obj.readLine().split(" ");
            for(int i = 0; i < n; i++) {
                arr2[i] = Integer.parseInt(str[i]);
            }
            int iterations = 0;
            while(true){
                int skip1 = 0;
                for(int i = 0; i < n; i++){
                    if(arr1[i]>arr2[i]){
                        arr1[i]-=1;
                        skip1+=1;
                        iterations++;
                    }
                    else if(arr1[i]<arr2[i]){
                        arr1[i]+=1;
                    }
                }
                
                if(skip1==0){
                    break;
                }
            }
            iterations++;
            System.out.println(iterations);
        }
        return;
    }
}