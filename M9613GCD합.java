import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class M9613GCD합 {
    private final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] nums = new int[n];

            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }
            long sum = 0;
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    int temp = gcd(nums[i], nums[j]);
                    sum = sum + temp;
                }
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }

    static int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }
}
