import java.io.*;

public class M1463일로만들기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Integer[] dp;
    static int N;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        dp = new Integer[N+1];
        dp[0] = dp[1] = 0;

        bw.write(toOne(N) + "");
        bw.flush();
    }

    private static int toOne(int N) {
        if (dp[N] == null) {
            if (N % 6 == 0) {
                return dp[N] = Math.min(toOne(N - 1), Math.min(toOne(N / 2), toOne(N / 3)))+ 1;
            } else if (N % 3 == 0) {
                return dp[N] = Math.min(toOne(N / 3), toOne(N - 1)) + 1;
            } else if (N % 2 == 0) {
                return dp[N] = Math.min(toOne(N / 2), toOne(N - 1)) + 1;
            } else {
                return dp[N] = toOne(N - 1) + 1;
            }
        }
        return dp[N];
    }
}
