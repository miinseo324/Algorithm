import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        // 입출입 기록의 개수 n
        int n = Integer.parseInt(br.readLine().trim());
        HashSet<String> set = new HashSet<>((int)(n/0.75f+1));
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();
            String log = st.nextToken();

            // enter일 경우
            if (log.equals("enter") && !set.contains(name)) {
                set.add(name);
            } else if (log.equals("leave") && set.contains(name)){ // leave일 경우
                set.remove(name);
            }
        }
        // set을 List로 변환 후 collections.sort() / collections.reverseOrder() 사용해서 정렬
        List<String> result = new ArrayList<String>(set);
        Collections.sort(result, Collections.reverseOrder());

        for (String s : result) {
            sb.append(s).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
