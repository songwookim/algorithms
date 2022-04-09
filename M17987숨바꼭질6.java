import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class M17987숨바꼭질6 {
    private final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 동생 수
        int S = Integer.parseInt(st.nextToken()); // 수빈이 위치

        st = new StringTokenizer(br.readLine());
        int temp = Integer.parseInt(st.nextToken());
        int ans = Math.abs(S-temp);
        for (int i = 1; i < N; i++) {
            temp = Math.abs(S-Integer.parseInt(st.nextToken())); // 수빈이랑 상대적 거리
            ans = gcd(temp, ans);      // 최대공약수
        }

        sb.append(ans);
        System.out.println(sb);
    }

    private static int gcd(int po, int ans) {
        return ans == 0? po : gcd(ans, po%ans);
    }
}
