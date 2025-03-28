package day250328;

import java.util.Scanner;

// 프로그래머스 피로도(87946)
/*
[문제 설명]
- 피로도를 사용해서 던전을 탐험합니다.
- 이 때 각 던전마다 탐험을 시작하기 위해 필요한 최소 피로도와 소모되는 소모 피로도가 있습니다.
- 하루에 한 번씩 탐험할 수 있는 던전이 여러개 있는데 한 유저가 이 던전들을 최대한 많이 탐험하려 합니다.
- 유저의 현재 피로도 k가 있고 최소, 소모 피로도가 담긴 2차원 배열 dungenons가 있을 때 탐험 가능한 최대 던전 수를 return 하시오.
*/
public class n87946 {

    private static int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        return dfs(0, k, dungeons, visited);
    }
    private static int dfs(int depth, int k, int[][] dungeons, boolean[] visited) {
        int maxCount = depth; // 현재까지 탐색한 던전 개수 저장

        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i] || dungeons[i][0] > k) continue; // 방문했거나 피로도가 부족하면 스킵

            visited[i] = true; // 방문 처리
            maxCount = Math.max(maxCount, dfs(depth + 1, k - dungeons[i][1], dungeons, visited));
            visited[i] = false; // 백트래킹 (다시 방문 가능하도록 초기화)
        }

        return maxCount;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("k : ");
        int k = sc.nextInt();

        // 행렬 clothes의 크기 입력
        System.out.print("clothes 행렬의 행 : ");
        int row = sc.nextInt();
        System.out.print("clothes 행렬의 열 : ");
        int col = sc.nextInt();

        int[][] dungenons = new int[row][col];
        System.out.println("dungenons 행렬의 의상을 입력하고 다음 행렬 칸에 부위를 입력합니다.");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("clothes["+ i +"]["+ j +"] : ");
                dungenons[i][j] = sc.nextInt();
            }
        }

        int result = solution(k, dungenons);
        System.out.print("답 : " + result);
    }
}
