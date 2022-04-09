import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class M17299오등큰수 {
    private final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final static StringBuffer sb = new StringBuffer();
    static int[] F;   // 입력한 거 등장 횟수 저장
    static int[] NGF; // 결과로 출력할 값들 저장
    static Stack<Integer> stack = new Stack<>(); // index만 저장

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        F = new int[1000001];
        NGF = new int[N];
        int[] input = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            input[i] = temp;
            F[temp]++; // 등장 횟수 조회용
        }
        stack.push(0);
        for (int i = 1; i < N; i++) {
            if (F[input[stack.peek()]] < F[input[i]]) { // 등장 횟수가 스택 꼭대기보다 클 경우 
                while (!stack.empty() && F[input[stack.peek()]] < F[input[i]]) { 
                    NGF[stack.pop()] = input[i];  // 결괏값에 입력 숫자 저장
                }
            } 
            stack.push(i);
        }
        while (!stack.empty()) {
            NGF[stack.pop()] = -1;
        }
        for (int i : NGF) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
