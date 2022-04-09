import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class M9375패션왕신혜빈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        HashMap<String, Integer> hashMap;
        int types;
        for (int i = 0; i < N; i++) {
            types = Integer.parseInt(br.readLine());
            int count = 1;
            hashMap = new HashMap<>();

            for (int j = 0; j < types; j++) {
                st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String type = st.nextToken();

                if (!hashMap.containsKey(type)) {
                    hashMap.put(type, 2);
                } else {
                    hashMap.replace(type, hashMap.get(type) + 1);
                }
            }
            for (Integer num : hashMap.values()) {
                count *= num;
            }
            sb.append(count - 1).append("\n");
        }
        System.out.print(sb);
    }
}
