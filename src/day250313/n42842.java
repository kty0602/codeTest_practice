package day250313;

import java.util.*;

// 프로그래머스 카펫(42842)
/*
[문제 설명]
- 카펫의 노란색과 갈색으로 색칠된 격자의 갯수를 입력합니다.
- 하지만 카펫의 크기를 기억하지 못하므로 갯수에 의존하여 가로 세로 크기를 구해 return 해야합니다.
- 가로 길이는 세로와 같거나 깁니다.
*/
public class n42842 {

    private static int[] solution(int brown, int yellow) {
        int size = brown + yellow;

        for (int height = 1; height <= Math.sqrt(size); height++) {
            if (size % height == 0) {
                int width = size / height;

                if ((width - 2) * (height - 2) == yellow) {
                    return new int[]{width, height};
                }
            }
        }

        return new int[]{0, 0};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("갈색 격자 갯수 : ");
        int brown = sc.nextInt();
        System.out.print("노란색 격자 갯수 : ");
        int yellow = sc.nextInt();

        int[] result = solution(brown, yellow);
        System.out.println("답 : " + Arrays.toString(result));
    }
}
