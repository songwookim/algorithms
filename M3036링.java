import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class M3036링 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        for (int i = 1; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());
            int maxDividedNum = gcd(num, input);
            sb.append(num / maxDividedNum).append("/").append(input / maxDividedNum).append("\n");

        }

        System.out.println(sb);

    }
    private static int gcd(int a, int b) {
        return b == 0? a: gcd(b, a%b);
    }
}
