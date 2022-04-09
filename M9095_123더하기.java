import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class M9095_123더하기 {
    private final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final static StringBuffer sb = new StringBuffer();
    private static Integer[] dp ;
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int n;
        dp = new Integer[12];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        while(N-->0) {
            n = Integer.parseInt(br.readLine());
            int count = getCnt(n);
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    private static int getCnt(int n) {

        if(dp[n] == null) {
            dp[n] = getCnt(n-1) + getCnt(n-2) + getCnt(n-3);
        }
        return dp[n];
    }
}
