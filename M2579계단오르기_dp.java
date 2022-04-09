import java.io.*;
import java.util.ArrayList;

public class M2579계단오르기_dp {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] cost;
    static Integer[] dp;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        dp = new Integer[N + 1];
        cost = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            cost[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = 0;
        dp[1] = cost[1];
        if( N >= 2) dp[2] = cost[1] + cost[2];
        bw.write(stair(N) + "");
        bw.flush();
    }

    private static int stair(int depth) {
        if(dp[depth] == null) {
            dp[depth] = Math.max(stair(depth-2), stair(depth-3) + cost[depth-1]) + cost[depth];
        }
        return dp[depth];
    }
}
