package day250324;

import java.util.HashMap;
import java.util.Scanner;

// 프로그래머스 의상(42578)
/*
[문제 설명]
- 코니가 가진 의상들의 담긴 2차원 배열 clothes가 주어질 때 서로 다른 옷의 조합 수를 return 하시오.
- 단 부위 별 동일한 위치의 의상을 착용할 수 없습니다. (Ex. 동그란 안경, 선글라스 -> 동시 착용 불가)
*/
public class n42578 {

    private static int solution(String[][] clothes) {
        HashMap<String, Integer> typeMap = new HashMap<>();

        for (String[] cloth : clothes) {
            String type = cloth[1];
            typeMap.put(type, typeMap.getOrDefault(type, 0) + 1);
        }

        int result = 1;
        for (int count : typeMap.values()) {
            result *= (count + 1);
        }

        return result - 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 행렬 clothes의 크기 입력
        System.out.print("clothes 행렬의 행 : ");
        int row = sc.nextInt();
        System.out.print("clothes 행렬의 열 : ");
        int col = sc.nextInt();

        sc.nextLine(); // 개행문자 삭제

        String[][] clothes = new String[row][col];
        System.out.println("clothes 행렬의 의상을 입력하고 다음 행렬 칸에 부위를 입력합니다.");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("clothes["+ i +"]["+ j +"] : ");
                clothes[i][j] = sc.nextLine();
            }
        }

        int result = solution(clothes);
        System.out.print("답 : " + result);
    }
}
