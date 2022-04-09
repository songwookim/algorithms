import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

public class M1181단어정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String input = br.readLine();

            arrayList.add(input);
        }

        arrayList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length())
                    return o1.compareTo(o2);
                return o1.length()-o2.length();
            }
        });

        String tempStr = arrayList.get(0);
        System.out.println(tempStr);
        arrayList.remove(0);
        for (String str: arrayList
             ) {
            if(tempStr.equals(str))
                continue;
            System.out.println(str);
            tempStr = str;
        }
    }
}
