import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class M1300K번째수_이분탐색 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuffer sb = new StringBuffer();
    private static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        long K = Long.parseLong(br.readLine());

        long lo = 0, hi = K+1;
        long mid = 0;
        while(lo < hi) {
            mid = (lo+hi)/2;

            if(K > findNth(mid)) { // 얘가 몇 번째인지 ?
                lo = mid + 1;

            } else {
                hi = mid;

            }
        }
        System.out.println(lo);
    }

    private static long findNth(long mid) {
        int temp = 0;
        for (int i = 1; i <= N; i++) {
            temp += Math.min(mid/i,N);
        }
        return temp;
    }
}
