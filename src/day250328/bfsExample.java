package day250328;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class bfsExample {
    static List<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) {
        int n = 6;
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

        System.out.print("BFS 탐색 순서: ");
        bfs(1);
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int next : graph[node]) {
                if (!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }
    }
}
