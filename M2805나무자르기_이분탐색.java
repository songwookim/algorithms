import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class M2805나무자르기_이분탐색 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int max = Integer.MIN_VALUE;

        st = new StringTokenizer(br.readLine());
        int[] trees = new int[N];
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());
            trees[i] = input;
            max = Math.max(max, input);
        }

        int lo = 0, hi = max + 1, mid;
        long cutTreeLengthSum;
        while (lo < hi) {
            mid = (lo + hi) / 2;
            cutTreeLengthSum = 0;

            for (int i = 0; i < N; i++) {
                int tempSum = trees[i] - mid;
                cutTreeLengthSum += Math.max(tempSum, 0); // 음수 = 못 잘랐음
            }
            if (M > cutTreeLengthSum) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        sb.append(lo - 1);
        System.out.println(sb);
    }
}
