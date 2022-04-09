import java.io.*;
import java.util.StringTokenizer;

public class M14888연산자끼워넣기 {
    static BufferedReader br;
    static BufferedWriter bw;
    static int[] operator;
    static int[] sortedOperatorIdx;
    static int[] numArr;
    static StringTokenizer st;
    static int N;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException, NumberFormatException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine()); // "6");
        numArr = new int[N];
        st = new StringTokenizer(br.readLine()); // "1 2 3 4 5 6");
        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        operator = new int[N - 1];
        st = new StringTokenizer(br.readLine());//br.readLine());
        //String inputOperator = br.readLine();//"2 1 1 1";
        int idx = 0;

        for (int i = 0; i < 4; i++) {
            int input = Integer.parseInt(st.nextToken());//String.valueOf(inputOperator.charAt(2*i)));
            while (input != 0) {
                operator[idx++] = i;
                input--;
            }
        }

        sortedOperatorIdx = new int[N - 1];
        minMax(0);
        bw.write(max + "\n" + min);
        bw.flush();
    }

    private static void minMax(int depth) {
        if (depth == N - 1) { // N-1 = operator의 갯수
            int result = numArr[0];
            for (int i = 1; i < N; i++) {
                int idx = sortedOperatorIdx[i - 1];
                int num = numArr[i];

                result = operate(result, num, operator[idx]); // 0~N-2 = 1~N-1

            }
            if (result > max) max = result;
            if (result < min) min = result;
            return;
        }
        for (int i = 0; i < N - 1; i++) {
            if (check(i, depth)) {
                sortedOperatorIdx[depth] = i; // 0~depth-1 = N-1
                minMax(depth + 1);
            }
            sortedOperatorIdx[depth] = -1;
        }
    }

    private static boolean check(int checkedIdx, int depth) {
        for (int i = 0; i < depth; i++) { // N-Queen과 같이 이전에 둔 부분의 가로 부분은 안됨 = 이런 인덱스 있었는지 확인
            if (sortedOperatorIdx[i] == checkedIdx)
                return false;
        }
        return true;
    }

    private static int operate(int num1, int num2, int op) {
        if (op == 0) {
            return num1 + num2;
        }
        if (op == 1) {
            return num1 - num2;
        }
        if (op == 2) {
            return num1 * num2;
        }
        return num1 / num2;
    }
}
