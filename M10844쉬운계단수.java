import java.io.*;

public class M10844쉬운계단수 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Integer[][] dp;
    static int N;
    static int MOD = 1000000000;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        dp = new Integer[N][10];

        int sum = 0;
        for (int i = 1; i < 10; i++) {
            sum = (sum + recur(0, i)) % MOD;
        }
        bw.write(sum % MOD + "");
        bw.flush();
    }

    private static int recur(int depth, int num) {
        if (depth == N - 1) {
            return 1;
        }
        if (dp[depth][num] == null) {
            if (num == 0) {
                return dp[depth][num] = recur(depth + 1, 1) % MOD;
            } else if (num == 9) {
                return dp[depth][num] = recur(depth + 1, num - 1) % MOD;
            } else {
                return dp[depth][num] = (recur(depth + 1, num + 1) % MOD + recur(depth + 1, num - 1) % MOD) % MOD;
            }
        } else {
            return dp[depth][num] % MOD;
        }
    }
}
