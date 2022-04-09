import java.io.*;
import java.util.StringTokenizer;

public class M1929소수구하기_dp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int startNum = Integer.parseInt(st.nextToken());
        int endNum = Integer.parseInt(st.nextToken());

        int[] isCn = new int[endNum+1];

        isCn[0] = 1;
        isCn[1] = 1;

        for(int temp = 2; temp <= Math.sqrt(endNum); temp++){
            if(isCn[temp] == 1) continue;
            for(int tempPn = (int)Math.pow(temp,2); tempPn <= endNum; tempPn+=temp){
                isCn[tempPn] = 1;
            }
        }
        for(int i = startNum; i <= endNum; i++){
            if(isCn[i] != 1) bw.write(i + "\n");
        }
        bw.flush();

        bw.close();
        br.close();
    }
}
