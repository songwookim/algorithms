import java.io.*;

public class M9020 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int cnt = 0; cnt < T; cnt++) {

            int num = Integer.parseInt(br.readLine());

            int[] eratos = new int[num+2];
            eratos[0] = 1;
            eratos[1] = 1;

            for (int temp = 2; temp <= Math.sqrt(num); temp++) {
                if (eratos[temp] == 1) continue;
                for (int tempCn = temp * temp; tempCn <= num; tempCn += temp) {

                    eratos[tempCn] = 1;
                }
            }
            int a= num/2, b = num/2;

            while(eratos[a] != 0 || eratos[b] !=0) {
                b++;
                a--;
            }
            bw.write(a+ " "+ b + "\n");
            bw.flush();
        }
        bw.close();
        br.close();
    }
}
