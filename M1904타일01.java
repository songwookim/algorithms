import java.io.*;

public class M1904타일01 {
    static Integer[] dp ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        dp = new Integer[N+2];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        bw.write(countBinary(N)+"");
        bw.flush();
    }
    private static int countBinary(int N) {
        if(dp[N] == null) {
            for (int i = 3; i <= N; i++) {
                dp[i] = (countBinary(i-1)+countBinary(i-2)) % 15746;
            }
        }
        return dp[N];
    }
}
