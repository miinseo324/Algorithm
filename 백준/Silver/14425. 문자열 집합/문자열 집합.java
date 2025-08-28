import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 집합 s에 포함되어 있는 문자열
        arr = new String[n];
        int m = Integer.parseInt(st.nextToken()); // 검사해야 하는 문자열

        for (int i =0; i<n; i++) {
            arr[i] = br.readLine();
        }
        int cnt = 0;
        for (int i=0; i<m; i++) {
            String input = br.readLine();
            for (String text: arr) {
                if (text.equals(input)) {
                    cnt += 1;
                    break;
                }
            }
        }
        System.out.println(cnt);
        br.close();
    }
}
