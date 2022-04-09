    import java.io.*;
    import java.util.*;

    public class M1157 {
        public static void main(String[] args) throws IOException {
            Collection<Integer> cntArr;
            int maxCnt;
            String maxChar;

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            String inputStr = br.readLine();

            String[] inputStrArr = inputStr.toUpperCase().split(""); // 각각의 글자로 대문자로 맹글어서 나누기

            Map<String,Integer> hashMap = new HashMap<>();

            for(int i =0 ; i < inputStrArr.length; i++) {
                String inputChar = inputStrArr[i] ;
                if(!hashMap.containsKey(inputChar)) {
                    hashMap.put(inputChar, 1);
                } else {
                    int cnt = hashMap.get( inputChar );
                    hashMap.replace( inputChar, ++cnt );
                }
            }

            cntArr = hashMap.values();
            maxCnt = Collections.max(cntArr);
            maxChar = "";

            int chkEqual = 0;

            Set<String> keys = hashMap.keySet();
            Iterator<String> iterator = keys.iterator();

            while(iterator.hasNext()) {
                String tempChar = iterator.next();
                int cnt = hashMap.get(tempChar);
                if(cnt == maxCnt) {
                    maxChar = tempChar;
                    chkEqual++;
                }
                if(chkEqual == 2) {
                    maxChar = "?";
                    break;
                }
            }
            bw.write(maxChar);
            bw.flush();

            br.close();
            bw.close();
        }
    }