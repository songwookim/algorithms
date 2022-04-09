import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class M16149카드구매하기2 {
    private final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final static StringBuffer sb = new StringBuffer();
    private static Integer[] dp;
    private static int[] costs;
    private static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        dp = new Integer[N + 1];
        costs = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            costs[i] = Integer.parseInt(st.nextToken());
        }
        dp[1] = costs[0];

        int max = getMaxCost(N);
        sb.append(max);
        System.out.println(sb);
    }

    private static int getMaxCost(int depth) {
        if (depth == 1) return dp[1];
        int min = costs[depth - 1];
        if (dp[depth] == null) {
            for (int i = 1; i < depth; i++) {
                int temp = 0;
                int temp2 = 0;
                for (int j = i; temp2 != depth; j = depth - j) {
                    temp2 += j;
                    temp += getMaxCost(j);
                }
                min = Math.min(min, temp);
            }
            dp[depth] = min;
        }
        return dp[depth];
    }
}
