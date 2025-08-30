import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken()); // 듣도 못한 사람 수
        int m = Integer.parseInt(st.nextToken()); // 보도 못한 사람 수

        HashSet<String> set = new HashSet<>((int)(n/0.75f+1));
        List<String> result = new ArrayList<>();

        for (int i=0; i<n; i++) {
            set.add(br.readLine());
        }

        for (int i=0; i<m; i++) {
            String name = br.readLine();
            if (set.contains(name)) result.add(name);
        }

        Collections.sort(result);
        sb.append(result.size()).append("\n");

        for (String s: result) {
            sb.append(s).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}