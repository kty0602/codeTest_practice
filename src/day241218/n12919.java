package day241218;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 프로그래머스 서울에서 김서방 찾기(12919)
/*
[문제 해설]
- 배열 원소 중 "Kim"의 위치x를 찾아 "김서방은 x에 있다"는 String을 반환하는 함수
*/
public class n12919 {

    private static String solution(String[] seoul) {
        String answer = "";

        for(int i=0; i<seoul.length; i++) {
            if(seoul[i].equals("Kim")) {
                answer = "김서방은 " + i + "에 있다";
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> inputList = new ArrayList<>();
        int y = 1;

        System.out.println("배열 값 입력 (종료하려면 ! 입력) : ");
        while (true) {
            System.out.print(y+"번째 값 : ");
            String input = sc.nextLine();
            if (input.equals("!")) {
                break;
            }
            inputList.add(input);
            y++;
        }

        // List를 배열로 변환
        String[] seoul = inputList.toArray(new String[0]);

        // solution 호출 및 결과 출력
        String answer = solution(seoul);
        System.out.println(answer);
    }
}
