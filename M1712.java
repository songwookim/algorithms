import java.io.*;
import java.util.StringTokenizer;

public class M1712 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long materialCost, personnelExpense, price, n;

        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        materialCost = Long.parseLong(st.nextToken());
        personnelExpense = Long.parseLong(st.nextToken());
        price = Long.parseLong(st.nextToken());

        if(personnelExpense >= price) {
            n = -1;
        } else {
            n = materialCost / (price-personnelExpense) + 1;
        }

        bw.write("" + n);
        br.close();
        bw.close();
    }
}
