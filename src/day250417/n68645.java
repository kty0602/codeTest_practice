package day250417;

import java.util.*;

// 프로그래머스 삼각 달팽이 (68645)
/*
[문제 설명]
- 정수 n이 매개변수로 주어질 때 밑변의 길이와 높이가 n인 삼각형을 만들고 꼭짓점부터 반시계 방향으로 숫자를 채운다.
- 이후 첫 행부터 마지막 행까지 모두 순서대로 합친 새로운 배열을 return 하여라.
*/
public class n68645 {

    private static int[] solution(int n) {
        int[][] arr = new int[n][n];
        int num = 1;
        int x = -1, y = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i % 3 == 0) x++;        // 아래로 이동
                else if (i % 3 == 1) y++;   // 오른쪽으로 이동
                else { x--; y--; }          // 대각선 위로 이동

                arr[x][y] = num++;
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                list.add(arr[i][j]);
            }
        }

        return list.stream().mapToInt(i -> i).toArray();
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("n : ");
        int n = sc.nextInt();

        int[] result = solution(n);
        System.out.print("답 : " + Arrays.toString(result));
    }
}
