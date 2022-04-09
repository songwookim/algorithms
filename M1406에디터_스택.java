import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// ListIterator
public class M1406에디터_스택 {
    private final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        String result = br.readLine();
        int N = Integer.parseInt(br.readLine());
        //LinkedList<Character> linkedList = new LinkedList<>();
        Stack<Character> stackL = new Stack<>();
        Stack<Character> stackR = new Stack<>();
        for (int i = 0; i < result.length(); i++) {
            stackR.add(result.charAt(i));
        }
        StringTokenizer st;
        String command;
        String input;

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            command = st.nextToken();
            switch (command) {
                case "D":
                    if (!stackL.isEmpty())
                        stackR.add(stackL.pop());
                    break;
                case "B":
                    if (!stackR.isEmpty()) {
                        stackR.pop();
                    }
                    break;
                case "L":
                    if (!stackR.isEmpty())
                        stackL.add(stackR.pop());
                    break;
                case "P":
                    input = st.nextToken();
                    char temp = input.charAt(0);
                    stackR.add(temp);
            }
        }
        while (!stackR.isEmpty()) {
            stackL.add(stackR.pop());
        }
        while (!stackL.isEmpty()) {
            sb.append(stackL.pop());
        }
        System.out.println(sb);
    }
}
