import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class M117262xn타일링_dp {
    private final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final static StringBuffer sb = new StringBuffer();
    private static int N;
    private static Integer[] dp;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        dp = new Integer[N + 1];
        dp[0] = 1;
        dp[1] = 3;
        sb.append(dp(N - 1) % 10007);
        System.out.println(sb);
    }

    static int dp(int depth) {
        if (dp[depth] == null) {
            dp[depth] = dp(depth - 1) % 10007 + dp(depth - 2) * 2 % 10007;
        }
        return dp[depth];
    }
}
