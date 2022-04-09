import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/17299
public class 오큰수 {
    private final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final static StringBuffer sb = new StringBuffer();
    private static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
//        int[] inputArr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < N; i++) {
//            int input = Integer.parseInt(st.nextToken());
//            inputArr[i] = input;
//        }
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());
            nums[i] = input;
            while (!stack.empty() && nums[stack.peek()] < input) {
                nums[stack.pop()] = input;
            }
            stack.add(i);
        }
        while (!stack.empty()) {
            nums[stack.pop()] = -1;
        }
        for (int i : nums) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
