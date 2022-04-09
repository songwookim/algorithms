import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class M10799쇠막대기 {
    private final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final static StringBuffer sb = new StringBuffer();
    private final static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        int size = input.length();
        int count = 0;
        int endCount = 0;
        char before = '(';
        stack.add('(');

        for (int i = 1; i < size; i++) {
            char tempInput = input.charAt(i);
            if (tempInput == '(') {
                stack.add(tempInput);
            } else {
                stack.pop();
                if (before == '(') {
                    count += (stack.size() + endCount);
                    endCount = 0;
                } else {
                    endCount++;
                }
            }
            before = tempInput;
        }
        sb.append(count + endCount);
        System.out.println(sb);
    }
}
