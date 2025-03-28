package day250328;

import java.util.*;

public class dfsExample {
    static List<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) {
        int n = 6; // 노드 개수
        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 그래프 연결 설정
        graph[1].add(2);
        graph[1].add(3);
        graph[2].add(4);
        graph[2].add(5);
        graph[3].add(6);

        System.out.print("DFS 탐색 순서: ");
        dfs(1);
    }

    static void dfs(int node) {
        if (visited[node]) return;  // 이미 방문한 노드면 종료

        visited[node] = true;
        System.out.print(node + " ");

        for (int next : graph[node])
            dfs(next);
    }
}
