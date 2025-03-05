package day250305;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// 프로그래머스 바탕화면 정리(161990)
/*
[문제 설명]
- 바탕화면은 각 칸이 정사각형인 격자판입니다. 빈칸은 ".", 파일이 있는 칸은 "#"의 값을 가집니다.
- 드래그하면 파일들을 선택할 수 있고 선택된 파일들을 삭제가 가능합니다. 최소한의 이동거리를 갖는 한 번의 드래그로 모든 파일을
- 선택해서 지우려고 하면 각 어떤 지점을 선택해야 하는지 return 하시오.
*/
public class n161990 {

    private static int[] solution(String[] wallpaper) {
        int lux = Integer.MAX_VALUE;
        int luy = Integer.MAX_VALUE;
        int rdx = Integer.MIN_VALUE;
        int rdy = Integer.MIN_VALUE;

        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    lux = Math.min(lux, i); // 가장 위쪽 x 좌표
                    luy = Math.min(luy, j); // 가장 왼쪽 y 좌표
                    rdx = Math.max(rdx, i); // 가장 아래쪽 x 좌표
                    rdy = Math.max(rdy, j); // 가장 오른쪽 y 좌표
                }
            }
        }

        return new int[]{lux, luy, rdx + 1, rdy + 1};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = 1;
        ArrayList<String> list = new ArrayList<>();
        System.out.println("wallpaper 배열 값을 하나씩 입력하세요. 입력을 종료하려면 '!'를 입력하세요.");
        while (true) {
            System.out.print(y + "번째 wallpaper 값 : ");
            String input = sc.nextLine();
            if (input.equals("!")) {
                break;
            }
            list.add(input);
            y++;
        }

        String[] wallpaper = list.stream().toArray(String[]::new);
        int[] result = solution(wallpaper);
        System.out.println("답 : " + Arrays.toString(result));
    }
}
