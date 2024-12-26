package day241226;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// 프로그래머스 k번째 수(42748)
/*
[문제 설명]
- 배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.

[예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면]
- array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]
- 1에서 나온 배열을 정렬하면 [2, 3, 5, 6]
- 2에서 나온 배열의 3번째 숫자는 5

- 배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때,
- commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return
*/
public class n42748 {

    private static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int a = 0; a < commands.length; a++) {
            int i = commands[a][0];
            int j = commands[a][1];
            int k = commands[a][2];

            int[] subArray = Arrays.copyOfRange(array, i-1, j);

            Arrays.sort(subArray);
            answer[a] = subArray[k-1];
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = 1;
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("number 배열 값을 하나씩 입력하세요. 입력을 종료하려면 '!'를 입력하세요.");
        while (true) {
            System.out.print(y + "번째 값 : ");
            String input = sc.nextLine();
            if (input.equals("!")) {
                break;
            }
            int number = Integer.parseInt(input);
            list.add(number);
            y++;
        }

        int[] array = list.stream().mapToInt(i -> i).toArray();

        System.out.print("행렬의 행 개수를 입력하세요 : ");
        int rows = sc.nextInt();

        int[][] commands = new int[rows][3];

        System.out.println("행렬의 값을 입력하세요 :");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("commands[" + i + "][" + j + "] = ");
                commands[i][j] = sc.nextInt();
            }
        }

        int[] answer = solution(array, commands);
        System.out.println("답 : " + Arrays.toString(answer));
    }
}
