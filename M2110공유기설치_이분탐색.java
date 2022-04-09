import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class M2110공유기설치_이분탐색 {
    // dp풀이도 가능해보임
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, C;
    private static int[] distance;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        distance = new int[N];
        for (int i = 0; i < N; i++) {
            distance[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(distance);
        int lo = 1, hi = distance[N-1] - distance[0] +1 ;

        while(lo < hi) {
            int mid = (lo+hi) /2; // 최소거리
            int count = 1;
            int temp = distance[0];
            for (int i = 1; i < N; i++) {
                if(mid <= distance[i] - temp) {
                    count++;
                    temp = distance[i];
                }
            }
            if(count < C) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        System.out.println(lo-1);
    }

}
