import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class M10814나이순정렬_TreeMap {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        TreeMap<Integer, ArrayList<String>> treeMap = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            treeMap.computeIfAbsent(age, k -> new ArrayList<>());
            treeMap.get(age).add(name);
        }
        for (int age :
                treeMap.keySet()
        ) {
            for (String name : treeMap.get(age)
            ) {
                bw.write(age + " " + name + "\n");
            }
        }

        bw.flush();
    }
}
