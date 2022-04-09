import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LIS {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuffer sb = new StringBuffer();
    private static Integer[] dp;
    private static int[] nums;
    private static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        dp = new Integer[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, LIS(i));
        }
        System.out.println(max);
    }

    private static int LIS(int depth) {
        if (dp[depth] == null) {
            dp[depth] = 1;

            for (int i = depth - 1; i >= 0; i--) {
                if (nums[i] < nums[depth]) {
                    dp[depth] = Math.max(LIS(i) + 1, dp[depth]);
                }
            }
        }
        return dp[depth];
    }
}
