import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class M1676팩토리얼0의개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int count = N/5 + N/25 + N/125;
        sb.append(count);
        System.out.print(sb);
    }

}
