import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class M1874스택수열 {
    static ArrayList<Integer> stack;
    static int pointer = 1; // 다음 공간을 가리킴

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        stack = new ArrayList<>();
        stack.add(0);

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            // 4이고, 넣지 않은 숫자라면 push
            if (input >= pointer) {
                for (int j = pointer; j <= input; j++) {
                    push(j);
                    sb.append("+").append("\n");
                }
                stack.set(pointer - 1, null);
                sb.append("-").append("\n");
                continue;
            }

            boolean flag = false;
            for (int j = pointer - 1; j > input; j--) {
                if (stack.get(j) != null) {
                    sb = new StringBuilder();
                    sb.append("NO");
                    flag = true;
                    break;
                }
            }
            if (flag) break;

            stack.set(input, null);
            sb.append("-").append("\n");
        }
        System.out.println(sb);
    }

    private static void push(int n) {
        stack.add(n);
        pointer++;
    }

}
