package day241212;

import java.util.Scanner;

// 프로그래머스 각도기(120829)
/*
[문제 설명]
- 예각일 경우 1 return
- 직각일 경우 2 return
- 둔각일 경우 3 return
- 평각일 경우 4 return
*/
public class n120829 {

    private static int solution(int angle) {
        int answer = 0;
        if(angle > 0 && angle < 90) {
            answer = 1;
        }
        if(angle == 90) {
            answer = 2;
        }
        if(angle > 90 && angle < 180) {
            answer = 3;
        }
        if(angle == 180) {
            answer = 4;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int angle = 0;
        do {
            System.out.print("각도 입력 (0 < 각도 <= 180) : ");
            angle = sc.nextInt();
            if (angle <= 0 || angle > 180) {
                System.out.println("유효하지 않은 각도입니다. 다시 입력하세요.");
            }
        } while (angle <= 0 || angle > 180);

        int answer = solution(angle);
        System.out.println("답 : " + answer);
    }
}
