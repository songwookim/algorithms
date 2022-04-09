import java.io.*;

public class M4948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        while (input != 0) {
            int startNum = input;
            int endNum = startNum * 2;
            int cnt = 0;

            int[] isCn = new int[endNum+1];

            isCn[0] = 1;
            isCn[1] = 1;

            for(int temp = 2; temp <= Math.sqrt(endNum); temp++){
                if(isCn[temp] == 1) continue;
                for(int tempPn = (int)Math.pow(temp,2); tempPn <= endNum; tempPn+=temp){
                    isCn[tempPn] = 1;
                }
            }
            for(int i = startNum+1; i <= endNum; i++){
                if(isCn[i] != 1) cnt++;
            }
            bw.write(cnt + "\n");
            bw.flush();

            input = Integer.parseInt(br.readLine());
        }
        bw.close();
        br.close();

    }
}
