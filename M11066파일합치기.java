import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 참고
// 1. https://developerbee.tistory.com/97
// 2. https://velog.io/@leeinae/Algorithm-%EB%B0%B1%EC%A4%8011066-%ED%8C%8C%EC%9D%BC-%ED%95%A9%EC%B9%98%EA%B8%B0-java
// kruth Optimizaiotn
public class M11066파일합치기 {
    private final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final static StringBuffer sb = new StringBuffer();
    private static int[] sum;
    private static int[][] dp;
    private static int num;
    private static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (N-- > 0) {
            num = Integer.parseInt(br.readLine());
            sum = new int[num];                      // 0~n까지 모두 더한 총합
            dp = new int[num][num];                  // i~j까지 파일의 최소값
            st = new StringTokenizer(br.readLine());

            sum[0] = Integer.parseInt(st.nextToken());
            for (int i = 1; i < num; i++) {
                int input = Integer.parseInt(st.nextToken());
                sum[i] = sum[i - 1] + input;
            }

            dp[0][1] = sum[1];
            for (int i = 2; i < num; i++) {
                dp[i - 1][i] = sum[i] - sum[i - 2]; // 01 12 23 .. 은 어차피 인접 파일이 최소값이니까 초기화 시키기
            }
            for (int i = 2; i < num; i++) {            // - 차이가 2칸인 것부터 시작해서 계산
                for (int j = 0; i + j < num; j++) {    // - 인접한 파일끼리 만들 수 있는 전체 조합 경우의 수 모두 고려,
                    for (int k = j; k < i + j; k++) {  //   그중에 최솟값을 저장한다.
                        int dist = j == 0 ? sum[i + j] : sum[i + j] - sum[j - 1];
                        if (dp[j][i + j] == 0) {
                            dp[j][i + j] = dp[j][k] + dp[k + 1][i + j] + dist;
                        } else {
                            dp[j][i + j] = Math.min(dp[j][i + j], dp[j][k] + dp[k + 1][i + j] + dist);
                        }
                    }
                }
            }
            sb.append(dp[0][num - 1]).append("\n");   // 결국은 1~(num-1)을 구하는 거고, 최솟값이 저장되어 있을 것임
        }
        System.out.println(sb);
    }
}