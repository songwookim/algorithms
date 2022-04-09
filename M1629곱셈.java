import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class M1629곱셈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A, B, mod;
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        mod = Long.parseLong(st.nextToken());

        System.out.println(recur(A, B, mod));
    }

    private static long recur(long A, long B, long mod) {
        if (B == 1) return A % mod;
        long temp = recur(A, B / 2, mod);
        if (B % 2 == 1) {
            return (temp * temp % mod) * A % mod;
        }
        return temp * temp % mod;
    }
}
