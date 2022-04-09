import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class M1654랜선자르기_이분탐색 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuffer sb = new StringBuffer();
    private static long[] lans ;
    private static int K, N;
    public static void main(String[] args) throws IOException
    {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        lans = new long[N];

        long max = Integer.MIN_VALUE;
        for (int i = 0; i <N; i++) {
            int input = Integer.parseInt(br.readLine());
            lans[i] = input;
            max = Math.max(max, input);
        }

        System.out.println(upperBound(K, max+1));
    }

    private static long upperBound(int K, long hi) {
        long lo = 0;
        long mid ;
        while(lo < hi) {
            mid = (lo+hi)/2;

            if(K > getPartSum(mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo-1;
    }

    private static long getPartSum(long mid) {
        long sum = 0;
        for (int i = 0; i < N; i++) {
            sum += lans[i]/mid;
        }
        return sum;
    }
}
