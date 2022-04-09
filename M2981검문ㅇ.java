import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 주어진 조건을 이용해 새로운 식을 만들어 원하는 값에 대한 관계식을 만들어냄
// A/M과 B/M을 만족하는 M을 공약수라고 하며, 최대공약수를 구하면 모든 값에 대한 공약수를 구할 수 있다.
public class M2981검문ㅇ {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];

        for (int i = 0; i < N; i++) {
            int inputNum = Integer.parseInt(br.readLine());
            nums[i] = inputNum;
        }
        Arrays.sort(nums);

        int gcdValue = nums[1] - nums[0];
        for (int i = 2; i < N; i++) {
            int temp = nums[i] - nums[i - 1];
            gcdValue = gcd(gcdValue, temp);
        }

        for (int i = 2; i <= gcdValue; i++) {
            if (gcdValue % i == 0) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);

    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
