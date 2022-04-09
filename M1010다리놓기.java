import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class M1010다리놓기 {
    static Integer[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        dp = new Integer[31][31];
        dp[0][0] = 1;
        dp[1][0] = 1;
        dp[1][1] = 1;

        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            System.out.println(getBinomialCoefficient(K,N));
        }
    }

    static int getBinomialCoefficient(int N, int K) {

        if (dp[N][K] == null) {
            dp[N][0] = 1;
            dp[N][N] = 1;
            if(dp[N-1][0] == null) {
                getBinomialCoefficient(N-1,0);
            }
            for (int i = 1; i < N; i++) {
                dp[N][i] = dp[N-1][i] + dp[N-1][i-1] ;
            }
        }
        return dp[N][K];
    }
}
