import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    static int[][] graph;
    static int n, m, start;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // n: 정점 개수, m: 간선 개수, start: 시작 정점
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        graph = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        // DFS
        dfs(start);
        sb.append('\n');

        Arrays.fill(visited, false);
        bfs(start);

        System.out.print(sb);
    }

    static void dfs(int cur) {
        visited[cur] = true;
        sb.append(cur).append(' ');

        for (int next = 1; next <= n; next++) {
            if (graph[cur][next] == 1 && !visited[next]) {
                dfs(next);
            }
        }
    }

    static void bfs(int s) {
        Deque<Integer> q = new ArrayDeque<>();
        visited[s] = true;
        q.add(s);

        while (!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur).append(' ');

            for (int next = 1; next <= n; next++) {
                if (graph[cur][next] == 1 && !visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
    }
}
