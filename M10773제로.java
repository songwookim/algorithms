import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class M10773제로 {
    static ArrayList<Integer> stack;
    static int pointer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        stack = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String command = br.readLine();
            if (command.equals("0")) {
                pop();
                continue;
            }
            int n = Integer.parseInt(command);
            push(n);
        }

        int count = 0;
        for(int num : stack) {
            count += num;
        }
        System.out.println(count);
    }
    private static void pop() {
        stack.remove(pointer-1);
        pointer--;

    }

    private static void push(int n) {
        stack.add(n);
        pointer++;
    }

}
