import java.io.*;

public class M2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(br.readLine());

        int n = 0, sum = 1;
        if(input == 1) {
            n = 1;
        } else {
            while (input > sum) {
                n++;
                sum += 6*(n-1);
            }
        }
        System.out.println(n);
        // 1
        // 2~1+6
        // 1+6+1 ~ 1+6+12
        // 1+6+12+1 ~ 1+6+12+18
    }
}
