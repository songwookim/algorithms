import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class M17413단어합치기2_큐 {
    private final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final static StringBuffer sb = new StringBuffer();
    static Stack<Character> stack;

    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        int length = input.length();
        stack = new Stack<>();

        boolean flag = false;
        for (int i = 0; i < length; i++) {
            char tempInput = input.charAt(i);
            if (tempInput == '<') {
                flag = true;
                print();
                sb.append(tempInput);
                continue;
            } else if (tempInput == '>') {
                flag = false;
                sb.append(tempInput);
                continue;
            }

            if (!flag) {
                if (input.charAt(i) == ' ') {
                    print();
                    sb.append(tempInput);
                    continue;
                }
                stack.add(input.charAt(i));
            } else {
                sb.append(tempInput);
            }
        }
        print();
        System.out.println(sb);
    }

    private static void print() {
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            sb.append(stack.pop());
        }
        stack = new Stack<>();
    }
}
