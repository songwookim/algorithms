import java.io.*;
import java.util.StringTokenizer;

public class M1149RGB거리 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] colorCosts;
    static int[][] dp;
    static int nodeNum;
    static final int RED = 0;
    static final int GREEN = 1;
    static final int BLUE = 2;

    public static void main(String[] args) throws IOException {
        nodeNum = Integer.parseInt(br.readLine());

        colorCosts = new int[nodeNum][3];
        dp = new int[nodeNum][3];

        StringTokenizer st;
        for (int node = 0; node < nodeNum ; node++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 3; j++) {
                colorCosts[node][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.arraycopy(colorCosts[0], 0, dp[0], 0, 3);
        int minCost = getMin(getMinSumEachColor(nodeNum-1, 0), getMinSumEachColor(nodeNum-1, 1), getMinSumEachColor(nodeNum-1, 2));

        bw.write(minCost + "");
        bw.flush();
    }

    private static int getMin(int a, int b, int c) {
        int min = Math.min(a,b);
        return Math.min(c, min);
    }

    private static int getMinSumEachColor(int depth, int color) {
        if(dp[depth][color] == 0) {
//            int[] subMinColorSum = new int[2];
//            for (int i = 0; i < 3; i++) {
//                if (!isEqualColor(color, i)) {
//                    subMinColorSum[i] = dp[depth][i];
//                }
//            }
            dp[depth][RED] = Math.min(getMinSumEachColor(depth-1, GREEN), getMinSumEachColor(depth-1, BLUE)) + colorCosts[depth][RED];
            dp[depth][GREEN] = Math.min(getMinSumEachColor(depth-1, RED), getMinSumEachColor(depth-1, BLUE)) + colorCosts[depth][GREEN];
            dp[depth][BLUE] = Math.min(getMinSumEachColor(depth-1, RED), getMinSumEachColor(depth-1, GREEN)) + colorCosts[depth][BLUE];
        }
        return dp[depth][color];


    }

//    private static boolean isEqualColor(int nowColor, int beforeColor) {
//        return nowColor == beforeColor;
//    }
}

