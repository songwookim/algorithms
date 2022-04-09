import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class M9012괄호 {
    static ArrayList<String> stack;
    static int pointer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            stack = new ArrayList<>();
            pointer = 0;
            String input = br.readLine();
            int length = input.length();

            String result = "YES";

            for (int j = 0; j < length; j++) {
                if (input.charAt(j) == '(') {
                    push("(");
                    continue;
                } else if (pointer == 0) {
                    result = "NO";
                    break;
                }
                pop();
            }
            if (pointer != 0) result = "NO";

            System.out.println(result);
        }
    }

    private static void pop() {
        stack.remove(pointer - 1);
        pointer--;

    }

    private static void push(String n) {
        stack.add(n);
        pointer++;
    }

}
