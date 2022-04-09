import java.io.*;

public class M1541잃어버린괄호 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        int N = input.length();
        int[] dp = new int[N];
        int dpIdx = 0;
        int sum = 0;
        StringBuilder willBeConvertedString = new StringBuilder();
        for (int i = 0; i < N; i++) {
            char hi = input.charAt(i);

            if (hi == '+' || hi == '-') {
                sum += Integer.parseInt(willBeConvertedString.toString());
                if (hi == '-') {
                    dp[dpIdx] = sum;
                    sum = 0;
                    dpIdx++;
                }
                willBeConvertedString = new StringBuilder();
            } else {
                willBeConvertedString.append(hi);
            }
        }
        sum += Integer.parseInt(willBeConvertedString.toString());
        dp[dpIdx] = sum;
        dpIdx++;

        int result = dp[0];
        for (int i = 1; i < dpIdx; i++) {
            result -= dp[i];
        }

        bw.write(result + "");
        bw.flush();
    }
}
